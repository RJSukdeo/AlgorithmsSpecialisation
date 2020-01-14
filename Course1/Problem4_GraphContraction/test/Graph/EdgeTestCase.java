package Graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTestCase {

    @Test
    public void testConstructor() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Edge edge = new Edge(node1, node2);
        assertTrue(edge.getEncompassingNodes().contains(node1) && edge.getEncompassingNodes().contains(node2));
        assertEquals(2, edge.getEncompassingNodes().size());
    }

    @Test
    public void testEquals() {
        Edge edge1 = new Edge(new Node(0), new Node(1));
        Edge edge2 = new Edge(new Node(0), new Node(1));
        assertEquals(edge1, edge2);

        Edge edge3 = new Edge(new Node(1), new Node(0));
        assertEquals(edge1, edge3);
    }

    @Test
    public void testReplaceNode() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Edge edge1 = new Edge(node1, node2);
        edge1.replaceNode(node2, node3);
        assertTrue(edge1.containsNode(node1));
        assertFalse(edge1.containsNode(node2));
        assertTrue(edge1.containsNode(node3));
    }

    @Test
    public void testGetEncompassingNodes(){
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Edge edge = new Edge(node1, node2);
        assertTrue(edge.getEncompassingNodes().contains(node1));
        assertTrue(edge.getEncompassingNodes().contains(node2));
        assertEquals(2, edge.getEncompassingNodes().size());
    }

}
