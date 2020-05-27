package Graph;

public final class TSPAlgorithmResults {

    private final TSPAlgorithm algorithm;

    TSPAlgorithmResults(TSPAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public double getShortestDistance() {
        return algorithm.getShortestDistance();
    }

}
