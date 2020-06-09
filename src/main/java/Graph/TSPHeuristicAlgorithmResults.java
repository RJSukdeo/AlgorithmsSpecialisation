package Graph;

public final class TSPHeuristicAlgorithmResults {

    private TSPHeuristicAlgorithmNoGraphGenerator algorithm;

    TSPHeuristicAlgorithmResults(TSPHeuristicAlgorithmNoGraphGenerator algorithm) {
        this.algorithm = algorithm;
    }

    public double getMinimumDistance() {
        return algorithm.getMinimumDistance();
    }

}
