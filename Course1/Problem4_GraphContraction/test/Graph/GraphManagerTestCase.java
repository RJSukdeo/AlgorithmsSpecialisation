package Graph;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphManagerTestCase {

    @Test
    public void testEmptyConstructor() {
        GraphManager graphManager = new GraphManager();
        assertTrue(graphManager.getEdges().isEmpty());
        assertTrue(graphManager.getNodes().isEmpty());
    }

    @Test
    public void testHashMapConstructor() {
        GraphManager graphManager = new GraphManager(getGraphInputs());
        Set<Node> nodes = graphManager.getNodes();
        Collection<Edge> edges = graphManager.getEdges();

        assertEquals(4, nodes.size());
        assertEquals(5, edges.size());
        assertTrue(nodes.contains(new Node(1)));
        assertTrue(nodes.contains(new Node(2)));
        assertTrue(nodes.contains(new Node(3)));
        assertTrue(nodes.contains(new Node(4)));
        assertTrue(edges.contains(new Edge(new Node(1), new Node(2))));
        assertTrue(edges.contains(new Edge(new Node(2), new Node(3))));
        assertTrue(edges.contains(new Edge(new Node(3), new Node(4))));
        assertTrue(edges.contains(new Edge(new Node(1), new Node(4))));
        assertTrue(edges.contains(new Edge(new Node(1), new Node(3))));

        Node node1 = nodes.stream().filter(node -> node.getId() == 1).findFirst().get();
        Node node2 = nodes.stream().filter(node -> node.getId() == 2).findFirst().get();
        Node node3 = nodes.stream().filter(node -> node.getId() == 3).findFirst().get();
        Node node4 = nodes.stream().filter(node -> node.getId() == 4).findFirst().get();

        List<Node> connectedNodes = new ArrayList<>(3);
        connectedNodes.add(new Node(2));
        connectedNodes.add(new Node(3));
        connectedNodes.add(new Node(4));
        assertTrue(node1.getConnectedNodes().containsAll(connectedNodes));
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(new Node(1));
        connectedNodes.add(new Node(3));
        assertTrue(node2.getConnectedNodes().containsAll(connectedNodes));
        connectedNodes = new ArrayList<>(3);
        connectedNodes.add(new Node(1));
        connectedNodes.add(new Node(2));
        connectedNodes.add(new Node(4));
        assertTrue(node3.getConnectedNodes().containsAll(connectedNodes));
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(new Node(1));
        connectedNodes.add(new Node(3));
        assertTrue(node4.getConnectedNodes().containsAll(connectedNodes));
    }

    @Test
    public void testRunContractionAlgorithm() {
        GraphManager graphManager = new GraphManager(getGraphInputs());
        ContractionAlgorithmResults results = graphManager.runContractionAlgorithm(30);
        assertEquals(2, results.getCrossingEdges());

        graphManager = new GraphManager(getGraphInputs());
        results = graphManager.runContractionAlgorithm(10);
        assertEquals(2, results.getCrossingEdges());

        graphManager = new GraphManager(getGraphInputs());
        results = graphManager.runContractionAlgorithm(95);
        assertEquals(3, results.getCrossingEdges());
    }


    //  getGraphInputs produces the input to be used by GraphManager, graph represented below.
//
//  1-----2
//  | \   |
//  |  \  |
//  |   \ |
//  4-----3
    private Map<Integer, List<Integer>> getGraphInputs() {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();

        // Define node 1
        List<Integer> connectedNodes = new ArrayList<>(3);
        connectedNodes.add(2);
        connectedNodes.add(3);
        connectedNodes.add(4);
        graphMap.put(1, connectedNodes);

        // Define node 2
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(1);
        connectedNodes.add(3);
        graphMap.put(2, connectedNodes);

        // Define node 3
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(2);
        connectedNodes.add(4);
        connectedNodes.add(1);
        graphMap.put(3, connectedNodes);

        // Define node 4
        connectedNodes = new ArrayList<>(2);
        connectedNodes.add(1);
        connectedNodes.add(3);
        graphMap.put(4, connectedNodes);

        return graphMap;
    }

}
