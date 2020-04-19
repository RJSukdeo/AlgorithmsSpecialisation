package Graph;

import java.util.Objects;

final class UndirectedEdge extends Edge implements Cloneable {

    UndirectedEdge(final Node node1, final Node node2, final IEdgeLength edgeLength) {
        super(node1, node2, edgeLength);
    }

    UndirectedEdge(final Node node1, final Node node2) {
        this(node1, node2, new NoLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndirectedEdge undirectedEdge = (UndirectedEdge) o;
        return getEncompassingNodes().containsAll(undirectedEdge.getEncompassingNodes());
    }

    @Override
    public Object clone() {
        if (this.getLength() != 0.0) {
            return new UndirectedEdge((Node) getEncompassingNodes().get(0).clone(), (Node) getEncompassingNodes().get(1).clone(), new Length(this.getLength()));
        }
        return new UndirectedEdge((Node) getEncompassingNodes().get(0).clone(), (Node) getEncompassingNodes().get(1).clone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEncompassingNodes());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Edge with Nodes {");
        for (Node node : getEncompassingNodes()) {
            sb.append(node.getId() + " ");
        }
        sb.append("}");
        return sb.toString();
    }

}
