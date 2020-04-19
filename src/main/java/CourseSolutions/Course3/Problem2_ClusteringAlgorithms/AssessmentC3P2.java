package CourseSolutions.Course3.Problem2_ClusteringAlgorithms;

import CourseSolutions.ICourseSolution;
import Graph.ClusteringAlgorithm;
import Graph.ClusteringAlgorithmResults;
import Graph.UndirectedGraphInputs;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class AssessmentC3P2 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        runAssessmentOne();
        runAssessmentTwo();
    }

    private void runAssessmentOne() {
        ClusteringAlgorithmResults results = new ClusteringAlgorithm(getGraphInputsProblemOne(), 1, 499).run(4);
        System.out.println("Max spacing between clusters: " + results.getMaxDistanceBetweenClusters());
    }

    private void runAssessmentTwo() {

    }

    private UndirectedGraphInputs getGraphInputsProblemOne() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("clustering1.txt");
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNextLine()) {
            String[] entries = scanner.nextLine().split(" ");
            builder.addEntry(Integer.parseInt(entries[0]), Integer.parseInt(entries[1]), Integer.parseInt(entries[2]));
        }
        return builder.build();
    }

    @Override
    public String getProblemDescription() {
        return "Clustering algorithm implementations.";
    }

    @Override
    public short getCourseNumber() {
        return 3;
    }

    @Override
    public short getProblemNumber() {
        return 2;
    }

}
