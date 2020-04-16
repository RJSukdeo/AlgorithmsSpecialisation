package Graph;

public final class DijkstraAlgorithmResults {

    private final DijkstraAlgorithm algorithm;

    public DijkstraAlgorithmResults(DijkstraAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public double getDistanceToNode(int nodeId) {
        return algorithm.getNodeToDistanceMap().get(algorithm.getNodeIdToNodeMap().get(nodeId));
    }

}
