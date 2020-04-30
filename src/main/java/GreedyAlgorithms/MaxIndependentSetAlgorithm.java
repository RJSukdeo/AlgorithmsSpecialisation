package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public final class MaxIndependentSetAlgorithm {

    private final List<Long> weights;
    private final List<Long> maximumWeights;
    private final List<Integer> includedInMaximumSet;

    public MaxIndependentSetAlgorithm(List<Long> weights) {
        this.weights = weights;
        maximumWeights = new ArrayList<>(weights.size());
        includedInMaximumSet = new ArrayList<>(weights.size());
        for (int i = 0; i < weights.size(); i++) {
            includedInMaximumSet.add(0);
        }
    }

    public MaxIndependentSetAlgorithmResults run() {
        generateListMaximumValue();
        generateListIncludedInSet();
        return new MaxIndependentSetAlgorithmResults(this);
    }

    private void generateListMaximumValue() {
        maximumWeights.add(0L);
        maximumWeights.add(weights.get(0));
        for (int i = 2; i <= weights.size(); i++) {
            maximumWeights.add(i, Math.max(maximumWeights.get(i - 1), maximumWeights.get(i - 2) + weights.get(i - 1)));
        }
    }

    private void generateListIncludedInSet() {
        int i = weights.size();
        while (i > 1) {
            if (maximumWeights.get(i - 1) >= maximumWeights.get(i - 2) + weights.get(i - 1)) {
                i--;
            } else {
                includedInMaximumSet.set(i - 1, 1);
                i = i - 2;
            }
        }
        if (i == 1) {
            if (includedInMaximumSet.get(1) == 1) {
                includedInMaximumSet.set(i - 1, 0);
            } else {
                includedInMaximumSet.set(i - 1, 1);
            }
        }
    }

    List<Long> getMaximumWeights() {
        return maximumWeights;
    }

    List<Integer> getIncludedInMaximumSet() {
        return includedInMaximumSet;
    }
}
