package Graph;

import java.util.*;

public final class GraphGenerator {

    private final Set<Node> nodes = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();

    private GraphGenerator(final UndirectedGraphInputs graphInputs) {
        Map<Integer, List<Integer>> nodeInfoMap = graphInputs.getOrganisedInputs();
        nodeInfoMap.keySet().forEach(nodeId -> nodes.add(new Node(nodeId)));
        for (int nodeId : nodeInfoMap.keySet()) {
            createUniqueUndirectedEdges(nodeId, nodeInfoMap.get(nodeId));
        }
    }

    private GraphGenerator(final DirectedGraphInputs graphInputs) {

    }

    public static GraphGenerator getGeneratorUndirected(final UndirectedGraphInputs graphInputs) {
        return new GraphGenerator(graphInputs);
    }

    public static GraphGenerator getGeneratorDirected(final DirectedGraphInputs graphInputs) {
        return new GraphGenerator(graphInputs);
    }

    public Set<Node> getNodes(boolean receiveCopy) {
        if (receiveCopy) {
            Set<Node> copyOfNodes = new HashSet<>(nodes.size());
            nodes.forEach(node -> copyOfNodes.add((Node) node.clone()));
            return copyOfNodes;
        }
        return nodes;
    }

    public List<Edge> getEdges(boolean receiveCopy) {
        if (receiveCopy) {
            List<Edge> copyOfEdges = new ArrayList<>(edges.size());
            for (Edge edge : edges) {
                if (edge instanceof DirectedEdge) {
                    copyOfEdges.add((DirectedEdge) ((DirectedEdge) edge).clone());
                } else {
                    copyOfEdges.add((UndirectedEdge) ((UndirectedEdge) edge).clone());
                }
            }
            return copyOfEdges;
        }
        return edges;
    }

    private void createUniqueUndirectedEdges(final int nodeId, final List<Integer> connectingNodeIds) {
        for (Integer id : connectingNodeIds) {
            Node node1 = getNode(nodeId);
            Node node2 = getNode(id);
            UndirectedEdge undirectedEdge = new UndirectedEdge(node1, node2);
            if (!edges.contains(undirectedEdge)) {
                undirectedEdge.updateNodesWithEdge();
                edges.add(undirectedEdge);
            }
        }
    }

    private Node getNode(final int nodeId) {
        return nodes.stream().filter(node -> node.getId() == nodeId).findFirst().get();
    }

}
