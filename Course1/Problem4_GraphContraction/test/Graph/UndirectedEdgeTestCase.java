package Graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class UndirectedEdgeTestCase {

    @Test
    public void testConstructor() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        UndirectedEdge undirectedEdge = new UndirectedEdge(node1, node2);
        assertTrue(undirectedEdge.getEncompassingNodes().contains(node1) && undirectedEdge.getEncompassingNodes().contains(node2));
        assertEquals(2, undirectedEdge.getEncompassingNodes().size());
    }

    @Test
    public void testEquals() {
        UndirectedEdge undirectedEdge1 = new UndirectedEdge(new Node(0), new Node(1));
        UndirectedEdge undirectedEdge2 = new UndirectedEdge(new Node(0), new Node(1));
        assertEquals(undirectedEdge1, undirectedEdge2);

        UndirectedEdge undirectedEdge3 = new UndirectedEdge(new Node(1), new Node(0));
        assertEquals(undirectedEdge1, undirectedEdge3);
    }

    @Test
    public void testReplaceNode() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        UndirectedEdge undirectedEdge1 = new UndirectedEdge(node1, node2);
        undirectedEdge1.replaceNode(node2, node3);
        assertTrue(undirectedEdge1.containsNode(node1));
        assertFalse(undirectedEdge1.containsNode(node2));
        assertTrue(undirectedEdge1.containsNode(node3));
    }

    @Test
    public void testGetEncompassingNodes(){
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        UndirectedEdge undirectedEdge = new UndirectedEdge(node1, node2);
        assertTrue(undirectedEdge.getEncompassingNodes().contains(node1));
        assertTrue(undirectedEdge.getEncompassingNodes().contains(node2));
        assertEquals(2, undirectedEdge.getEncompassingNodes().size());
    }

}
