package Graph;

import Graph.UndirectedGraphInputs.InputBuilder;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ContractionAlgorithmTestCase {

    @Test
    public void testRunContractionAlgorithm() {
        GraphGenerator graphGenerator = GraphGenerator.getGeneratorUndirected(new InputBuilder().addEntries(GraphTestData.getUndirectedGraphInputs()).build());
        ContractionAlgorithm contractionAlgorithm = new ContractionAlgorithm(graphGenerator, new Random(30));
        ContractionAlgorithmResults results = contractionAlgorithm.run();
        assertEquals(2, results.getCrossingEdges());

        contractionAlgorithm = new ContractionAlgorithm(graphGenerator, new Random(10));
        results = contractionAlgorithm.run();
        assertEquals(2, results.getCrossingEdges());

        contractionAlgorithm = new ContractionAlgorithm(graphGenerator, new Random(95));
        results = contractionAlgorithm.run();
        assertEquals(3, results.getCrossingEdges());
    }

}
