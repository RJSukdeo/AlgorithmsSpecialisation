package DistinctPairIndentifier;

public final class TwoSumAlgorithmResults {

    private final TwoSumAlgorithm algorithm;

    public TwoSumAlgorithmResults(final TwoSumAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int getNoDistinctPairs() {
        return algorithm.getNumDistinctPairs();
    }

}
