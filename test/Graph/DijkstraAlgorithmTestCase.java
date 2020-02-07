package Graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DijkstraAlgorithmTestCase {

    @Test
    public void testRunAlgorithm() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGeneratorUndirected(GraphTestData.getUndirectedGraphInputsWithLength().build());
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graphGenerator);
        DijkstraAlgorithmResults results = algorithm.run(2);

        assertEquals(1, results.getDistanceToNode(1), 1e-2);
        assertEquals(0, results.getDistanceToNode(2), 1e-2);
        assertEquals(3, results.getDistanceToNode(3), 1e-2);
        assertEquals(4, results.getDistanceToNode(4), 1e-2);
    }

    @Test
    public void testRunAlgorithm2() {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGeneratorUndirected(GraphTestData.getUndirectedGraphInputsWithLength2().build());
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graphGenerator);
        DijkstraAlgorithmResults results = algorithm.run(0);

        assertEquals(0, results.getDistanceToNode(0), 1e-2);
        assertEquals(4, results.getDistanceToNode(1), 1e-2);
        assertEquals(12, results.getDistanceToNode(2), 1e-2);
        assertEquals(19, results.getDistanceToNode(3), 1e-2);
        assertEquals(21, results.getDistanceToNode(4), 1e-2);
        assertEquals(11, results.getDistanceToNode(5), 1e-2);
        assertEquals(9, results.getDistanceToNode(6), 1e-2);
        assertEquals(8, results.getDistanceToNode(7), 1e-2);
        assertEquals(14, results.getDistanceToNode(8), 1e-2);
    }

}
