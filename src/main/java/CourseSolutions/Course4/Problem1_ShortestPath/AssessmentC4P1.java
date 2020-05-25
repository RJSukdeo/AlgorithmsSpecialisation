package CourseSolutions.Course4.Problem1_ShortestPath;

import CourseSolutions.ICourseSolution;
import Graph.DirectedGraphInputs;
import Graph.JohnsonAlgorithm;
import Graph.JohnsonAlgorithmResults;

import java.io.FileNotFoundException;
import java.util.OptionalLong;
import java.util.Scanner;

public final class AssessmentC4P1 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        runExampleG1();
        runExampleG2();
        runExampleG3();
    }

    private void runExampleG1() {
        DirectedGraphInputs graphInputs = getInputsG1();
        JohnsonAlgorithm algorithm = new JohnsonAlgorithm(graphInputs);
        JohnsonAlgorithmResults results = algorithm.run();
        generateMessage(results.getShortestShortestPath(), "g1");
    }

    private void runExampleG2() {
        DirectedGraphInputs graphInputs = getInputsG2();
        JohnsonAlgorithm algorithm = new JohnsonAlgorithm(graphInputs);
        JohnsonAlgorithmResults results = algorithm.run();
        generateMessage(results.getShortestShortestPath(), "g2");
    }

    private void runExampleG3() {
        DirectedGraphInputs graphInputs = getInputsG3();
        JohnsonAlgorithm algorithm = new JohnsonAlgorithm(graphInputs);
        JohnsonAlgorithmResults results = algorithm.run();
        generateMessage(results.getShortestShortestPath(), "g3");
    }

    private static DirectedGraphInputs getInputsG1() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("g1.txt"));
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            String[] elements = scanner.nextLine().split(" ");
            builder.addEntry(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
        }
        return builder.build();
    }

    private static DirectedGraphInputs getInputsG2() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("g2.txt"));
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            String[] elements = scanner.nextLine().split(" ");
            builder.addEntry(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
        }
        return builder.build();
    }

    private static DirectedGraphInputs getInputsG3() {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("g3.txt"));
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            String[] elements = scanner.nextLine().split(" ");
            builder.addEntry(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
        }
        return builder.build();
    }

    private static void generateMessage(OptionalLong distance, String dataset) {
        StringBuilder sb = new StringBuilder();
        sb.append("Shortest path for ").append(dataset).append(": ");
        if (distance.isPresent()) {
            sb.append(distance.getAsLong());
        } else {
            sb.append("null");
        }
        System.out.println(sb);
    }

    @Override
    public String getProblemDescription() {
        return "Find the shortest shortest path from three different graphs.";
    }

    @Override
    public short getCourseNumber() {
        return 4;
    }

    @Override
    public short getProblemNumber() {
        return 1;
    }

}
