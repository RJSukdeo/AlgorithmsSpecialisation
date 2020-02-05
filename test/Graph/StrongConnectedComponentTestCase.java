package Graph;

import org.junit.Test;

import static Graph.DirectedGraphInputs.InputBuilder;
import static org.junit.Assert.assertEquals;

public final class StrongConnectedComponentTestCase {

    @Test
    public void testRunGraph1() {
        DirectedGraphInputs inputs = new InputBuilder().addEntries(GraphTestData.getDirectedGraphInputs1()).build();
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputs);
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();

        assertEquals(3, results.getSccSizes().size());
        assertEquals(3, (long) results.getSccSizes().get(0));
        assertEquals(3, (long) results.getSccSizes().get(1));
        assertEquals(3, (long) results.getSccSizes().get(2));
    }

    @Test
    public void testRunGraph2() {
        InputBuilder inputBuilder = new InputBuilder();
        inputBuilder.addEntries(GraphTestData.getDirectedGraphInputs2());
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputBuilder.build());
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();

        assertEquals(3, results.getSccSizes().size());
        assertEquals(1, (long) results.getSccSizes().get(0));
        assertEquals(1, (long) results.getSccSizes().get(1));
        assertEquals(3, (long) results.getSccSizes().get(2));
    }

    @Test
    public void testRunGraph3() {
        InputBuilder inputBuilder = new InputBuilder();
        inputBuilder.addEntries(GraphTestData.getDirectedGraphInputs3());
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputBuilder.build());
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();

        assertEquals(3, results.getSccSizes().size());
        assertEquals(1, (long) results.getSccSizes().get(0));
        assertEquals(1, (long) results.getSccSizes().get(1));
        assertEquals(3, (long) results.getSccSizes().get(2));
    }

    @Test
    public void testRunGraph4() {
        InputBuilder inputBuilder = new InputBuilder();
        inputBuilder.addEntries(GraphTestData.getDirectedGraphInputs4());
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputBuilder.build());
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();

        assertEquals(4, results.getSccSizes().size());
        assertEquals(1, (long) results.getSccSizes().get(0));
        assertEquals(1, (long) results.getSccSizes().get(1));
        assertEquals(1, (long) results.getSccSizes().get(2));
        assertEquals(4, (long) results.getSccSizes().get(3));
    }

    @Test
    public void testRunGraph5() {
        InputBuilder inputBuilder = new InputBuilder();
        inputBuilder.addEntries(GraphTestData.getDirectedGraphInputs5());
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputBuilder.build());
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();

        assertEquals(3, results.getSccSizes().size());
        assertEquals(2, (long) results.getSccSizes().get(0));
        assertEquals(3, (long) results.getSccSizes().get(1));
        assertEquals(3, (long) results.getSccSizes().get(2));
    }

    @Test
    public void testRunGraph6() {
        InputBuilder inputBuilder = new InputBuilder();
        inputBuilder.addEntries(GraphTestData.getDirectedGraphInputs6());
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputBuilder.build());
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();

        assertEquals(4, results.getSccSizes().size());
        assertEquals(1, (long) results.getSccSizes().get(0));
        assertEquals(2, (long) results.getSccSizes().get(1));
        assertEquals(3, (long) results.getSccSizes().get(2));
        assertEquals(3, (long) results.getSccSizes().get(3));
    }
}
