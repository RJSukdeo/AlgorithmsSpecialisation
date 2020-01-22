package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class DirectedGraphGenerator {

    private final Set<Node> nodes = new HashSet<>();
    private final List<DirectedEdge> edges = new ArrayList<>();

    private DirectedGraphGenerator(final DirectedGraphInputs graphInputs) {
        List<List<Integer>> edgeInfo = graphInputs.getOrganisedInputs();
        for (List<Integer> entry : edgeInfo) {
            nodes.add(new Node(entry.get(0)));
            nodes.add(new Node(entry.get(1)));
            createDirectedEdge(entry.get(0), entry.get(1));
        }
    }

    static DirectedGraphGenerator getGeneratorDirected(final DirectedGraphInputs graphInputs) {
        return new DirectedGraphGenerator(graphInputs);
    }

    Set<Node> getNodes(boolean receiveCopy) {
        if (receiveCopy) {
            Set<Node> copyOfNodes = new HashSet<>(nodes.size());
            nodes.forEach(node -> copyOfNodes.add((Node) node.clone()));
            return copyOfNodes;
        }
        return nodes;
    }

    List<DirectedEdge> getEdges(boolean receiveCopy) {
        if (receiveCopy) {
            List<DirectedEdge> copyOfEdges = new ArrayList<>(edges.size());
            for (DirectedEdge edge : edges) {
                copyOfEdges.add((DirectedEdge) edge.clone());
            }
            return copyOfEdges;
        }
        return edges;
    }

    void swapDirectionsAllEdges() {
        edges.forEach(edge -> edge.swapHeadTailNodes());
    }

    private void createDirectedEdge(final int tailId, final int headId) {
        Node tailNode = getNode(tailId);
        Node headNode = getNode(headId);
        DirectedEdge edge = new DirectedEdge(tailNode, headNode);
        edges.add(edge);
        tailNode.addConnectedEdge(edge);
        headNode.addConnectedEdge(edge);
    }

    private Node getNode(final int nodeId) {
        return nodes.stream().filter(node -> node.getId() == nodeId).findFirst().get();
    }

}
