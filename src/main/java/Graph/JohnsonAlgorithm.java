package Graph;

import java.util.*;

public final class JohnsonAlgorithm {

    private final DirectedGraphInputs graphInputs;
    private final Map<Integer, Map<Integer, Long>> allNodeIdToResultMap;
    private boolean negativeCycleDetected;
    private int newNodeId;

    public JohnsonAlgorithm(DirectedGraphInputs graphInputs) {
        this.graphInputs = graphInputs;
        allNodeIdToResultMap = new HashMap<>();
        adjustGraphInputs();
    }

    public JohnsonAlgorithmResults run() {
        Map<Integer, Long> nodeIdToDistanceMap = getReweightingMap();
        detectNegativeCycles(nodeIdToDistanceMap);
        if (!negativeCycleDetected) {
            DirectedGraphGenerator graphGenerator = generateNewGraph(nodeIdToDistanceMap);
            for (Node node : graphGenerator.getNodes(true)) {
                if (node.getId() != newNodeId) {
                    DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graphGenerator);
                    DijkstraAlgorithmResults results = algorithm.run(node.getId());
                    Map<Integer, Long> resultMap = revertWeights(node.getId(), results.getNodeIdToDistanceMap(), nodeIdToDistanceMap, algorithm.getUnreachableDistanceValue());
                    allNodeIdToResultMap.put(node.getId(), resultMap);
                }
            }
        }
        return new JohnsonAlgorithmResults(this);
    }

    private Map<Integer, Long> revertWeights(Integer sourceNodeId, Map<Integer, Double> dijkstraResultMap, Map<Integer, Long> nodeIdToDistanceMap, double dijkstraUnreachableDistance) {
        Map<Integer, Long> originalWeights = new HashMap<>(dijkstraResultMap.keySet().size());
        for (Integer nodeId : dijkstraResultMap.keySet()) {
            if (dijkstraResultMap.get(nodeId).longValue() == dijkstraUnreachableDistance) {
                originalWeights.put(nodeId, dijkstraResultMap.get(nodeId).longValue());
            } else {
                long changedDistance = dijkstraResultMap.get(nodeId).longValue() - nodeIdToDistanceMap.get(sourceNodeId) + nodeIdToDistanceMap.get(nodeId);
                originalWeights.put(nodeId, changedDistance);
            }
        }
        return originalWeights;
    }

    private DirectedGraphGenerator generateNewGraph(Map<Integer, Long> nodeIdToDistanceMap) {
        DirectedGraphInputs.InputBuilder inputBuilder = new DirectedGraphInputs.InputBuilder();
        for (NodeKey nodeKey : graphInputs.getEdgeInputContainer().getNodes()) {
            if (!nodeKey.getNodeIds().contains(newNodeId)) {
                List<Integer> nodeIds = nodeKey.getNodeIds();
                double oldEdgeLength = graphInputs.getEdgeInputContainer().getLength(nodeIds.get(0), nodeIds.get(1)).getLength();
                double newEdgeLength = oldEdgeLength + nodeIdToDistanceMap.get(nodeIds.get(0)) - nodeIdToDistanceMap.get(nodeIds.get(1));
                inputBuilder.addEntry(nodeIds.get(0), nodeIds.get(1), (int) newEdgeLength);
            }
        }
        return DirectedGraphGenerator.getGenerator(inputBuilder.build());
    }

    boolean isNegativeCycleDetected() {
        return negativeCycleDetected;
    }

    // Use Bellman-Ford to determine new weights and detect any negative cycles.
    private Map<Integer, Long> getReweightingMap() {
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGenerator(graphInputs);
        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm(graphGenerator);
        BellmanFordAlgorithmResults bellmanFordAlgorithmResults = bellmanFordAlgorithm.run(newNodeId);
        return bellmanFordAlgorithmResults.getShortestDistances();
    }

    private void detectNegativeCycles(Map<Integer, Long> nodeIdToDistanceMap) {
        negativeCycleDetected = nodeIdToDistanceMap.isEmpty();
    }

    // Adds new node and length zero edges.
    private void adjustGraphInputs() {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MaxComparator());
        Set<Integer> nodeIds = new HashSet<>();
        for (NodeKey nodeKey : graphInputs.getEdgeInputContainer().getNodes()) {
            List<Integer> nodes = nodeKey.getNodeIds();
            for (Integer node : nodes) {
                if (!nodeIds.contains(node)) {
                    nodeIds.add(node);
                    heap.add(node);
                }
            }
        }
        newNodeId = heap.poll() + 1;
        for (Integer nodeId : nodeIds) {
            graphInputs.getEdgeInputContainer().addEntry(newNodeId, nodeId, 0);
        }
    }

    Map<Integer, Map<Integer, Long>> getResultMap() {
        return allNodeIdToResultMap;
    }

    private class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer t1, Integer t2) {
            return t2 - t1;
        }
    }

}
