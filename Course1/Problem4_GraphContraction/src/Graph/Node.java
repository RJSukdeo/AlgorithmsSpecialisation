package Graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

final class Node {

    private final int nodeId;
    private Set<Node> connectedNodes = new HashSet<>();

    Node(final int nodeId) {
        this.nodeId = nodeId;
    }

    void addConnectedNode(final Node node) {
        connectedNodes.add(node);
    }

    void addConnectedNode(final Node... nodes) {
        for (Node node : nodes) {
            addConnectedNode(node);
        }
    }

    boolean containsConnectedNode(final Node node) {
        return connectedNodes.contains(node);
    }

    void replaceConnectedNode(final Node oldNode, final Node newNode) {
        connectedNodes.remove(oldNode);
        if (getId() != newNode.getId()) {
            connectedNodes.add(newNode);
        }
    }

    boolean removeConnectedNode(final Node node) {
        return connectedNodes.remove(node);
    }

    int getId() {
        return nodeId;
    }

    Set<Node> getConnectedNodes() {
        return connectedNodes;
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
        if (!getConnectedNodes().isEmpty()) {
            sb.append(" Connected Node IDs {");
            for (Node node : getConnectedNodes()) {
                sb.append(node.getId() + " ");
            }
            sb.append("}");
        }
        return sb.toString();
    }
}
