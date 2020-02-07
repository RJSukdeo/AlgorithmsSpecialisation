package Graph;

import java.util.ArrayList;
import java.util.List;

abstract class Edge implements Cloneable {

    private final List<Node> encompassingNodes = new ArrayList<>(2);
    private final IEdgeLength edgeLength;

    Edge(final Node node1, final Node node2, final IEdgeLength edgeLength) {
        encompassingNodes.add(node1);
        encompassingNodes.add(node2);
        this.edgeLength = edgeLength;
    }

    Edge(final Node node1, final Node node2) {
        this(node1, node2, new NoLength());
    }

    void replaceNode(final Node oldNode, final Node newNode) {
        if (encompassingNodes.contains(oldNode)) {
            encompassingNodes.set(encompassingNodes.indexOf(oldNode), newNode);
            newNode.addConnectedEdge(this);
        }
    }

    double getLength() {
        return edgeLength.getLength();
    }

    boolean containsNode(final Node node) {
        return encompassingNodes.contains(node);
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
