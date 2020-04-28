package Graph;

public final class HammingClusteringAlgorithmResult {

    private HammingClusteringAlgorithm algorithm;

    HammingClusteringAlgorithmResult(HammingClusteringAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int getClusters() {
        return algorithm.getNumberOfClusters();
    }

}
