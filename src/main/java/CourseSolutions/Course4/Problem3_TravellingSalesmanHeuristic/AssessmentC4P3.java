package CourseSolutions.Course4.Problem3_TravellingSalesmanHeuristic;

import CourseSolutions.ICourseSolution;
import Graph.TSPHeuristicAlgorithm;
import Graph.TSPHeuristicAlgorithmResults;
import Graph.TwoDimensionPoint;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AssessmentC4P3 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        TSPHeuristicAlgorithm algorithm = new TSPHeuristicAlgorithm(getGraphInputs());
        TSPHeuristicAlgorithmResults results = algorithm.run(1);
        System.out.println("Minimum distance: " + results.getMinimumDistance());
    }

    private Map<Integer, TwoDimensionPoint> getGraphInputs() {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("nn.txt"));
        Map<Integer, TwoDimensionPoint> nodeIdToPointMap = new HashMap<>(Integer.parseInt(scanner.nextLine()));
        while (scanner.hasNextLine()) {
            String[] elements = scanner.nextLine().split(" ");
            nodeIdToPointMap.put(Integer.parseInt(elements[0]), new TwoDimensionPoint(Double.parseDouble(elements[1]), Double.parseDouble(elements[2])));
        }
        return nodeIdToPointMap;
    }

    @Override
    public String getProblemDescription() {
        return "Heuristic travelling salesman algorithm.";
    }

    @Override
    public short getCourseNumber() {
        return 4;
    }

    @Override
    public short getProblemNumber() {
        return 3;
    }
}
