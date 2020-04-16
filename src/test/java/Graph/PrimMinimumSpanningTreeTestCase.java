package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimMinimumSpanningTreeTestCase {

    @Test
    public void testRun() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputs());
        PrimMinimumSpanningTreeAlgorithmResults results = new PrimMinimumSpanningTreeAlgorithm(graphGenerator).run(0);
        assertEquals(37, results.getTreeLength());
        assertEquals(0, results.getOrderedVisitedNodes().get(0).getId());
        assertEquals(1, results.getOrderedVisitedNodes().get(1).getId());
        assertEquals(2, results.getOrderedVisitedNodes().get(2).getId());
        assertEquals(8, results.getOrderedVisitedNodes().get(3).getId());
        assertEquals(5, results.getOrderedVisitedNodes().get(4).getId());
        assertEquals(6, results.getOrderedVisitedNodes().get(5).getId());
        assertEquals(7, results.getOrderedVisitedNodes().get(6).getId());
        assertEquals(3, results.getOrderedVisitedNodes().get(7).getId());
        assertEquals(4, results.getOrderedVisitedNodes().get(8).getId());
    }

    private UndirectedGraphInputs getGraphInputs() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        builder.addEntry(0, 1, 4);
        builder.addEntry(1, 2, 8);
        builder.addEntry(2, 3, 7);
        builder.addEntry(3, 4, 9);
        builder.addEntry(4, 5, 10);
        builder.addEntry(5, 6, 2);
        builder.addEntry(6, 7, 1);
        builder.addEntry(7, 8, 7);
        builder.addEntry(0, 7, 8);
        builder.addEntry(1, 7, 11);
        builder.addEntry(2, 8, 2);
        builder.addEntry(8, 6, 6);
        builder.addEntry(2, 5, 4);
        builder.addEntry(3, 5, 14);
        return builder.build();
    }

}
