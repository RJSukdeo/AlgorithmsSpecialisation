package Graph;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class BellmanFordAlgorithmTestCase {

    @Test
    public void testExample1() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        builder.addEntries(GraphTestData.getDirectedGraphInputs7());
        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm(DirectedGraphGenerator.getGenerator(builder.build()));
        BellmanFordAlgorithmResults results = algorithm.run(0);
        Map<Integer, Long> map = results.getShortestDistances();
        assertEquals(6, (long) map.get(4));
        assertEquals(2, (long) map.get(5));
        assertEquals(3, (long) map.get(1));
        assertEquals(9, (long) map.get(2));
        assertEquals(4, (long) map.get(6));
        assertEquals(8, (long) map.get(3));
    }

    @Test
    public void testExample2() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        builder.addEntries(GraphTestData.getDirectedGraphInputs8());
        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm(DirectedGraphGenerator.getGenerator(builder.build()));
        BellmanFordAlgorithmResults results = algorithm.run(0);
        Map<Integer, Long> map = results.getShortestDistances();
        assertEquals(0, (long) map.get(0));
        assertEquals(-1, (long) map.get(1));
        assertEquals(2, (long) map.get(2));
        assertEquals(-2, (long) map.get(3));
        assertEquals(1, (long) map.get(4));
    }

    @Test
    public void testExample3() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        builder.addEntries(GraphTestData.getDirectedGraphInputs9());
        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm(DirectedGraphGenerator.getGenerator(builder.build()));
        BellmanFordAlgorithmResults results = algorithm.run(0);
        Map<Integer, Long> map = results.getShortestDistances();
        assertTrue(map.isEmpty());
    }

}
