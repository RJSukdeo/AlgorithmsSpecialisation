package Graph;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class JohnsonAlgorithmTestCase {

    @Test
    public void testExample1() {
        JohnsonAlgorithm algorithm = new JohnsonAlgorithm(getDataExample1());
        JohnsonAlgorithmResults results = algorithm.run();
        Map<Integer, Map<Integer, Long>> resultMap = results.getNodeIdToResultMap();
        assertEquals(0, (long) resultMap.get(1).get(1));
        assertEquals(-2, (long) resultMap.get(1).get(2));
        assertEquals(-3, (long) resultMap.get(1).get(3));
        assertEquals(-1, (long) resultMap.get(1).get(4));
        assertEquals(-6, (long) resultMap.get(1).get(5));
        assertEquals(1000000, (long) resultMap.get(1).get(6));
        assertEquals(3, (long) resultMap.get(2).get(1));
        assertEquals(0, (long) resultMap.get(2).get(2));
        assertEquals(-1, (long) resultMap.get(2).get(3));
        assertEquals(1, (long) resultMap.get(2).get(4));
        assertEquals(-4, (long) resultMap.get(2).get(5));
        assertEquals(1000000, (long) resultMap.get(2).get(6));
        assertEquals(4, (long) resultMap.get(3).get(1));
        assertEquals(2, (long) resultMap.get(3).get(2));
        assertEquals(0, (long) resultMap.get(3).get(3));
        assertEquals(2, (long) resultMap.get(3).get(4));
        assertEquals(-3, (long) resultMap.get(3).get(5));
        assertEquals(1000000, (long) resultMap.get(3).get(6));
        assertEquals(1000000, (long) resultMap.get(4).get(1));
        assertEquals(1000000, (long) resultMap.get(4).get(2));
        assertEquals(1000000, (long) resultMap.get(4).get(3));
        assertEquals(0, (long) resultMap.get(4).get(4));
        assertEquals(1000000, (long) resultMap.get(4).get(5));
        assertEquals(1000000, (long) resultMap.get(4).get(6));
        assertEquals(1000000, (long) resultMap.get(5).get(1));
        assertEquals(1000000, (long) resultMap.get(5).get(2));
        assertEquals(1000000, (long) resultMap.get(5).get(3));
        assertEquals(1000000, (long) resultMap.get(5).get(4));
        assertEquals(0, (long) resultMap.get(5).get(5));
        assertEquals(1000000, (long) resultMap.get(5).get(6));
        assertEquals(1000000, (long) resultMap.get(6).get(1));
        assertEquals(1000000, (long) resultMap.get(6).get(2));
        assertEquals(1000000, (long) resultMap.get(6).get(3));
        assertEquals(1, (long) resultMap.get(6).get(4));
        assertEquals(-4, (long) resultMap.get(6).get(5));
        assertEquals(0, (long) resultMap.get(6).get(6));
        assertFalse(results.getShortestShortestPath().isEmpty());
        assertTrue(results.getShortestShortestPath().isPresent());
    }

    // Testing with graph with negative cycle.
    @Test
    public void testexample2() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        JohnsonAlgorithm algorithm = new JohnsonAlgorithm(builder.addEntries(GraphTestData.getDirectedGraphInputs9()).build());
        JohnsonAlgorithmResults results = algorithm.run();
        assertTrue(results.getShortestShortestPath().isEmpty());
        assertFalse(results.getShortestShortestPath().isPresent());
    }

    private static DirectedGraphInputs getDataExample1() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        builder.addEntry(1, 2, -2);
        builder.addEntry(2, 3, -1);
        builder.addEntry(3, 1, 4);
        builder.addEntry(3, 5, -3);
        builder.addEntry(3, 4, 2);
        builder.addEntry(6, 4, 1);
        builder.addEntry(6, 5, -4);
        return builder.build();
    }

}
