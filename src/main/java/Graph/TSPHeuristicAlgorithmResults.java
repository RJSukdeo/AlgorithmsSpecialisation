package Graph;

public final class TSPHeuristicAlgorithmResults {

    private TSPHeuristicAlgorithm algorithm;

    TSPHeuristicAlgorithmResults(TSPHeuristicAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public double getMinimumDistance() {
        return algorithm.getMinimumDistance();
    }

}
