package CourseSolutions.Course4.Problem2_TravellingSalesman;

import CourseSolutions.ICourseSolution;
import Graph.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AssessmentC4P2 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        TwoDimensionPoint[] points = getTwoDimensionalPoints();
        runSplitGraphAlgorithm(points);
    }

    private void runSplitGraphAlgorithm(TwoDimensionPoint[] points) {
        double firstGraphDistance = getShortestDistance(points, 0, 13);
        double secondGraphDistance = getShortestDistance(points, 11, 25);
        double repeatedLineDistance = EuclideanDistance.getEuclideanDistance(points[11], points[12]);
        System.out.println("First Distance: " + firstGraphDistance);
        System.out.println("Second distance: " + secondGraphDistance);
        System.out.println("Repeated line distance: " + repeatedLineDistance);
        System.out.println("Total distance: " + ((firstGraphDistance + secondGraphDistance) - 2 * (repeatedLineDistance)));
    }

    private double getShortestDistance(TwoDimensionPoint[] points, int copyStart, int copyEnd) {
        UndirectedGraphGenerator graphGenerator = UndirectedGraphGenerator.getGenerator(getGraphInputs(Arrays.copyOfRange(points, copyStart, copyEnd)));
        TSPAlgorithm algorithm = new TSPAlgorithm(graphGenerator);
        TSPAlgorithmResults results = algorithm.run();
        return results.getShortestDistance();
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
