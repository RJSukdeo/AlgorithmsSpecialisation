package DynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public final class KnapSackAlgorithmTestCase {

    @Test
    public void testExample() {
        int[] values = new int[]{10, 40, 30, 50};
        int[] weights = new int[]{5, 4, 6, 3};
        int maxWeight = 10;
        KnapSackAlgorithm algorithm = new KnapSackAlgorithm(new KnapSackData(maxWeight, weights, values));
        KnapSackAlgorithmResults results = algorithm.run();
        Assert.assertEquals(90, results.getOptimalValue());
    }

    private List<KnapSackEntry> getEntries() {
        List<KnapSackEntry> entries = new ArrayList<>(4);
        entries.add(new KnapSackEntry(5, 10));
        entries.add(new KnapSackEntry(4, 40));
        entries.add(new KnapSackEntry(6, 30));
        entries.add(new KnapSackEntry(3, 50));
        return entries;
    }

}
