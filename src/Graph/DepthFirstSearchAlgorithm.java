package Graph;

import java.util.*;
import java.util.stream.Collectors;

public final class DepthFirstSearchAlgorithm {

    private final DirectedGraphGenerator graphGenerator;
    private Map<Integer, Node> nodeIdToNodeMap;
    private Map<Node, Boolean> nodeVisited;
    private Map<Integer, List<Integer>> leaderToNodesVisited;
    private Stack<Node> nodesOrdered;
    private Set<Node> nodes;

    public DepthFirstSearchAlgorithm(final DirectedGraphGenerator graphGenerator) {
        this.graphGenerator = graphGenerator;
    }

    // Run across all nodes in no particular order.
    public DepthFirstSearchResult run() {
        initialiseAlgorithm();
        for (final Node node : nodes) {
            if (!nodeVisited.get(node)) {
                List<Integer> currentRun = new ArrayList<>();
                run(node, nodesOrdered, currentRun);
                leaderToNodesVisited.put(node.getId(), currentRun);
            }
        }
        return new DepthFirstSearchResult(this);
    }

    // Run across nodes in order implied by list.
    public DepthFirstSearchResult run(final List<Integer> nodeIds) {
        initialiseAlgorithm();
        for (final Integer nodeId : nodeIds) {
            Node node = getNode(nodeId);
            if (!nodeVisited.get(node)) {
                List<Integer> currentRun = new ArrayList<>();
                run(node, nodesOrdered, currentRun);
                leaderToNodesVisited.put(nodeId, currentRun);
            }
        }
        return new DepthFirstSearchResult(this);
    }

    public DepthFirstSearchResult run(final int startingNodeId) {
        initialiseAlgorithm();
        List<Integer> currentRun = new ArrayList<>();
        run(getNode(startingNodeId), nodesOrdered, currentRun);
        leaderToNodesVisited.put(startingNodeId, currentRun);
        return new DepthFirstSearchResult(this);
    }

    private void initialiseAlgorithm() {
        nodesOrdered = new Stack<>();
        nodes = graphGenerator.getNodes(true);
        populateMaps();
    }

    private void populateMaps() {
        nodeVisited = new HashMap<>(nodes.size());
        nodeIdToNodeMap = new HashMap<>(nodes.size());
        leaderToNodesVisited = new HashMap<>();
        for (Node node : nodes) {
            nodeVisited.put(node, false);
            nodeIdToNodeMap.put(node.getId(), node);
        }
    }

    private void run(final Node node, Stack<Node> orderedNodes, List<Integer> currentRun) {
        if (!nodeVisited.get(node)) {
            visitNode(node);
            currentRun.add(node.getId());
            List<DirectedEdge> connectingEdges = node.getConnectedEdges().stream().map(e -> (DirectedEdge) e).filter(edge -> edge.getTail().equals(node)).filter(edge -> !nodeVisited.get(edge.getHead())).collect(Collectors.toList());
            if (!connectingEdges.isEmpty()) {
                for (DirectedEdge connectingEdge : connectingEdges) {
                    run(connectingEdge.getHead(), orderedNodes, currentRun);
                }
            }
            orderedNodes.add(node);
        }
    }

    private Node getNode(final int nodeId) {
        return nodeIdToNodeMap.get(nodeId);
    }

    private void visitNode(final Node node) {
        nodeVisited.put(node, true);
    }

    Stack<Node> getNodesOrdered() {
        return nodesOrdered;
    }

    Map<Integer, List<Integer>> getLeaderToNodesVisited() {
        return leaderToNodesVisited;
    }
}
