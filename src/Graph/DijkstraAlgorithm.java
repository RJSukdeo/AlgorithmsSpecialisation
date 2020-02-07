package Graph;

import java.util.*;
import java.util.stream.Collectors;

public final class DijkstraAlgorithm {

    private static final double NODE_UNREACHABLE_DISTANCE = 1000000;
    private final Map<Node, Double> nodeToDistanceMap;
    private final Map<Integer, Node> nodeIdToNodeMap;
    private final Set<Node> unvisitedNodes;
    private final Set<Node> frontierNodes;

    public DijkstraAlgorithm(final UndirectedGraphGenerator graphGenerator) {
        unvisitedNodes = graphGenerator.getNodes(true);
        frontierNodes = new HashSet<>();
        nodeToDistanceMap = new HashMap<>(unvisitedNodes.size());
        nodeIdToNodeMap = new HashMap<>(unvisitedNodes.size());
        populateMaps();
    }

    Map<Node, Double> getNodeToDistanceMap() {
        return nodeToDistanceMap;
    }

    Map<Integer, Node> getNodeIdToNodeMap() {
        return nodeIdToNodeMap;
    }

    public DijkstraAlgorithmResults run(final int startingNodeId) {
        initialiseAlgorithm(startingNodeId);
        while (!unvisitedNodes.isEmpty()) {
            PriorityQueue<DistanceContainer> heap = new PriorityQueue<>(new DistanceContainerComparator());
            List<UndirectedEdge> edgesBetweenTwoSets = getApplicableEdges();
            calculateDistancesAndUpdateHeap(edgesBetweenTwoSets, heap);
            DistanceContainer distanceContainer = heap.poll();
            Node nodeToBeIncluded = distanceContainer.getNode();
            nodeToDistanceMap.put(nodeToBeIncluded, distanceContainer.getLength());
            moveNodeToVisited(nodeToBeIncluded);
            cleanUpFrontier();
        }
        return new DijkstraAlgorithmResults(this);
    }

    private void calculateDistancesAndUpdateHeap(List<UndirectedEdge> edges, PriorityQueue<DistanceContainer> heap) {
        for (UndirectedEdge edge : edges) {
            double distFromLastNode = nodeToDistanceMap.get(getOriginationNode(edge));
            DistanceContainer distanceContainer = new DistanceContainer(getUnvisitedNode(edge), distFromLastNode + edge.getLength());
            heap.add(distanceContainer);
        }
    }

    private List<UndirectedEdge> getApplicableEdges() {
        List<UndirectedEdge> applicableEdges = new ArrayList<>();
        for (Node frontierNode : frontierNodes) {
            applicableEdges.addAll(frontierNode.getConnectedEdges().stream().filter(edge -> edgeBetweenTwoSets(edge)).map(edge -> (UndirectedEdge) edge).collect(Collectors.toList()));
        }
        return applicableEdges;
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

    private boolean edgeBetweenTwoSets(Edge edge) {
        boolean containsNode1 = unvisitedNodes.contains(edge.getEncompassingNodes().get(0));
        boolean containsNode2 = unvisitedNodes.contains(edge.getEncompassingNodes().get(1));
        return (containsNode1 && !containsNode2) || (containsNode2 && !containsNode1);
    }

    private Node getUnvisitedNode(UndirectedEdge edge) {
        return unvisitedNodes.contains(edge.getEncompassingNodes().get(0)) ? edge.getEncompassingNodes().get(0) : edge.getEncompassingNodes().get(1);
    }

    private Node getOriginationNode(UndirectedEdge edge) {
        return unvisitedNodes.contains(edge.getEncompassingNodes().get(0)) ? edge.getEncompassingNodes().get(1) : edge.getEncompassingNodes().get(0);
    }

    private void initialiseAlgorithm(final int startingNodeId) {
        Node startingNode = nodeIdToNodeMap.get(startingNodeId);
        frontierNodes.add(startingNode);
        moveNodeToVisited(startingNode);
        nodeToDistanceMap.put(startingNode, 0.0);
    }

    private void moveNodeToVisited(Node node) {
        unvisitedNodes.remove(node);
        frontierNodes.add(node);
    }

    private void populateMaps() {
        Iterator<Node> nodeIterator = unvisitedNodes.iterator();
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            nodeIdToNodeMap.put(node.getId(), node);
            nodeToDistanceMap.put(node, NODE_UNREACHABLE_DISTANCE);
        }
    }

    private class DistanceContainerComparator implements Comparator<DistanceContainer> {

        @Override
        public int compare(DistanceContainer container1, DistanceContainer container2) {
            if (container1.getLength() < container2.getLength()) {
                return -1;
            } else if (container1.getLength() > container2.getLength()) {
                return 1;
            }
            return 0;
        }

    }

    private class DistanceContainer {

        private final Node node;
        private final double length;

        public DistanceContainer(final Node node, final double length) {
            this.node = node;
            this.length = length;
        }

        public DistanceContainer(final Node node) {
            this(node, 0);
        }

        public double getLength() {
            return length;
        }

        public Node getNode() {
            return node;
        }

    }

}
