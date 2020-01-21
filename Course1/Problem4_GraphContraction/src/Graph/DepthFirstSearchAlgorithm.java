package Graph;

import java.util.*;
import java.util.stream.Collectors;

public final class DepthFirstSearchAlgorithm {

    private final DirectedGraphGenerator graphGenerator;
    private Map<Node, Boolean> nodeVisited;
    private Map<Node, Integer> orderVisited;
    private Stack<Node> nodesToVisit;
    private Set<Node> nodes;

    public DepthFirstSearchAlgorithm(final DirectedGraphGenerator graphGenerator) {
        this.graphGenerator = graphGenerator;
        nodeVisited = new HashMap<>();
        orderVisited = new HashMap<>();
        nodesToVisit = new Stack<>();
    }

    // Run across all nodes in no particular order.
    public DepthFirstSearchResult run() {
        initialiseAlgorithm();
        int order = 0;
        for (final Node node : nodes) {
            if (!nodeVisited.get(node)) {
                order = run(node, order);
            }
        }
        return new DepthFirstSearchResult(this);
    }

    // Run across nodes in order implied by list.
    public DepthFirstSearchResult run(final List<Integer> nodeIds) {
        initialiseAlgorithm();
        int order = 0;
        List<Node> nodes = nodeIds.stream().map(nodeId -> getNode(nodeId)).collect(Collectors.toList());
        for (final Node node : nodes) {
            if (!nodeVisited.get(node)) {
                order = run(node, order);
            }
        }
        return new DepthFirstSearchResult(this);
    }

    public DepthFirstSearchResult run(final int startingNodeId) {
        initialiseAlgorithm();
        run(getNode(startingNodeId), 0);
        return new DepthFirstSearchResult(this);
    }

    private void initialiseAlgorithm() {
        nodes = graphGenerator.getNodes(true);
        populateMaps();
    }

    private void populateMaps() {
        nodeVisited =  new HashMap<>(nodes.size());
        orderVisited = new HashMap<>(nodes.size());
        for (Node node : nodes) {
            nodeVisited.put(node, false);
            orderVisited.put(node, nodes.size());
        }
    }

    private int run(final Node node, int order) {
        visitNode(node);
        List<DirectedEdge> connectingEdges = node.getConnectedEdges().stream().map(e -> (DirectedEdge) e).filter(edge -> edge.getTail().equals(node)).filter(edge -> !nodeVisited.get(edge.getHead())).collect(Collectors.toList());
        if (!connectingEdges.isEmpty()) {
            connectingEdges.forEach(directedEdge -> nodesToVisit.add(directedEdge.getHead()));
        }
        if (!nodesToVisit.isEmpty()) {
            order = run(nodesToVisit.pop(), order);
        }
        updateOrderVisited(node, order);
        return ++order;
    }

    private Node getNode(final int nodeId) {
        return nodes.stream().filter(node -> node.getId() == nodeId).findFirst().get();
    }

    private void visitNode(final Node node) {
        nodeVisited.put(node, true);
    }

    private void updateOrderVisited(final Node node, final int order) {
        orderVisited.put(node, order);
    }

    Map<Node, Boolean> getNodeVisited() {
        return nodeVisited;
    }

    Map<Node, Integer> getOrderVisited() {
        return orderVisited;
    }

}
