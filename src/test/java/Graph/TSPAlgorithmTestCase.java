package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TSPAlgorithmTestCase {

    @Test
    public void testExample1() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample1());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(80.0, results.getShortestDistance(), 1e-1);
    }

    @Test
    public void testExample2() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputsExample2());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        assertEquals(550.0, results.getShortestDistance(), 1e-1);
    }

    private static UndirectedGraphInputs getGraphInputsExample1() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(1, 2, 10);
        builder.addEntry(2, 3, 35);
        builder.addEntry(3, 1, 15);
        builder.addEntry(2, 4, 25);
        builder.addEntry(3, 4, 30);
        builder.addEntry(1, 4, 20);
        return builder.build();
    }

    private static UndirectedGraphInputs getGraphInputsExample2() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(1, 2, 75.0);
        builder.addEntry(1, 5, 100.0);
        builder.addEntry(2, 3, 50.0);
        builder.addEntry(3, 4, 100.0);
        builder.addEntry(4, 5, 50.0);
        builder.addEntry(2, 5, 125.0);
        builder.addEntry(2, 4, 125.0);
        builder.addEntry(1, 3, 100.0);
        builder.addEntry(1, 4, 300.0);
        builder.addEntry(3, 5, 75.0);
        return builder.build();
    }

}
