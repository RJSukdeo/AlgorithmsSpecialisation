package Graph;

import java.util.*;

public final class UndirectedGraphGenerator {

    private final Set<Node> nodes = new HashSet<>();
    private final List<UndirectedEdge> edges = new ArrayList<>();

    private UndirectedGraphGenerator(final UndirectedGraphInputs graphInputs) {
        Map<Integer, List<Integer>> nodeInfoMap = graphInputs.getOrganisedInputs();
        nodeInfoMap.keySet().forEach(nodeId -> nodes.add(new Node(nodeId)));
        for (int nodeId : nodeInfoMap.keySet()) {
            createUniqueUndirectedEdges(nodeId, nodeInfoMap.get(nodeId));
        }
    }

    public static UndirectedGraphGenerator getGeneratorUndirected(final UndirectedGraphInputs graphInputs) {
        return new UndirectedGraphGenerator(graphInputs);
    }

    public Set<Node> getNodes(boolean receiveCopy) {
        if (receiveCopy) {
            Set<Node> copyOfNodes = new HashSet<>(nodes.size());
            nodes.forEach(node -> copyOfNodes.add((Node) node.clone()));
            return copyOfNodes;
        }
        return nodes;
    }

    public List<UndirectedEdge> getEdges(boolean receiveCopy) {
        if (receiveCopy) {
            List<UndirectedEdge> copyOfEdges = new ArrayList<>(edges.size());
            for (UndirectedEdge edge : edges) {
                    copyOfEdges.add((UndirectedEdge) edge.clone());
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
