package Graph;

import java.util.*;
import java.util.stream.Collectors;

public final class GraphManager {

    private Set<Node> nodes = new HashSet<>();
    private List<UndirectedEdge> undirectedEdges = new ArrayList<>();
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
            return new ContractionAlgorithmResults(undirectedEdges.size());
        }
        UndirectedEdge contractionUndirectedEdge = undirectedEdges.get(randomGenerator.nextInt(undirectedEdges.size()));
        Node[] encompassingNodes = contractionUndirectedEdge.getEncompassingNodes().toArray(new Node[0]);
        undirectedEdges.removeAll(getEdges(encompassingNodes[0], encompassingNodes[1]));
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

    private List<UndirectedEdge> getEdges(final Node node1, final Node node2) {
        return undirectedEdges.stream().filter(undirectedEdge -> undirectedEdge.containsNode(node1) && undirectedEdge.containsNode(node2)).collect(Collectors.toList());
    }

    private List<UndirectedEdge> getEdges(final Node node) {
        return undirectedEdges.stream().filter(undirectedEdge -> undirectedEdge.containsNode(node)).collect(Collectors.toList());
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
        List<UndirectedEdge> edgesAroundDestroyedNode = getEdges(destroyedNode);
        edgesAroundDestroyedNode.forEach(undirectedEdge -> undirectedEdge.replaceNode(destroyedNode, remainingNode));
    }

    Set<Node> getNodes() {
        return nodes;
    }

    Collection<UndirectedEdge> getUndirectedEdges() {
        return undirectedEdges;
    }

    private void createUniqueEdges(final int nodeId, final List<Integer> connectingNodeIds) {
        for (Integer id : connectingNodeIds) {
            UndirectedEdge undirectedEdge = new UndirectedEdge(getNode(nodeId), getNode(id));
            if (!undirectedEdges.contains(undirectedEdge)) {
                undirectedEdges.add(undirectedEdge);
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
