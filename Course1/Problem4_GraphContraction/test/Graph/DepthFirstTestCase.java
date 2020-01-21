package Graph;

import org.junit.Test;

import static Graph.DirectedGraphInputs.InputBuilder;
import static org.junit.Assert.assertEquals;

public class DepthFirstTestCase {

    @Test
    public void testRunSingleStartedNode() {
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(new InputBuilder().addEntries(GraphTestData.getDirectedGraphInputs()).build());
        DepthFirstSearchAlgorithm algorithm = new DepthFirstSearchAlgorithm(graphGenerator, 9);
        DepthFirstSearchResult result = algorithm.getResult();

        assertEquals(3, result.getVisitedNodes().size());
        assertEquals(8, (long) result.getVisitedNodes().get(0));
        assertEquals(7, (long) result.getVisitedNodes().get(1));
        assertEquals(9, (long) result.getVisitedNodes().get(2));

        algorithm = new DepthFirstSearchAlgorithm(graphGenerator, 7);
        result = algorithm.getResult();

        assertEquals(3, result.getVisitedNodes().size());
        assertEquals(9, (long) result.getVisitedNodes().get(0));
        assertEquals(8, (long) result.getVisitedNodes().get(1));
        assertEquals(7, (long) result.getVisitedNodes().get(2));

        algorithm = new DepthFirstSearchAlgorithm(graphGenerator, 8);
        result = algorithm.getResult();

        assertEquals(3, result.getVisitedNodes().size());
        assertEquals(7, (long) result.getVisitedNodes().get(0));
        assertEquals(9, (long) result.getVisitedNodes().get(1));
        assertEquals(8, (long) result.getVisitedNodes().get(2));

        algorithm = new DepthFirstSearchAlgorithm(graphGenerator, 6);
        result = algorithm.getResult();

        assertEquals(6, result.getVisitedNodes().size());
        assertEquals(5, (long) result.getVisitedNodes().get(0));
        assertEquals(1, (long) result.getVisitedNodes().get(1));
        assertEquals(8, (long) result.getVisitedNodes().get(2));
        assertEquals(7, (long) result.getVisitedNodes().get(3));
        assertEquals(9, (long) result.getVisitedNodes().get(4));
        assertEquals(6, (long) result.getVisitedNodes().get(5));

        algorithm = new DepthFirstSearchAlgorithm(graphGenerator, 3);
        result = algorithm.getResult();

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
