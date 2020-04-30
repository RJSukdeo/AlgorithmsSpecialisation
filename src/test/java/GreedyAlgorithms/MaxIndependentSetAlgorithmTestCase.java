package GreedyAlgorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class MaxIndependentSetAlgorithmTestCase {

    @Test
    public void testExample() {
        List<Long> weights = new ArrayList<>(4);
        weights.add(1L);
        weights.add(4L);
        weights.add(5L);
        weights.add(4L);
        MaxIndependentSetAlgorithm algorithm = new MaxIndependentSetAlgorithm(weights);
        MaxIndependentSetAlgorithmResults results = algorithm.run();
        List<Long> maximumWeights = results.getMaximumWeights();
        List<Integer> includedInMaximumSet = results.getIncludedInMaximumSet();
        assertEquals(8L, (long) maximumWeights.get(maximumWeights.size() - 1));
        assertEquals(0, (int) includedInMaximumSet.get(0));
        assertEquals(1, (int) includedInMaximumSet.get(1));
        assertEquals(0, (int) includedInMaximumSet.get(2));
        assertEquals(1, (int) includedInMaximumSet.get(3));
    }

}
