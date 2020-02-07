package Graph;

import java.util.*;

public final class UndirectedGraphGenerator {

    private final Set<Node> nodes = new HashSet<>();
    private final List<UndirectedEdge> edges = new ArrayList<>();

    private UndirectedGraphGenerator(final UndirectedGraphInputs graphInputs) {
        Map<Integer, List<Integer>> nodeInfoMap = graphInputs.getNodeToNodesMap();
        nodeInfoMap.keySet().forEach(nodeId -> nodes.add(new Node(nodeId)));
        for (NodeKey nodes : graphInputs.getEdgeInputsContainer().getNodes()) {
            Iterator<Integer> nodeIds = nodes.getNodeIds().iterator();
            int nodeId1 = nodeIds.next();
            int nodeId2 = nodeIds.next();
            createUniqueUndirectedEdges(nodeId1, nodeId2, graphInputs.getEdgeInputsContainer().getLength(nodeId1, nodeId2));
        }
    }

    public static UndirectedGraphGenerator getGenerator(final UndirectedGraphInputs graphInputs) {
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

    private void createUniqueUndirectedEdges(final int nodeId1, final int nodeId2, final IEdgeLength edgeLength) {
            Node node1 = getNode(nodeId1);
            Node node2 = getNode(nodeId2);
            UndirectedEdge undirectedEdge = new UndirectedEdge(node1, node2, edgeLength);
            if (!edges.contains(undirectedEdge)) {
                undirectedEdge.updateNodesWithEdge();
                edges.add(undirectedEdge);
            }
    }

    private Node getNode(final int nodeId) {
        return nodes.stream().filter(node -> node.getId() == nodeId).findFirst().get();
    }

}
