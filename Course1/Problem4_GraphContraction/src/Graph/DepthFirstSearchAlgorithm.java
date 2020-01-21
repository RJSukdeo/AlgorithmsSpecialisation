package Graph;

import java.util.*;
import java.util.stream.Collectors;

public final class DepthFirstSearchAlgorithm {

    private Map<Node, Boolean> nodeVisited;
    private Map<Node, Integer> orderVisited;
    private Stack<Node> nodesToVisit;
    private Set<Node> nodes;

    public DepthFirstSearchAlgorithm(DirectedGraphGenerator undirectedGraphGenerator, int startingNodeId) {
        nodesToVisit = new Stack<>();
        nodes = undirectedGraphGenerator.getNodes(true);
        populateMaps();
        run(startingNodeId);
    }

    private void populateMaps() {
        nodeVisited = new HashMap<>(nodes.size());
        orderVisited = new HashMap<>(nodes.size());
        for (Node node : nodes) {
            nodeVisited.put(node, false);
            orderVisited.put(node, nodes.size());
        }
    }

    private void run(int startingNodeId) {
        run(getNode(startingNodeId), 0);
    }

    private int run(Node node, int order) {
        visitNode(node);
        List<DirectedEdge> connectingEdges = node.getConnectedEdges().stream().map(e -> (DirectedEdge) e).filter(edge -> edge.getTail().equals(node)).filter(edge -> !nodeVisited.get(edge.getHead())).collect(Collectors.toList());
        if (!connectingEdges.isEmpty()) {
            for (DirectedEdge connectingEdge : connectingEdges) {
                nodesToVisit.add(connectingEdge.getHead());
            }
            order = run(nodesToVisit.pop(), order);
        }
        updateOrderVisited(node, order);
        return ++order;
    }

    public DepthFirstSearchResult getResult() {
        return new DepthFirstSearchResult(this);
    }

    private Node getNode(int nodeId) {
        return nodes.stream().filter(node -> node.getId() == nodeId).findFirst().get();
    }

    private void visitNode(Node node) {
        nodeVisited.put(node, true);
    }

    private void updateOrderVisited(Node node, int order) {
        orderVisited.put(node, order);
    }

    Map<Node, Boolean> getNodeVisited() {
        return nodeVisited;
    }

    Map<Node, Integer> getOrderVisited() {
        return orderVisited;
    }
}
