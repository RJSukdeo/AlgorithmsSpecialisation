package Graph;

import java.util.*;
import java.util.stream.Collectors;

public final class PrimMinimumSpanningTreeAlgorithm {

    private final UndirectedGraphGenerator graphGenerator;
    private Set<Node> frontierNodes;
    private Set<Node> unvisitedNodes;
    private long totalTreeLength;
    private List<Node> orderedVisitedNodes;
    private Map<Integer, Node> nodeIdToNodeMap;

    public PrimMinimumSpanningTreeAlgorithm(final UndirectedGraphGenerator graphGenerator) {
        this.graphGenerator = graphGenerator;
    }

    public PrimMinimumSpanningTreeAlgorithmResults run() {
        Random randomGenerator = new Random();
        return run(randomGenerator.ints(1, graphGenerator.getNodes(false).size() + 1).findFirst().getAsInt());
    }

    public PrimMinimumSpanningTreeAlgorithmResults run(int startingNodeId) {
        initialiseAlgorithm(startingNodeId);
        while (!unvisitedNodes.isEmpty()) {
            PriorityQueue<UndirectedEdge> heap = new PriorityQueue<>(new EdgeComparator());
            List<UndirectedEdge> edgesBetweenTwoSets = getApplicableEdges();
            edgesBetweenTwoSets.forEach(edge -> heap.add(edge));
            UndirectedEdge edgeToTraverse = heap.poll();
            Node nodeToVisit = getUnvisitedNode(edgeToTraverse);
            moveNodeToVisited(nodeToVisit);
            totalTreeLength += edgeToTraverse.getLength();
            cleanUpFrontier();
        }
        return new PrimMinimumSpanningTreeAlgorithmResults(this);
    }

    private List<UndirectedEdge> getApplicableEdges() {
        List<UndirectedEdge> applicableEdges = new ArrayList<>();
        for (Node frontierNode : frontierNodes) {
            applicableEdges.addAll(frontierNode.getConnectedEdges().stream().filter(edge -> edgeBetweenTwoSets(edge)).map(edge -> (UndirectedEdge) edge).collect(Collectors.toList()));
        }
        return applicableEdges;
    }

    private boolean edgeBetweenTwoSets(Edge edge) {
        boolean containsNode1 = unvisitedNodes.contains(edge.getEncompassingNodes().get(0));
        boolean containsNode2 = unvisitedNodes.contains(edge.getEncompassingNodes().get(1));
        return (containsNode1 && !containsNode2) || (containsNode2 && !containsNode1);
    }

    private void moveNodeToVisited(Node node) {
        unvisitedNodes.remove(node);
        frontierNodes.add(node);
        orderedVisitedNodes.add(node);
    }

    private Node getUnvisitedNode(UndirectedEdge edge) {
        return unvisitedNodes.contains(edge.getEncompassingNodes().get(0)) ? edge.getEncompassingNodes().get(0) : edge.getEncompassingNodes().get(1);
    }

    private void populateMaps() {
        unvisitedNodes.forEach(node -> nodeIdToNodeMap.put(node.getId(), node));
    }

    private void initialiseAlgorithm(final int startingNodeId) {
        totalTreeLength = 0;
        unvisitedNodes = graphGenerator.getNodes(true);
        orderedVisitedNodes = new ArrayList<>(unvisitedNodes.size());
        frontierNodes = new HashSet<>();
        nodeIdToNodeMap = new HashMap<>(unvisitedNodes.size());
        populateMaps();
        moveNodeToVisited(nodeIdToNodeMap.get(startingNodeId));
    }

    private void cleanUpFrontier() {
        List<Node> nodesToRemove = new ArrayList<>();
        for (Node node : frontierNodes) {
            boolean excludeNode = true;
            for (Edge edge : node.getConnectedEdges()) {
                if (edgeBetweenTwoSets(edge)) {
                    excludeNode = false;
                }
            }
            if (excludeNode) {
                nodesToRemove.add(node);
            }
        }
        nodesToRemove.forEach(node -> frontierNodes.remove(node));
    }

    long getTotalTreeLength() {
        return totalTreeLength;
    }

    List<Node> getOrderedVisitedNodes() {
        return orderedVisitedNodes;
    }

    private class EdgeComparator implements Comparator<UndirectedEdge> {

        @Override
        public int compare(UndirectedEdge edge1, UndirectedEdge edge2) {
            return (int) edge1.getLength() - (int) edge2.getLength();
        }

    }
}
