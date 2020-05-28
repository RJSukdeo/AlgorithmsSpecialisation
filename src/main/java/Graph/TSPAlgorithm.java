package Graph;

import Combinatorics.CombinatoricsUtil;

import java.util.*;

// Travelling salesman problem. Assumes node ids start from 1 and are consecutive. Maximum number of nodes 32, using bit masking.
public final class TSPAlgorithm {

    private static final double MAX_VALUE = 100000000;
    private static final int STARTING_NODE_ID = 1;
    private final Map<Integer, Node> nodeIdToNodeMap;
    private Map<MatrixIndex, Double> currentResults;
    private Map<MatrixIndex, Double> oldResults;
    private double minDistance = MAX_VALUE;

    public TSPAlgorithm(final UndirectedGraphGenerator graphGenerator) {
        Set<Node> initialNodes = graphGenerator.getNodes(true);
        nodeIdToNodeMap = new HashMap<>(initialNodes.size());
        currentResults = new HashMap<>();
        oldResults = new HashMap<>();
        populateMaps(initialNodes, oldResults, nodeIdToNodeMap, initialNodes.size());
    }

    public TSPAlgorithmResults run() {
        for (int m = STARTING_NODE_ID + 1; m <= nodeIdToNodeMap.keySet().size(); m++) {
            System.out.println("m: " + m);
            Integer[] nodeIds = getCombinationsWithoutStartingNode().toArray(new Integer[0]);
            List<Set<Integer>> allPossibleCombinations = CombinatoricsUtil.getAllPossibleCombinations(nodeIds, m - 1);
            currentResults = new HashMap<>((m - 1) * allPossibleCombinations.size());
            for (final Set<Integer> combination : allPossibleCombinations) {
                combination.add(STARTING_NODE_ID);
                for (final int finalNodeId : combination) {
                    if (finalNodeId != STARTING_NODE_ID) {
                        // A[s,j]
                        MatrixIndex matrixIndex = new MatrixIndex(combination, finalNodeId, nodeIdToNodeMap.keySet().size());
//                        System.out.println("Matrix Index: " + matrixIndex.hash);
                        double matrixValue = getOptimalValue(combination, oldResults, finalNodeId);
//                        System.out.println("Matrix Value: " + matrixValue);
                        if (currentResults.containsKey(matrixIndex)) {
                            System.out.println("Duplicate index detected.");
//                            System.out.println("New value: " + matrixValue);
//                            System.out.println("Old value: " + currentResults);
                            outputDuplicateInformation(matrixIndex, matrixValue);
                        }
                        currentResults.put(matrixIndex, matrixValue);
                    }
                }
            }
            oldResults = new HashMap<>(currentResults);
        }
        calcMinDistance();
        return new TSPAlgorithmResults(this);
    }

    private void outputDuplicateInformation(MatrixIndex matrixIndex, double matrixValue) {
//        System.out.println("New Set: " + matrixIndex.pathSet);
        System.out.println("New Destination: " + matrixIndex.destinationId);
        System.out.println("New Value: " + matrixValue);
        System.out.println("New Hash: " + matrixIndex.hash);
        System.out.println();
        for (MatrixIndex index : currentResults.keySet()) {
            if (index.hash == matrixIndex.hash) {
//                System.out.println("Old Set: " + index.pathSet);
                System.out.println("Old Destination: " + index.destinationId);
                System.out.println("Old Value: " + currentResults.get(index));
                System.out.println("Old Hash: " + index.hash);
            }
        }

    }

    double getShortestDistance() {
        return minDistance;
    }

    private Set<Integer> getCombinationsWithoutStartingNode() {
        Set<Integer> tempNodeIds = new HashSet<>(nodeIdToNodeMap.keySet());
        tempNodeIds.remove(STARTING_NODE_ID);
        return tempNodeIds;
    }

    private double getOptimalValue(final Set<Integer> combination, final Map<MatrixIndex, Double> resultMatrix, final int finalNodeId) {
        double minValue = MAX_VALUE;
        for (int penUltimateNodeId : combination) {
            if (penUltimateNodeId != finalNodeId) {
                double length = nodeIdToNodeMap.get(penUltimateNodeId).getConnectedEdges().stream().filter(edge -> edge.containsNode(nodeIdToNodeMap.get(finalNodeId))).findFirst().get().getLength();
                Set<Integer> adjustedSet = new HashSet<>(combination);
                adjustedSet.remove(finalNodeId);
                MatrixIndex index = new MatrixIndex(adjustedSet, penUltimateNodeId, nodeIdToNodeMap.keySet().size());
                if (resultMatrix.containsKey(index)) {
                    minValue = Math.min(minValue, resultMatrix.get(index) + length);
                }
            }
        }
        return minValue;
    }

    private void populateMaps(final Set<Node> nodes, final Map<MatrixIndex, Double> oldResults, final Map<Integer, Node> nodeIdToNodeMap, int numNodes) {
        for (Node node : nodes) {
            nodeIdToNodeMap.put(node.getId(), node);
            oldResults.put(new MatrixIndex(Collections.singleton(node.getId()), STARTING_NODE_ID, numNodes), MAX_VALUE);
        }
        oldResults.put(new MatrixIndex(Collections.singleton(STARTING_NODE_ID), STARTING_NODE_ID, numNodes), 0.0);
    }

    private void calcMinDistance() {
        int destinationId = STARTING_NODE_ID;
        for (Integer nodeId : nodeIdToNodeMap.keySet()) {
            if (nodeId != STARTING_NODE_ID) {
                MatrixIndex index = new MatrixIndex(nodeIdToNodeMap.keySet(), nodeId, nodeIdToNodeMap.keySet().size());
                double value = currentResults.get(index);
                if (value < minDistance) {
                    minDistance = value;
                    destinationId = index.getDestinationId();
                }
            }
        }
        Node node = nodeIdToNodeMap.get(destinationId);
        double lengthOfFinalEdge = node.getConnectedEdges().stream().filter(e -> e.containsNode(nodeIdToNodeMap.get(STARTING_NODE_ID))).findFirst().get().getLength();
        minDistance += lengthOfFinalEdge;
    }

    private static class MatrixIndex {

        private final int hash;
        private final int destinationId;

        private MatrixIndex(Set<Integer> pathSet, int destinationId, int numNodes) {
            this.destinationId = destinationId;
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

        int getDestinationId() {
            return destinationId;
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

    private static class Path {

        private final List<Edge> edges;
        private double distance;

        public Path(double distance, List<Edge> edges) {
            this.distance = distance;
            this.edges = edges;
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public double getDistance() {
            return distance;
        }

    }

}
