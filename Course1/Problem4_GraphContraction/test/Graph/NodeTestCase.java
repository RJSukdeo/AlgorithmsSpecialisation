package Graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTestCase {

    @Test
    public void testConstructor() {
        Node node = new Node(1);
        assertEquals(1, node.getId());
    }

    @Test
    public void testAddConnectedEdge() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Edge edge12 = new UndirectedEdge(node1, node2);
        Edge edge13 = new UndirectedEdge(node1, node3);
        Edge edge23 = new UndirectedEdge(node2, node3);
        node1.addConnectedEdge(edge12);
        node1.addConnectedEdge(edge13);
        node2.addConnectedEdge(edge23);
        node2.addConnectedEdge(edge12);
        node3.addConnectedEdge(edge13);
        node3.addConnectedEdge(edge23);

        assertTrue(node1.containsConnectedEdge(edge12));
        assertTrue(node1.containsConnectedEdge(edge13));
        assertTrue(node2.containsConnectedEdge(edge23));
        assertTrue(node2.containsConnectedEdge(edge12));
        assertTrue(node3.containsConnectedEdge(edge23));
        assertTrue(node3.containsConnectedEdge(edge13));

    }

    @Test
    public void testRemoveConnectedEdge() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Edge edge12 = new UndirectedEdge(node1, node2);
        Edge edge13 = new UndirectedEdge(node1, node3);
        Edge edge23 = new UndirectedEdge(node2, node3);
        node1.addConnectedEdge(edge12);
        node1.addConnectedEdge(edge13);
        node2.addConnectedEdge(edge23);
        node2.addConnectedEdge(edge12);
        node3.addConnectedEdge(edge13);
        node3.addConnectedEdge(edge23);

        assertTrue(node1.containsConnectedEdge(edge12));
        assertTrue(node1.containsConnectedEdge(edge13));
        assertTrue(node2.containsConnectedEdge(edge23));
        assertTrue(node2.containsConnectedEdge(edge12));
        assertTrue(node3.containsConnectedEdge(edge23));
        assertTrue(node3.containsConnectedEdge(edge13));

        node3.removeConnectedEdge(edge23);

        assertTrue(node1.containsConnectedEdge(edge12));
        assertTrue(node1.containsConnectedEdge(edge13));
        assertTrue(node2.containsConnectedEdge(edge23));
        assertTrue(node2.containsConnectedEdge(edge12));
        assertFalse(node3.containsConnectedEdge(edge23));
        assertTrue(node3.containsConnectedEdge(edge13));
    }

    @Test
    public void testReplaceConnectedEdge() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Edge edge12 = new UndirectedEdge(node1, node2);
        Edge edge13 = new UndirectedEdge(node1, node3);
        Edge edge23 = new UndirectedEdge(node2, node3);
        Edge edge24 = new UndirectedEdge(node2, node4);
        node1.addConnectedEdge(edge12);
        node1.addConnectedEdge(edge13);
        node2.addConnectedEdge(edge23);
        node2.addConnectedEdge(edge12);
        node3.addConnectedEdge(edge13);
        node3.addConnectedEdge(edge23);

        node2.replaceConnectedEdge(edge23, edge24);
        assertTrue(node1.containsConnectedEdge(edge12));
        assertTrue(node1.containsConnectedEdge(edge13));
        assertFalse(node2.containsConnectedEdge(edge23));
        assertTrue(node2.containsConnectedEdge(edge12));
        assertTrue(node2.containsConnectedEdge(edge24));
        assertTrue(node3.containsConnectedEdge(edge23));
        assertTrue(node3.containsConnectedEdge(edge13));
    }

    @Test
    public void testEqualsMethod() {
        Node node1 = new Node(0);
        Node node2 = new Node(0);
        assertEquals(node1, node2);
    }

}
