package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class ClusteringAlgorithmTestCase {

    @Test
    public void testExample() {
        ClusteringAlgorithm algorithm = new ClusteringAlgorithm(getGraphInput());
        ClusteringAlgorithmResults results = algorithm.run(3);
        assertEquals(results.getMinDistanceBetweenClusters(), 13.0, 10e-1);
        assertEquals(results.getTotalDistanceBetweenClusters(), 27.0, 10e-1);
    }

    private static UndirectedGraphInputs getGraphInput() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(0, 1, 1);
        builder.addEntry(1, 2, 4);
        builder.addEntry(0, 2, 6);
        builder.addEntry(2, 3, 14);
        builder.addEntry(3, 4, 11);
        builder.addEntry(3, 5, 5);
        builder.addEntry(3, 6, 8);
        builder.addEntry(7, 6, 3);
        builder.addEntry(6, 8, 2);
        builder.addEntry(6, 9, 7);
        builder.addEntry(9, 10, 4);
        builder.addEntry(9, 11, 13);
        return builder.build();
    }

}
