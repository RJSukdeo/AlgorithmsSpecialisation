package Graph;

import java.util.*;
import java.util.stream.Collectors;

public final class GraphManager {

    private Set<Node> nodes = new HashSet<>();
    private List<Edge> edges = new ArrayList<>();
    private Random randomGenerator = new Random();

    public GraphManager() {
        this(new HashMap<>());
    }

    public GraphManager(final Map<Integer, List<Integer>> nodeInfoMap) {
        nodeInfoMap.keySet().forEach(nodeId -> nodes.add(new Node(nodeId)));
        for (int nodeId : nodeInfoMap.keySet()) {
            createUniqueEdges(nodeId, nodeInfoMap.get(nodeId));
            updateAddedNodes(nodeId, nodeInfoMap.get(nodeId));
        }
    }

    public ContractionAlgorithmResults runContractionAlgorithm(int randomSeed) {
        this.randomGenerator = new Random(randomSeed);
        return runContractionAlgorithm();
    }

    public ContractionAlgorithmResults runContractionAlgorithm() {
        if (nodes.size() <= 2) {
            return new ContractionAlgorithmResults(edges.size());
        }
        Edge contractionEdge = edges.get(randomGenerator.nextInt(edges.size()));
        Node[] encompassingNodes = contractionEdge.getEncompassingNodes().toArray(new Node[0]);
        edges.removeAll(getEdges(encompassingNodes[0], encompassingNodes[1]));
        Node resultantNode = encompassingNodes[0].getId() < encompassingNodes[1].getId() ? encompassingNodes[0] : encompassingNodes[1];
        Node destroyedNode = encompassingNodes[0].getId() < encompassingNodes[1].getId() ? encompassingNodes[1] : encompassingNodes[0];
        redirectEdges(resultantNode, destroyedNode);
        updateConnectedNodes(resultantNode, destroyedNode);
        nodes.remove(destroyedNode);
        return runContractionAlgorithm();
    }

    private Node getNode(final int nodeId) {
        return nodes.stream().filter(node -> node.getId() == nodeId).findFirst().get();
    }

    private List<Edge> getEdges(final Node node1, final Node node2) {
        return edges.stream().filter(edge -> edge.containsNode(node1) && edge.containsNode(node2)).collect(Collectors.toList());
    }

    private List<Edge> getEdges(final Node node) {
        return edges.stream().filter(edge -> edge.containsNode(node)).collect(Collectors.toList());
    }

    private List<Node> getConnectedNodes(final Node node) {
        return nodes.stream().filter(n -> n.containsConnectedNode(node)).collect(Collectors.toList());
    }

    private void updateConnectedNodes(final Node remainingNode, final Node destroyedNode) {
        List<Node> connectedNodes = getConnectedNodes(destroyedNode);
        for (Node node : connectedNodes) {
            node.replaceConnectedNode(destroyedNode, remainingNode);
            if (node.getId() != remainingNode.getId()) {
                remainingNode.addConnectedNode(node);
            }
        }
    }

    private void redirectEdges(final Node remainingNode, final Node destroyedNode) {
        List<Edge> edgesAroundDestroyedNode = getEdges(destroyedNode);
        edgesAroundDestroyedNode.forEach(edge -> edge.replaceNode(destroyedNode, remainingNode));
    }

    Set<Node> getNodes() {
        return nodes;
    }

    Collection<Edge> getEdges() {
        return edges;
    }

    private void createUniqueEdges(final int nodeId, final List<Integer> connectingNodeIds) {
        for (Integer id : connectingNodeIds) {
            Edge edge = new Edge(getNode(nodeId), getNode(id));
            if (!edges.contains(edge)) {
                edges.add(edge);
            }
        }
    }

    private void updateAddedNodes(final int nodeId, final List<Integer> connectingNodeIds) {
        Node mainNode = getNode(nodeId);
        Set<Node> connectedNodes = new HashSet<>(connectingNodeIds.size());
        connectingNodeIds.forEach(id -> connectedNodes.add(getNode(id)));
        mainNode.addConnectedNode(connectedNodes.toArray(new Node[0]));
        connectedNodes.forEach(node -> node.addConnectedNode(mainNode));
    }

}
