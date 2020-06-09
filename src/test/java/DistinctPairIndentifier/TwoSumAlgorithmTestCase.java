package DistinctPairIndentifier;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class TwoSumAlgorithmTestCase {

    @Test
    public void testRun() {
        List<Long> testElements = new ArrayList<>(6);
        testElements.add(-3L);
        testElements.add(-2L);
        testElements.add(0L);
        testElements.add(2L);
        testElements.add(3L);
        testElements.add(4L);

        TwoSumAlgorithm algorithm = TwoSumAlgorithm.getInstance(testElements);
        TwoSumAlgorithmResults results = algorithm.run(0);

        assertEquals(2, results.getNoDistinctPairs());

        testElements = new ArrayList<>(9);
        testElements.add(-3L);
        testElements.add(-1L);
        testElements.add(1L);
        testElements.add(2L);
        testElements.add(9L);
        testElements.add(11L);
        testElements.add(7L);
        testElements.add(6L);
        testElements.add(2L);

        int counter = 0;
        algorithm = TwoSumAlgorithm.getInstance(testElements);
        for (int i = 3; i < 11; i++) {
            if (algorithm.run(i).getNoDistinctPairs() > 0) {
                counter++;
            }
        }
        assertEquals(8, counter);
    }

}
