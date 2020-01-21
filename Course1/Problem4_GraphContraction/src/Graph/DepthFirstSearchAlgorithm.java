package Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class DepthFirstSearchAlgorithm {

    private Map<Node, Boolean> nodeVisited;
    private Map<Node, Integer> orderVisited;
    private Set<Node> nodes;
    private List<DirectedEdge> edges;

    public DepthFirstSearchAlgorithm(DirectedGraphGenerator undirectedGraphGenerator) {
        nodes = undirectedGraphGenerator.getNodes(true);
        edges = undirectedGraphGenerator.getEdges(true);
        populateMaps();
    }

    private void populateMaps() {
        nodeVisited = new HashMap<>(nodes.size());
        orderVisited = new HashMap<>(nodes.size());
        for (Node node : nodes) {
            nodeVisited.put(node, false);
            orderVisited.put(node, nodes.size());
        }
    }

    public void run(int startingNodeId) {
        Node startingNode = getNode(startingNodeId);
        List<Edge> connectingEdges = startingNode.getConnectedEdges().stream().filter(edge -> edge.getEncompassingNodes().get(0).equals(startingNode)).collect(Collectors.toList());
    }

    private Node getNode(int nodeId) {
        return nodes.stream().filter(node -> node.getId() == nodeId).findFirst().get();
    }


}
