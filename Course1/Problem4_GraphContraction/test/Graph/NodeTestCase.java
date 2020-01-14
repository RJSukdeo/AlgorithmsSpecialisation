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
    public void testAddConnectedNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.addConnectedNode(node2);
        node1.addConnectedNode(node3);
        node2.addConnectedNode(node1);
        node2.addConnectedNode(node3);
        node3.addConnectedNode(node1);
        node3.addConnectedNode(node2);
        assertTrue(node1.containsConnectedNode(node2));
        assertTrue(node1.containsConnectedNode(node3));
        assertTrue(node2.containsConnectedNode(node1));
        assertTrue(node2.containsConnectedNode(node3));
        assertTrue(node3.containsConnectedNode(node1));
        assertTrue(node3.containsConnectedNode(node2));
    }

    @Test
    public void testRemoveConnectedNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.addConnectedNode(node2);
        node1.addConnectedNode(node3);
        node2.addConnectedNode(node1);
        node2.addConnectedNode(node3);
        node3.addConnectedNode(node1);
        node3.addConnectedNode(node2);
        assertTrue(node1.containsConnectedNode(node2));
        assertTrue(node1.containsConnectedNode(node3));
        assertTrue(node2.containsConnectedNode(node1));
        assertTrue(node2.containsConnectedNode(node3));
        assertTrue(node3.containsConnectedNode(node1));
        assertTrue(node3.containsConnectedNode(node2));

        node1.removeConnectedNode(node3);
        node3.removeConnectedNode(node1);
        assertTrue(node1.containsConnectedNode(node2));
        assertFalse(node1.containsConnectedNode(node3));
        assertTrue(node2.containsConnectedNode(node1));
        assertTrue(node2.containsConnectedNode(node3));
        assertFalse(node3.containsConnectedNode(node1));
        assertTrue(node3.containsConnectedNode(node2));
    }

    @Test
    public void testReplaceConnectedNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.addConnectedNode(node2);
        node1.addConnectedNode(node3);
        node1.replaceConnectedNode(node3, node4);

        assertEquals(2, node1.getConnectedNodes().size());
        assertTrue(node1.getConnectedNodes().contains(node2));
        assertFalse(node1.getConnectedNodes().contains(node3));
        assertTrue(node1.getConnectedNodes().contains(node4));
    }

    @Test
    public void testEqualsMethod() {
        Node node1 = new Node(0);
        Node node2 = new Node(0);
        assertEquals(node1, node2);
    }

}
