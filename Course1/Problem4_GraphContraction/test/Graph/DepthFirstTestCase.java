package Graph;

import org.junit.Assert;
import org.junit.Test;

import static Graph.DirectedGraphInputs.*;

public class DepthFirstTestCase {

    @Test
    public void testRun() {
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(new InputBuilder().addEntries(GraphTestData.getDirectedGraphInputs()).build());
        DepthFirstSearchAlgorithm algorithm = new DepthFirstSearchAlgorithm(graphGenerator, 9);
        DepthFirstSearchResult result = algorithm.getResult();

        Assert.assertEquals(3, result.getVisitedNodes().size());
        Assert.assertEquals(8, (long) result.getVisitedNodes().get(0));
        Assert.assertEquals(7, (long) result.getVisitedNodes().get(1));
        Assert.assertEquals(9, (long) result.getVisitedNodes().get(2));
    }

}
