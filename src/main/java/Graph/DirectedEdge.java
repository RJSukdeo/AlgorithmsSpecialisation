package Graph;

import java.util.Objects;

final class DirectedEdge extends Edge implements Cloneable {

    DirectedEdge(final Node tail, final Node head, final IEdgeLength edgeLength) {
        super(tail, head, edgeLength);
    }

    DirectedEdge(final Node tail, final Node head) {
        this(tail, head, new NoLength());
    }

    Node getTail() {
        return getEncompassingNodes().get(0);
    }

    Node getHead() {
        return getEncompassingNodes().get(1);
    }

    void swapHeadTailNodes() {
        Node temp = getEncompassingNodes().get(0);
        getEncompassingNodes().set(0, getEncompassingNodes().get(1));
        getEncompassingNodes().set(1, temp);
    }

    @Override
    public Object clone() {
        return new DirectedEdge((Node) getTail().clone(), (Node) getHead().clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectedEdge directedEdge = (DirectedEdge) o;
        return directedEdge.getHead().equals(getHead()) && directedEdge.getTail().equals(getTail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHead(), getTail());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Directed Edge {Head: ").append(getHead().toString()).append(", Tail: ").append(getTail().toString()).append("}");
        sb.append("}");
        return sb.toString();
    }

}
