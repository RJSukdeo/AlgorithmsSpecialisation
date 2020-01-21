package Graph;

import org.junit.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphGeneratorTestCase {

    @Test
    public void testGetGeneratorUndirected() {
        GraphGenerator graphGenerator = GraphGenerator.getGeneratorUndirected(new UndirectedGraphInputs.InputBuilder().addEntries(GraphTestData.getUndirectedGraphInputs()).build());
        Set<Node> nodes = graphGenerator.getNodes(false);
        Collection<Edge> undirectedEdges = graphGenerator.getEdges(false);

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
    public void testGetGeneratorDirected() {
        GraphGenerator graphGenerator = GraphGenerator.getGeneratorDirected(new DirectedGraphInputs.InputBuilder().addEntries(GraphTestData.getDirectedGraphInputs()).build());
        Set<Node> nodes = graphGenerator.getNodes(false);
        Collection<Edge> edges = graphGenerator.getEdges(false);

        assertEquals(9, nodes.size());
        assertEquals(11, edges.size());

        assertTrue(nodes.contains(new Node(1)));
        assertTrue(nodes.contains(new Node(2)));
        assertTrue(nodes.contains(new Node(3)));
        assertTrue(nodes.contains(new Node(4)));
        assertTrue(nodes.contains(new Node(5)));
        assertTrue(nodes.contains(new Node(6)));
        assertTrue(nodes.contains(new Node(7)));
        assertTrue(nodes.contains(new Node(8)));
        assertTrue(nodes.contains(new Node(9)));

        assertTrue(edges.contains(new DirectedEdge(new Node(2), new Node(3))));
        assertTrue(edges.contains(new DirectedEdge(new Node(3), new Node(4))));
        assertTrue(edges.contains(new DirectedEdge(new Node(4), new Node(2))));
        assertTrue(edges.contains(new DirectedEdge(new Node(4), new Node(5))));
        assertTrue(edges.contains(new DirectedEdge(new Node(5), new Node(6))));
        assertTrue(edges.contains(new DirectedEdge(new Node(6), new Node(1))));
        assertTrue(edges.contains(new DirectedEdge(new Node(1), new Node(5))));
        assertTrue(edges.contains(new DirectedEdge(new Node(6), new Node(9))));
        assertTrue(edges.contains(new DirectedEdge(new Node(9), new Node(7))));
        assertTrue(edges.contains(new DirectedEdge(new Node(7), new Node(8))));
        assertTrue(edges.contains(new DirectedEdge(new Node(8), new Node(9))));
    }

}
