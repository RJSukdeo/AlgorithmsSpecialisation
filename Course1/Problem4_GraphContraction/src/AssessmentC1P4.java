import Graph.ContractionAlgorithm;
import Graph.ContractionAlgorithmResults;
import Graph.GraphGenerator;
import Graph.UndirectedGraphInputs;
import Graph.UndirectedGraphInputs.InputBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AssessmentC1P4 {

    public static void main(String[] args) throws FileNotFoundException {
        GraphGenerator graphGenerator = GraphGenerator.getGeneratorUndirected(getGraphInfo());
        int smallestCrossingEdges = graphGenerator.getNodes(false).size();
        for (int i = 0; i < Math.pow(graphGenerator.getNodes(false).size(), 2); i++) {
            ContractionAlgorithm contractionAlgorithm = new ContractionAlgorithm(graphGenerator);
            ContractionAlgorithmResults results = contractionAlgorithm.run();
            if (results.getCrossingEdges() < smallestCrossingEdges) {
                smallestCrossingEdges = results.getCrossingEdges();
            }
        }
        System.out.println("Minimum number of crossing edges: " + smallestCrossingEdges);
    }

    private static UndirectedGraphInputs getGraphInfo() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/Course1/Problem4_GraphContraction/resources/Graph.txt");
        Scanner scanner = new Scanner(file);
        InputBuilder builder = new InputBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> stringNumbers = Arrays.asList(line.split("\t"));
            List<Integer> numbers = new ArrayList<>(stringNumbers.size() - 1);
            stringNumbers.subList(1, stringNumbers.size()).forEach(s -> numbers.add(Integer.valueOf(s)));
            builder.addEntry(Integer.valueOf(stringNumbers.get(0)), numbers);
        }
        return builder.build();
    }

}
