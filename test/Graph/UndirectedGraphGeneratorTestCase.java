package Graph;

import org.junit.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class UndirectedGraphGeneratorTestCase {

    @Test
    public void testGetGeneratorUndirected() {
        UndirectedGraphGenerator undirectedGraphGenerator = UndirectedGraphGenerator.getGeneratorUndirected(new UndirectedGraphInputs.InputBuilder().addEntries(GraphTestData.getUndirectedGraphInputs()).build());
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

}
