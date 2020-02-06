package Graph;

import org.junit.Test;

import java.util.*;

import static Graph.UndirectedGraphInputs.InputBuilder;
import static org.junit.Assert.*;

public final class UndirectedGraphGeneratorTestCase {

    @Test
    public void testGetGeneratorUndirected() {
        UndirectedGraphGenerator undirectedGraphGenerator = UndirectedGraphGenerator.getGeneratorUndirected(new InputBuilder().addEntries(GraphTestData.getUndirectedGraphInputs()).build());
        Set<Node> nodes = undirectedGraphGenerator.getNodes(false);
        Collection<UndirectedEdge> undirectedEdges = undirectedGraphGenerator.getEdges(false);

        assertEquals(4, nodes.size());
        assertEquals(5, undirectedEdges.size());
        assertTrue(nodes.contains(new Node(1)));
        assertTrue(nodes.contains(new Node(2)));
        assertTrue(nodes.contains(new Node(3)));
        assertTrue(nodes.contains(new Node(4)));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(1), new Node(2))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(2), new Node(3))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(3), new Node(4))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(1), new Node(4))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(1), new Node(3))));
    }

    @Test
    public void testGetGeneratorUndirectedWithLengthZero() {
        InputBuilder builder = new InputBuilder();
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGeneratorUndirected(builder.addEntries(GraphTestData.getUndirectedGraphInputs()).build());
        Set<Node> nodes = graphGenerator.getNodes(false);
        Collection<UndirectedEdge> undirectedEdges = graphGenerator.getEdges(false);

        assertEquals(4, nodes.size());
        assertEquals(5, undirectedEdges.size());
        assertTrue(nodes.contains(new Node(1)));
        assertTrue(nodes.contains(new Node(2)));
        assertTrue(nodes.contains(new Node(3)));
        assertTrue(nodes.contains(new Node(4)));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(1), new Node(2))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(2), new Node(3))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(3), new Node(4))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(1), new Node(4))));
        assertTrue(undirectedEdges.contains(new UndirectedEdge(new Node(1), new Node(3))));

        undirectedEdges.forEach(edge -> assertEquals(0.0, edge.getLength(), 1e-1));
    }

    @Test
    public void testGetGeneratorUndirectedWithNonZeroLength() {
        InputBuilder builder = new InputBuilder();
        Map<Integer, List<Integer>> nodeMap = GraphTestData.getUndirectedGraphInputs();
        for (Integer nodeId : nodeMap.keySet()) {
            for (Integer secondNodeId : nodeMap.get(nodeId)) {
                builder.addEntry(nodeId, secondNodeId, 2);
            }
        }
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGeneratorUndirected(builder.build());
        Set<Node> nodes = graphGenerator.getNodes(false);
        Collection<UndirectedEdge> edges = graphGenerator.getEdges(false);

        assertEquals(4, nodes.size());
        assertEquals(5, edges.size());
        assertTrue(nodes.contains(new Node(1)));
        assertTrue(nodes.contains(new Node(2)));
        assertTrue(nodes.contains(new Node(3)));
        assertTrue(nodes.contains(new Node(4)));
        assertTrue(edges.contains(new UndirectedEdge(new Node(1), new Node(2))));
        assertTrue(edges.contains(new UndirectedEdge(new Node(2), new Node(3))));
        assertTrue(edges.contains(new UndirectedEdge(new Node(3), new Node(4))));
        assertTrue(edges.contains(new UndirectedEdge(new Node(1), new Node(4))));
        assertTrue(edges.contains(new UndirectedEdge(new Node(1), new Node(3))));

        edges.forEach(edge -> assertEquals(2, edge.getLength(), 1e-2));
    }

}
