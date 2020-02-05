package Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static Graph.DirectedGraphInputs.InputBuilder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class DepthFirstTestCase {

    @Test
    public void testRunSingleStartedNode() {
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(new InputBuilder().addEntries(GraphTestData.getReversedDirectedGraphInputs()).build());
        DepthFirstSearchAlgorithm algorithm = new DepthFirstSearchAlgorithm(graphGenerator);
        DepthFirstSearchResult result = algorithm.run(9);

        assertEquals(3, result.getOrderedNodeIds().size());
        assertEquals(8, (long) result.getOrderedNodeIds().get(0));
        assertEquals(7, (long) result.getOrderedNodeIds().get(1));
        assertEquals(9, (long) result.getOrderedNodeIds().get(2));
        int node = result.getLeaderToGraphSize().keySet().stream().findFirst().get();
        assertEquals(9, node);
        assertEquals(3, (long) result.getLeaderToGraphSize().get(node));

        result = algorithm.run(7);

        assertEquals(3, result.getOrderedNodeIds().size());
        assertEquals(9, (long) result.getOrderedNodeIds().get(0));
        assertEquals(8, (long) result.getOrderedNodeIds().get(1));
        assertEquals(7, (long) result.getOrderedNodeIds().get(2));
        node = result.getLeaderToGraphSize().keySet().stream().findFirst().get();
        assertEquals(7, node);
        assertEquals(3, (long) result.getLeaderToGraphSize().get(node));

        result = algorithm.run(8);

        assertEquals(3, result.getOrderedNodeIds().size());
        assertEquals(7, (long) result.getOrderedNodeIds().get(0));
        assertEquals(9, (long) result.getOrderedNodeIds().get(1));
        assertEquals(8, (long) result.getOrderedNodeIds().get(2));
        node = result.getLeaderToGraphSize().keySet().stream().findFirst().get();
        assertEquals(8, (long) node);
        assertEquals(3, (long) result.getLeaderToGraphSize().get(node));

        result = algorithm.run(6);

        assertEquals(6, result.getOrderedNodeIds().size());
        assertEquals(5, (long) result.getOrderedNodeIds().get(0));
        assertEquals(1, (long) result.getOrderedNodeIds().get(1));
        assertEquals(8, (long) result.getOrderedNodeIds().get(2));
        assertEquals(7, (long) result.getOrderedNodeIds().get(3));
        assertEquals(9, (long) result.getOrderedNodeIds().get(4));
        assertEquals(6, (long) result.getOrderedNodeIds().get(5));
        node = result.getLeaderToGraphSize().keySet().stream().findFirst().get();
        assertEquals(6, node);
        assertEquals(6, (long) result.getLeaderToGraphSize().get(node));

        result = algorithm.run(3);

        assertEquals(9, result.getOrderedNodeIds().size());
        assertEquals(2, (long) result.getOrderedNodeIds().get(0));
        assertEquals(1, (long) result.getOrderedNodeIds().get(1));
        assertEquals(8, (long) result.getOrderedNodeIds().get(2));
        assertEquals(7, (long) result.getOrderedNodeIds().get(3));
        assertEquals(9, (long) result.getOrderedNodeIds().get(4));
        assertEquals(6, (long) result.getOrderedNodeIds().get(5));
        assertEquals(5, (long) result.getOrderedNodeIds().get(6));
        assertEquals(4, (long) result.getOrderedNodeIds().get(7));
        assertEquals(3, (long) result.getOrderedNodeIds().get(8));
        node = result.getLeaderToGraphSize().keySet().stream().findFirst().get();
        assertEquals(3, (long) node);
        assertEquals(9, (long) result.getLeaderToGraphSize().get(node));
    }

    @Test
    public void testRunAllRandomNodes() {
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(new InputBuilder().addEntries(GraphTestData.getReversedDirectedGraphInputs()).build());
        DepthFirstSearchResult result = new DepthFirstSearchAlgorithm(graphGenerator).run();

        assertEquals(9, result.getOrderedNodeIds().size());
    }

    @Test
    public void testRunCertainNodes() {
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(new InputBuilder().addEntries(GraphTestData.getReversedDirectedGraphInputs()).build());
        List<Integer> nodeIds = new ArrayList<>(9);
        nodeIds.add(9);
        nodeIds.add(6);
        nodeIds.add(4);
        DepthFirstSearchResult result = new DepthFirstSearchAlgorithm(graphGenerator).run(nodeIds);

        assertEquals(9, result.getOrderedNodeIds().size());
        assertEquals(8, (long) result.getOrderedNodeIds().get(0));
        assertEquals(7, (long) result.getOrderedNodeIds().get(1));
        assertEquals(9, (long) result.getOrderedNodeIds().get(2));
        assertEquals(5, (long) result.getOrderedNodeIds().get(3));
        assertEquals(1, (long) result.getOrderedNodeIds().get(4));
        assertEquals(6, (long) result.getOrderedNodeIds().get(5));
        assertEquals(3, (long) result.getOrderedNodeIds().get(6));
        assertEquals(2, (long) result.getOrderedNodeIds().get(7));
        assertEquals(4, (long) result.getOrderedNodeIds().get(8));
        assertEquals(3, result.getLeaderToGraphSize().size());
        assertEquals(3, (long) result.getLeaderToGraphSize().get(9));
        assertEquals(3, (long) result.getLeaderToGraphSize().get(6));
        assertEquals(3, (long) result.getLeaderToGraphSize().get(4));
        assertTrue(result.getLeaderToGraphSize().containsKey(9));
        assertTrue(result.getLeaderToGraphSize().containsKey(6));
        assertTrue(result.getLeaderToGraphSize().containsKey(4));
    }

}
