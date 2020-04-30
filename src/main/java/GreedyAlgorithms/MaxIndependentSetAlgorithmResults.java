package GreedyAlgorithms;

import java.util.List;

public final class MaxIndependentSetAlgorithmResults {

    private final MaxIndependentSetAlgorithm algorithm;

    MaxIndependentSetAlgorithmResults(MaxIndependentSetAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<Long> getMaximumWeights() {
        return algorithm.getMaximumWeights();
    }

    public List<Integer> getIncludedInMaximumSet() {
        return algorithm.getIncludedInMaximumSet();
    }

}
