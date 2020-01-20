package Graph;

import Graph.UndirectedGraphInputs.InputBuilder;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphGeneratorTestCase {

    @Test
    public void testHashMapConstructor() {
        GraphGenerator graphGenerator = GraphGenerator.getGeneratorUndirected(new InputBuilder().addEntries(GraphInput.getGraphInputs()).build());
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

}
