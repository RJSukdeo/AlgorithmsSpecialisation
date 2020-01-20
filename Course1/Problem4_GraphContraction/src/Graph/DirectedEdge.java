package Graph;

import java.util.Objects;

final class DirectedEdge extends Edge implements Cloneable {

    DirectedEdge(final Node tail, final Node head) {
        super(tail, head);
    }

    Node getTail() {
        return getEncompassingNodes().get(0);
    }

    Node getHead() {
        return getEncompassingNodes().get(1);
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
