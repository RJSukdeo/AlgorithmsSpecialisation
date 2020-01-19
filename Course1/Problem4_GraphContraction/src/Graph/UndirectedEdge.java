package Graph;

import java.util.Objects;

final class UndirectedEdge extends Edge {

    UndirectedEdge(final Node node1, final Node node2) {
        super(node1, node2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndirectedEdge undirectedEdge = (UndirectedEdge) o;
        return getEncompassingNodes().containsAll(undirectedEdge.getEncompassingNodes());
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