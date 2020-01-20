package Graph;

import java.util.ArrayList;
import java.util.List;

abstract class Edge {

    private final List<Node> encompassingNodes = new ArrayList<>(2);

    Edge(final Node node1, final Node node2) {
        encompassingNodes.add(node1);
        encompassingNodes.add(node2);
    }

    void replaceNode(final Node oldNode, final Node newNode) {
        if (encompassingNodes.contains(oldNode)) {
            encompassingNodes.set(encompassingNodes.indexOf(oldNode), newNode);
            newNode.addConnectedEdge(this);
        }
    }

    boolean containsNode(final Node node) {
        return encompassingNodes.contains(node);
    }

    boolean selfLoop() {
        return getEncompassingNodes().get(0).equals(getEncompassingNodes().get(1));
    }

    List<Node> getEncompassingNodes() {
        return encompassingNodes;
    }

    void removeEdgeFromNodes() {
        encompassingNodes.forEach(node -> node.removeConnectedEdge(this));
        encompassingNodes.clear();
    }

    void updateNodesWithEdge() {
        encompassingNodes.forEach(node -> node.addConnectedEdge(this));
    }

}
