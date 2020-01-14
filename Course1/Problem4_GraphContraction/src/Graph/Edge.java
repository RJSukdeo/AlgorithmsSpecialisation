package Graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

final class Edge {

    private Set<Node> nodes = new HashSet<>(2);

    Edge(final Node node1, final Node node2) {
        nodes.add(node1);
        nodes.add(node2);
    }

    public void replaceNode(final Node oldNode, final Node newNode) {
        nodes.remove(oldNode);
        nodes.add(newNode);
    }

    public boolean containsNode(final Node node) {
        return nodes.contains(node);
    }

    Set<Node> getEncompassingNodes() {
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return nodes.equals(edge.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
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
