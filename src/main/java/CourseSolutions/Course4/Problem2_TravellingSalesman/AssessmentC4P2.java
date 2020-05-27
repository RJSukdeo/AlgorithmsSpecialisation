package CourseSolutions.Course4.Problem2_TravellingSalesman;

import CourseSolutions.ICourseSolution;
import Graph.TSPAlgorithm;
import Graph.TSPAlgorithmResults;
import Graph.UndirectedGraphGenerator;
import Graph.UndirectedGraphInputs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssessmentC4P2 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputs());
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        System.out.println("Shortest distance: " + results.getShortestDistance());
    }

    private UndirectedGraphInputs getGraphInputs() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("tsp.txt"));
        int numberOfElements = Integer.parseInt(scanner.nextLine());
        List<InputPoint> inputPoints = new ArrayList<>(numberOfElements);
        while (scanner.hasNextLine()) {
            String[] elements = scanner.nextLine().split(" ");
            inputPoints.add(new InputPoint(Double.parseDouble(elements[0]), Double.parseDouble(elements[1])));
        }
        for (int i = 0; i < numberOfElements; i++) {
            for (int j = i + 1; j < numberOfElements; j++) {
                builder.addEntry(i + 1, j + 1, getEuclideanDistance(inputPoints.get(i), inputPoints.get(j)));
            }
        }
        return builder.build();
    }

    @Override
    public String getProblemDescription() {
        return "Travelling salesman problem, dynamic programming algorithm.";
    }

    @Override
    public short getCourseNumber() {
        return 4;
    }

    @Override
    public short getProblemNumber() {
        return 2;
    }

    private double getEuclideanDistance(InputPoint point1, InputPoint point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    private class InputPoint {

        private final double x;
        private final double y;

        public InputPoint(final double x, final double y) {
            this.x = x;
            this.y = y;
        }

    }

}
