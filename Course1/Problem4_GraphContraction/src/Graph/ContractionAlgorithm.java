package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public final class ContractionAlgorithm {

    private final Random randomGenerator;
    private final Set<Node> nodes;
    private final List<UndirectedEdge> edges;

    public ContractionAlgorithm(UndirectedGraphGenerator undirectedGraphGenerator, Random randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.nodes = undirectedGraphGenerator.getNodes(true);
        this.edges = undirectedGraphGenerator.getEdges(true);
    }

    public ContractionAlgorithm(UndirectedGraphGenerator undirectedGraphGenerator) {
        this(undirectedGraphGenerator, new Random());
    }

    public ContractionResult run() {
        if (nodes.size() <= 2) {
            return new ContractionResult(edges.size());
        }
        Edge contractionEdge = edges.get(randomGenerator.nextInt(edges.size()));
        List<Node> encompassingNodes = new ArrayList<>(contractionEdge.getEncompassingNodes());
        removeEdgesBetweenNodes(encompassingNodes.get(0), encompassingNodes.get(1));
        Node resultantNode = encompassingNodes.get(0).getId() < encompassingNodes.get(1).getId() ? encompassingNodes.get(0) : encompassingNodes.get(1);
        Node destroyedNode = encompassingNodes.get(0).getId() < encompassingNodes.get(1).getId() ? encompassingNodes.get(1) : encompassingNodes.get(0);
        redirectEdges(resultantNode, destroyedNode);
        nodes.remove(destroyedNode);
        return run();
    }

    private void removeEdgesBetweenNodes(final Node node1, final Node node2) {
        List<UndirectedEdge> edgesToRemove = getEdges(node1, node2);
        edges.removeAll(edgesToRemove);
        edgesToRemove.forEach(Edge::removeEdgeFromNodes);
    }

    private List<UndirectedEdge> getEdges(final Node node1, final Node node2) {
        return edges.stream().filter(edge -> edge.containsNode(node1) && edge.containsNode(node2)).collect(Collectors.toList());
    }

    private List<UndirectedEdge> getEdges(final Node node) {
        return edges.stream().filter(edge -> edge.containsNode(node)).collect(Collectors.toList());
    }

    private void redirectEdges(final Node remainingNode, final Node destroyedNode) {
        List<UndirectedEdge> edgesAroundDestroyedNode = getEdges(destroyedNode);
        edgesAroundDestroyedNode.forEach(edge -> edge.replaceNode(destroyedNode, remainingNode));
    }


}
