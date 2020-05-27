package Graph;

import Combinatorics.CombinatoricsUtil;

import java.util.*;

// Travelling salesman problem. Assumes node ids start from 1 and are consecutive.
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
        populateMaps(initialNodes, oldResults, nodeIdToNodeMap);
    }

    public TSPAlgorithmResults run() {
        for (int m = STARTING_NODE_ID + 1; m <= nodeIdToNodeMap.keySet().size(); m++) {
            long startTime = System.currentTimeMillis();
            System.out.println("m: " + m);
            Integer[] nodeIds = getCombinationsWithoutStartingNode().toArray(new Integer[0]);
            List<Set<Integer>> allPossibleCombinations = CombinatoricsUtil.getAllPossibleCombinations(nodeIds, m - 1);
            currentResults = new HashMap<>((m - 1) * allPossibleCombinations.size());
            long startTimeOptimalValues = System.currentTimeMillis();
            for (Set<Integer> combination : allPossibleCombinations) {
                combination.add(STARTING_NODE_ID);
                for (int finalNodeId : combination) {
                    if (finalNodeId != STARTING_NODE_ID) {
                        // A[s,j]
                        currentResults.put(new MatrixIndex(combination, finalNodeId), getOptimalValue(combination, oldResults, finalNodeId));
                    }
                }
            }
            System.out.println("Time taken to run all optimal values: " + (System.currentTimeMillis() - startTimeOptimalValues)/1000.0);
            long startTimeMap = System.currentTimeMillis();
            oldResults = new HashMap<>(currentResults);
            System.out.println("Time to taken to copy map: " + (System.currentTimeMillis() - startTimeMap)/1000.0);
            System.out.println("Time taken to run subproblem: " + (System.currentTimeMillis() - startTime)/1000.0);
            System.out.println();
        }
        calcMinDistance();
        return new TSPAlgorithmResults(this);
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
                MatrixIndex index = new MatrixIndex(adjustedSet, penUltimateNodeId);
                if (resultMatrix.containsKey(index)) {
                    double matrixValue = resultMatrix.get(index);
                    minValue = Math.min(minValue, matrixValue + length);
                }
            }
        }
        return minValue;
    }

    private void populateMaps(final Set<Node> nodes, final Map<MatrixIndex, Double> oldResults, final Map<Integer, Node> nodeIdToNodeMap) {
        for (Node node : nodes) {
            nodeIdToNodeMap.put(node.getId(), node);
            oldResults.put(new MatrixIndex(Collections.singleton(node.getId()), STARTING_NODE_ID), MAX_VALUE);
        }
        oldResults.put(new MatrixIndex(Collections.singleton(STARTING_NODE_ID), STARTING_NODE_ID), 0.0);
    }

    private void calcMinDistance() {
        int destinationId = STARTING_NODE_ID;
        for (Integer nodeId : nodeIdToNodeMap.keySet()) {
            if (nodeId != STARTING_NODE_ID) {
                MatrixIndex index = new MatrixIndex(nodeIdToNodeMap.keySet(), nodeId);
                if (currentResults.get(index) < minDistance) {
                    minDistance = currentResults.get(index);
                    destinationId = index.getDestinationId();
                }
            }
        }
        Node node = nodeIdToNodeMap.get(destinationId);
        double lengthOfFinalEdge = node.getConnectedEdges().stream().filter(e -> e.containsNode(nodeIdToNodeMap.get(STARTING_NODE_ID))).findFirst().get().getLength();
        minDistance += lengthOfFinalEdge;
    }

    private static class MatrixIndex {

        private Set<Integer> pathSet;
        private Set<Integer> destinationSet;

        public MatrixIndex(Set<Integer> pathSet, int destinationId) {
            this.pathSet = pathSet;
            destinationSet = new HashSet<>(1);
            destinationSet.add(destinationId);
        }

        public Integer getDestinationId() {
            Iterator<Integer> iterator = destinationSet.iterator();
            return iterator.next();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MatrixIndex that = (MatrixIndex) o;
            return Objects.equals(pathSet, that.pathSet) &&
                    Objects.equals(destinationSet, that.destinationSet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pathSet, destinationSet);
        }

    }

}
