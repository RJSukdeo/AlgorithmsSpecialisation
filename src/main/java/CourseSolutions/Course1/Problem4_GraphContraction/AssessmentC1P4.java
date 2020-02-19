package CourseSolutions.Course1.Problem4_GraphContraction;

import CourseSolutions.ICourseSolution;
import Graph.ContractionAlgorithm;
import Graph.ContractionResult;
import Graph.UndirectedGraphGenerator;
import Graph.UndirectedGraphInputs;
import Graph.UndirectedGraphInputs.InputBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Expected output
// Minimum number of crossing edges: 17

public final class AssessmentC1P4 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        System.out.println("Please note this algorithm takes some time to run, calls the contraction algorithm 40000 times!!!");
        UndirectedGraphGenerator undirectedGraphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInfo());
        int smallestCrossingEdges = undirectedGraphGenerator.getNodes(false).size();
        for (int i = 0; i < Math.pow(undirectedGraphGenerator.getNodes(false).size(), 2); i++) {
            ContractionAlgorithm contractionAlgorithm = new ContractionAlgorithm(undirectedGraphGenerator);
            ContractionResult results = contractionAlgorithm.run();
            if (results.getCrossingEdges() < smallestCrossingEdges) {
                smallestCrossingEdges = results.getCrossingEdges();
            }
        }
        System.out.println("Minimum number of crossing edges: " + smallestCrossingEdges);
    }

    @Override
    public String getProblemDescription() {
        return "Finds the number of crossing edges using Contraction algorithm (Undirected Edges).";
    }

    @Override
    public short getCourseNumber() {
        return 1;
    }

    @Override
    public short getProblemNumber() {
        return 4;
    }

    private static UndirectedGraphInputs getGraphInfo() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("Graph.txt");
        Scanner scanner = new Scanner(inputStream);
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
