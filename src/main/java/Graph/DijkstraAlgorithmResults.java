package Graph;

import java.util.HashMap;
import java.util.Map;

public final class DijkstraAlgorithmResults {

    private final DijkstraAlgorithm algorithm;

    DijkstraAlgorithmResults(DijkstraAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public double getDistanceToNode(int nodeId) {
        return algorithm.getNodeToDistanceMap().get(algorithm.getNodeIdToNodeMap().get(nodeId));
    }

    public Map<Integer, Double> getNodeIdToDistanceMap() {
        Map<Node, Double> nodeToDistanceMap = algorithm.getNodeToDistanceMap();
        Map<Integer, Node> nodeIdToNodeMap = algorithm.getNodeIdToNodeMap();
        Map<Integer, Double> nodeIdToDistanceMap = new HashMap<>(nodeToDistanceMap.keySet().size());
        for (Node node : nodeToDistanceMap.keySet()) {
            nodeIdToDistanceMap.put(node.getId(), nodeToDistanceMap.get(nodeIdToNodeMap.get(node.getId())));
        }
        return nodeIdToDistanceMap;
    }

}
