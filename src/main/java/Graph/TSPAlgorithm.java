package Graph;

import Combinatorics.CombinatoricsUtil;

import java.util.*;

// Travelling salesman problem. Assumes node ids start from 1 and are consecutive. Maximum number of nodes 16, using bit masking, need space for set S and destination nodeId.
public final class TSPAlgorithm {

    private static final double MAX_VALUE = 100000000;
    private static final int STARTING_NODE_ID = 1;
    private final Map<Integer, Node> nodeIdToNodeMap;
    private Map<MatrixIndex, GraphPath> currentResults;
    private Map<MatrixIndex, GraphPath> oldResults;
    private GraphPath minGraph;

    public TSPAlgorithm(final UndirectedGraphGenerator graphGenerator) {
        Set<Node> initialNodes = graphGenerator.getNodes(true);
        nodeIdToNodeMap = new HashMap<>(initialNodes.size());
        currentResults = new HashMap<>();
        oldResults = new HashMap<>();
        minGraph = new GraphPath(STARTING_NODE_ID, initialNodes.size() - 1);
        populateMaps(initialNodes, oldResults, nodeIdToNodeMap, initialNodes.size());
    }

    public TSPAlgorithmResults run() {
        for (int m = STARTING_NODE_ID + 1; m <= nodeIdToNodeMap.keySet().size(); m++) {
            Integer[] nodeIds = getCombinationsWithoutStartingNode().toArray(new Integer[0]);
            List<Set<Integer>> allPossibleCombinations = CombinatoricsUtil.getAllPossibleCombinations(nodeIds, m - 1);
            currentResults = new HashMap<>((m - 1) * allPossibleCombinations.size());
            for (final Set<Integer> combination : allPossibleCombinations) {
                combination.add(STARTING_NODE_ID);
                for (final int finalNodeId : combination) {
                    if (finalNodeId != STARTING_NODE_ID) {
                        currentResults.put(new MatrixIndex(combination, finalNodeId, nodeIdToNodeMap.keySet().size()), getOptimalValue(combination, oldResults, finalNodeId));
                    }
                }
            }
            oldResults = new HashMap<>(currentResults);
        }
        calcMinDistance();
        return new TSPAlgorithmResults(this);
    }

    double getShortestDistance() {
        return minGraph.getPathLength();
    }

    List<Integer> getNodePath() {
        return minGraph.getNodePath();
    }

    private Set<Integer> getCombinationsWithoutStartingNode() {
        Set<Integer> tempNodeIds = new HashSet<>(nodeIdToNodeMap.keySet());
        tempNodeIds.remove(STARTING_NODE_ID);
        return tempNodeIds;
    }

    private GraphPath getOptimalValue(final Set<Integer> combination, final Map<MatrixIndex, GraphPath> resultMatrix, final int finalNodeId) {
        double minValue = MAX_VALUE;
        GraphPath optimalPath = new GraphPath(STARTING_NODE_ID, combination.size() - 1);
        for (int penUltimateNodeId : combination) {
            if (penUltimateNodeId != finalNodeId) {
                Edge finalEdge = nodeIdToNodeMap.get(penUltimateNodeId).getConnectedEdges().stream().filter(edge -> edge.containsNode(nodeIdToNodeMap.get(finalNodeId))).findFirst().get();
                double length = finalEdge.getLength();
                Set<Integer> adjustedSet = new HashSet<>(combination);
                adjustedSet.remove(finalNodeId);
                MatrixIndex index = new MatrixIndex(adjustedSet, penUltimateNodeId, nodeIdToNodeMap.keySet().size());
                if (resultMatrix.containsKey(index)) {
                    GraphPath previousPath = resultMatrix.get(index);
                    double optimalValue = previousPath.getPathLength() + length;
                    if (optimalValue < minValue) {
                        minValue = optimalValue;
                        optimalPath = new GraphPath(STARTING_NODE_ID, combination.size() - 1);
                        optimalPath.setPathLength(optimalValue);
                        optimalPath.addEdge(previousPath.getEdges());
                        optimalPath.addEdge(finalEdge);
                    }
                }
            }
        }
        return optimalPath;
    }

    private void populateMaps(final Set<Node> nodes, final Map<MatrixIndex, GraphPath> oldResults, final Map<Integer, Node> nodeIdToNodeMap, int numNodes) {
        GraphPath path;
        for (Node node : nodes) {
            path = new GraphPath(STARTING_NODE_ID, numNodes - 1);
            path.setPathLength(MAX_VALUE);
            nodeIdToNodeMap.put(node.getId(), node);
            oldResults.put(new MatrixIndex(Collections.singleton(node.getId()), STARTING_NODE_ID, numNodes), path);
        }
        path = new GraphPath(STARTING_NODE_ID, numNodes - 1);
        path.setPathLength(0.0);
        oldResults.put(new MatrixIndex(Collections.singleton(STARTING_NODE_ID), STARTING_NODE_ID, numNodes), path);
    }

    private void calcMinDistance() {
        double minDistance = MAX_VALUE;
        List<Edge> minNodePath = new ArrayList<>();
        for (Integer nodeId : nodeIdToNodeMap.keySet()) {
            if (nodeId != STARTING_NODE_ID) {
                MatrixIndex index = new MatrixIndex(nodeIdToNodeMap.keySet(), nodeId, nodeIdToNodeMap.keySet().size());
                double pathValues = currentResults.get(index).getPathLength();
                Edge finalEdge = nodeIdToNodeMap.get(nodeId).getConnectedEdges().stream().filter(e -> e.containsNode(nodeIdToNodeMap.get(STARTING_NODE_ID))).findFirst().get();
                double lengthOfFinalEdge = finalEdge.getLength();
                double totalLength = pathValues + lengthOfFinalEdge;
                if (totalLength < minDistance) {
                    minDistance = totalLength;
                    minNodePath = currentResults.get(index).getEdges();
                    minNodePath.add(finalEdge);
                }
            }
        }
        minGraph = new GraphPath(STARTING_NODE_ID, nodeIdToNodeMap.keySet().size());
        minGraph.setPathLength(minDistance);
        minGraph.addEdge(minNodePath);
    }

    private static class MatrixIndex {

        private final int hash;

        private MatrixIndex(Set<Integer> pathSet, int destinationId, int numNodes) {
            this.hash = generateHash(pathSet, destinationId, numNodes);
        }

        private int generateHash(Set<Integer> pathSet, int destinationId, int numNodes) {
            int mask = 0b0;
            for (int element : pathSet) {
                mask = mask | (1 << element);
            }
            mask = mask | (1 << (numNodes + destinationId));
            return mask;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MatrixIndex index = (MatrixIndex) o;
            return hash == index.hash;
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }

    private static class GraphPath {

        private final List<Edge> edges;
        private final int startNodeId;
        private double pathLength;

        public GraphPath(int startNodeId, int numEdges) {
            this.startNodeId = startNodeId;
            this.edges = new ArrayList<>(numEdges);
            this.pathLength = 0;
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        public void addEdge(List<Edge> edges) {
            this.edges.addAll(edges);
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void setPathLength(double pathLength) {
            this.pathLength = pathLength;
        }

        public double getPathLength() {
            return pathLength;
        }

        public List<Integer> getNodePath() {
            List<Integer> nodePath = new ArrayList<>(edges.size() + 1);
            nodePath.add(startNodeId);
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                for (Node node : edge.getEncompassingNodes()) {
                    if (node.getId() != nodePath.get(i)) {
                        nodePath.add(node.getId());
                    }
                }
            }
            return nodePath;
        }
    }

}
