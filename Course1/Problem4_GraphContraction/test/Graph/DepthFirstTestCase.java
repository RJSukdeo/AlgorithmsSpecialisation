package Graph;

import org.junit.Test;

import static Graph.DirectedGraphInputs.InputBuilder;
import static org.junit.Assert.assertEquals;

public class DepthFirstTestCase {

    @Test
    public void testRunSingleStartedNode() {
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(new InputBuilder().addEntries(GraphTestData.getDirectedGraphInputs()).build());
        DepthFirstSearchAlgorithm algorithm = new DepthFirstSearchAlgorithm(graphGenerator);
        DepthFirstSearchResult result = algorithm.run(9);

        assertEquals(3, result.getVisitedNodes().size());
        assertEquals(8, (long) result.getVisitedNodes().get(0));
        assertEquals(7, (long) result.getVisitedNodes().get(1));
        assertEquals(9, (long) result.getVisitedNodes().get(2));

        result = algorithm.run(7);

        assertEquals(3, result.getVisitedNodes().size());
        assertEquals(9, (long) result.getVisitedNodes().get(0));
        assertEquals(8, (long) result.getVisitedNodes().get(1));
        assertEquals(7, (long) result.getVisitedNodes().get(2));

        result = algorithm.run(8);

        assertEquals(3, result.getVisitedNodes().size());
        assertEquals(7, (long) result.getVisitedNodes().get(0));
        assertEquals(9, (long) result.getVisitedNodes().get(1));
        assertEquals(8, (long) result.getVisitedNodes().get(2));

        result = algorithm.run(6);

        assertEquals(6, result.getVisitedNodes().size());
        assertEquals(5, (long) result.getVisitedNodes().get(0));
        assertEquals(1, (long) result.getVisitedNodes().get(1));
        assertEquals(8, (long) result.getVisitedNodes().get(2));
        assertEquals(7, (long) result.getVisitedNodes().get(3));
        assertEquals(9, (long) result.getVisitedNodes().get(4));
        assertEquals(6, (long) result.getVisitedNodes().get(5));

        result = algorithm.run(3);

        assertEquals(9, result.getVisitedNodes().size());
        assertEquals(2, (long) result.getVisitedNodes().get(0));
        assertEquals(1, (long) result.getVisitedNodes().get(1));
        assertEquals(8, (long) result.getVisitedNodes().get(2));
        assertEquals(7, (long) result.getVisitedNodes().get(3));
        assertEquals(9, (long) result.getVisitedNodes().get(4));
        assertEquals(6, (long) result.getVisitedNodes().get(5));
        assertEquals(5, (long) result.getVisitedNodes().get(6));
        assertEquals(4, (long) result.getVisitedNodes().get(7));
        assertEquals(3, (long) result.getVisitedNodes().get(8));
    }

}
