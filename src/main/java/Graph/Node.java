package Graph;

import java.util.*;

final class Node implements Cloneable{

    private final int nodeId;
    private final List<Edge> connectedEdges = new ArrayList<>();

    Node(final int nodeId) {
        this.nodeId = nodeId;
    }

    void addConnectedEdge(final Edge edge) {
        connectedEdges.add(edge);
    }

    void addConnectedEdge(final Edge... edges) {
        connectedEdges.addAll(Arrays.asList(edges));
    }

    boolean containsConnectedEdge(final Edge edge) {
        return connectedEdges.contains(edge);
    }

    void replaceConnectedEdge(final Edge oldEdge, final Edge newEdge) {
        if (connectedEdges.contains(oldEdge)) {
            connectedEdges.set(connectedEdges.indexOf(oldEdge), newEdge);
        }
    }

    void removeConnectedEdge(final Edge edge) {
        connectedEdges.remove(edge);
    }

    int getId() {
        return nodeId;
    }

    List<Edge> getConnectedEdges() {
        return connectedEdges;
    }

    @Override
    public Object clone() {
        Node node = new Node(this.getId());
        for (Edge edge : this.getConnectedEdges()) {
            node.addConnectedEdge(edge);
        }
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return nodeId == node.nodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node with nodeId = " + getId() + ".");
        if (!getConnectedEdges().isEmpty()) {
            sb.append(" # Connected Edges {").append(getConnectedEdges().size()).append("}");
        }
        return sb.toString();
    }
}
