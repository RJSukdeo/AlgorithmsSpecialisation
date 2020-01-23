package Graph;

import java.util.*;

public final class DirectedGraphGenerator {

    private final Map<Integer, Node> nodeIdToNodeMap = new HashMap<>();
    private final Set<Node> nodes = new HashSet<>();
    private final List<DirectedEdge> edges;

    private DirectedGraphGenerator(final DirectedGraphInputs graphInputs) {
        List<List<Integer>> edgeInfo = graphInputs.getOrganisedInputs();
        edges = new ArrayList<>(edgeInfo.size());
        for (List<Integer> entry : edgeInfo) {
            updateNode(entry.get(0));
            updateNode(entry.get(1));
            createDirectedEdge(entry.get(0), entry.get(1));
        }
    }

    private void updateNode(int nodeId) {
        Node node = new Node(nodeId);
        nodes.add(node);
        if (!nodeIdToNodeMap.containsKey(nodeId)){
            nodeIdToNodeMap.put(nodeId, node);
        }
    }

    public static DirectedGraphGenerator getGeneratorDirected(final DirectedGraphInputs graphInputs) {
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
        if (!tailNode.equals(headNode)) {
            tailNode.addConnectedEdge(edge);
            headNode.addConnectedEdge(edge);
        } else {
            tailNode.addConnectedEdge(edge);
        }
    }

    private Node getNode(final int nodeId) {
        return nodeIdToNodeMap.get(nodeId);
    }

}
