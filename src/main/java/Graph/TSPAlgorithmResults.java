package Graph;

import java.util.List;

public final class TSPAlgorithmResults {

    private final TSPAlgorithm algorithm;

    TSPAlgorithmResults(TSPAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public double getShortestDistance() {
        return algorithm.getShortestDistance();
    }

    public List<Integer> getNodePath() {
        return algorithm.getNodePath();
    }

}
