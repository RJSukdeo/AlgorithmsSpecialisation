package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class StrongConnectedComponentTestCase {

    @Test
    public void testRun() {
        DirectedGraphInputs inputs = new DirectedGraphInputs.InputBuilder().addEntries(GraphTestData.getDirectedGraphInputs()).build();
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputs);
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();

        assertEquals(3, results.getSccSizes().size());
        assertEquals(3, (long) results.getSccSizes().get(0));
        assertEquals(3, (long) results.getSccSizes().get(1));
        assertEquals(3, (long) results.getSccSizes().get(2));
    }

}
