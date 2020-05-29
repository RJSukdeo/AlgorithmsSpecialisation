package CourseSolutions.Course4.Problem2_TravellingSalesman;

import CourseSolutions.ICourseSolution;
import Graph.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AssessmentC4P2 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        TwoDimensionPoint[] points = getTwoDimensionalPoints();
        runSplitGraphAlgorithm(points);
//        runEntireGraphAlgorithm(points);
    }

    private void runEntireGraphAlgorithm(TwoDimensionPoint[] points) {
        Collections.reverse(Arrays.asList(points));
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputs(points));
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        System.out.println();
        System.out.println("Total distance: " + results.getShortestDistance());
    }

    private void printNodePath(List<Integer> nodeIds) {
        StringBuilder sb =  new StringBuilder();
        sb.append("Node path: ");
        sb.append(nodeIds.get(0));
        for (int i = 1; i < nodeIds.size(); i++) {
            sb.append(" --> ");
            sb.append(nodeIds.get(i));
        }
        System.out.println(sb);
    }

    private void runSplitGraphAlgorithm(TwoDimensionPoint[] points) {
        TSPAlgorithmResults firstGraphResults = getAlgorithmResults(points, 0, 13);
        TSPAlgorithmResults secondGraphResults = getAlgorithmResults(points, 11, 25);
        double repeatedLineDistance = EuclideanDistance.getEuclideanDistance(points[11], points[12]);
        System.out.println("First Distance: " + firstGraphResults.getShortestDistance());
        printNodePath(firstGraphResults.getNodePath());
        System.out.println("Second distance: " + secondGraphResults.getShortestDistance());
        printNodePath(secondGraphResults.getNodePath());
        System.out.println("Repeated line distance: " + repeatedLineDistance);
        System.out.println("Total distance: " + ((firstGraphResults.getShortestDistance() + secondGraphResults.getShortestDistance()) - 2 * (repeatedLineDistance)));
    }

    private TSPAlgorithmResults getAlgorithmResults(TwoDimensionPoint[] points, int copyStart, int copyEnd) {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputs(Arrays.copyOfRange(points, copyStart, copyEnd)));
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        return algorithm.run();
    }

    private TwoDimensionPoint[] getTwoDimensionalPoints() {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("tsp.txt"));
        TwoDimensionPoint[] twoDimensionPoints = new TwoDimensionPoint[Integer.parseInt(scanner.nextLine())];
        int counter = 0;
        while (scanner.hasNextLine()) {
            String[] elements = scanner.nextLine().split(" ");
            twoDimensionPoints[counter] = new TwoDimensionPoint(Double.parseDouble(elements[0]), Double.parseDouble(elements[1]));
            counter++;
        }
        return twoDimensionPoints;
    }

    private UndirectedGraphInputs getGraphInputs(TwoDimensionPoint[] points) {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                builder.addEntry(i + 1, j + 1, EuclideanDistance.getEuclideanDistance(points[i], points[j]));
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


}
