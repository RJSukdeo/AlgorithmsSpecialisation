package CourseSolutions.Course4.Problem4_TwoSATProblem;

import CourseSolutions.ICourseSolution;
import Graph.TwoSATAlgorithm;
import Graph.TwoSATAlgorithmResults;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssessmentC4P4 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        for (int i = 1; i <= 6; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("2sat").append(i).append(".txt");
            TwoSATAlgorithmResults results = new TwoSATAlgorithm(getEntries(sb.toString())).run();
            outputMessage(i, results);
        }
    }

    private void outputMessage(int counter, TwoSATAlgorithmResults results) {
        System.out.println("Problem: " + counter + ": " + results.isSatisfiable());
    }

    private String[] getEntries(String filename) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(filename));
        String[] entries = new String[Integer.parseInt(scanner.nextLine())];
        int counter = 0;
        while (scanner.hasNextLine()) {
            entries[counter] = scanner.nextLine();
            counter++;
        }
        return entries;
    }

    @Override
    public String getProblemDescription() {
        return "Solving the 2 SAT problem using strongly connected components.";
    }

    @Override
    public short getCourseNumber() {
        return 4;
    }

    @Override
    public short getProblemNumber() {
        return 4;
    }
}
