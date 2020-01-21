package Graph;

import Graph.UndirectedGraphInputs.InputBuilder;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ContractionAlgorithmTestCase {

    @Test
    public void testRunContractionAlgorithm() {
        UndirectedGraphGenerator undirectedGraphGenerator = UndirectedGraphGenerator.getGeneratorUndirected(new InputBuilder().addEntries(GraphTestData.getUndirectedGraphInputs()).build());
        ContractionAlgorithm contractionAlgorithm = new ContractionAlgorithm(undirectedGraphGenerator, new Random(30));
        ContractionResult results = contractionAlgorithm.run();
        assertEquals(2, results.getCrossingEdges());

        contractionAlgorithm = new ContractionAlgorithm(undirectedGraphGenerator, new Random(10));
        results = contractionAlgorithm.run();
        assertEquals(2, results.getCrossingEdges());

        contractionAlgorithm = new ContractionAlgorithm(undirectedGraphGenerator, new Random(95));
        results = contractionAlgorithm.run();
        assertEquals(3, results.getCrossingEdges());
    }

}
