package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class DirectedEdgeTestCase {

    @Test
    public void testGetHeadAndTail() {
        Node head = new Node(0);
        Node tail = new Node(1);
        DirectedEdge directedEdge = new DirectedEdge(tail, head);
        assertEquals(head, directedEdge.getHead());
        assertEquals(tail, directedEdge.getTail());
    }

    @Test
    public void testReplace() {
        Node head = new Node(0);
        Node tail = new Node(1);
        DirectedEdge edge = new DirectedEdge(tail, head);
        assertEquals(head, edge.getHead());
        assertEquals(tail, edge.getTail());

        Node newHead = new Node(3);
        edge.replaceNode(head, newHead);
        assertEquals(newHead, edge.getHead());
        assertEquals(tail, edge.getTail());
    }

    @Test
    public void testSwapHeadTailNodes(){
        Node head = new Node(0);
        Node tail = new Node(1);
        DirectedEdge edge = new DirectedEdge(tail, head);
        edge.swapHeadTailNodes();
        assertEquals(head, edge.getTail());
        assertEquals(tail, edge.getHead());
    }

}
