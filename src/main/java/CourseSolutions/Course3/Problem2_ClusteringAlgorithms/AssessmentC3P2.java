package CourseSolutions.Course3.Problem2_ClusteringAlgorithms;

import CourseSolutions.ICourseSolution;
import Graph.*;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class AssessmentC3P2 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        System.out.println("This assessment may take hours to run!!! Very large datasets.");
        runAssessmentOne();
        runAssessmentTwo();
    }

    private void runAssessmentOne() {
        ClusteringAlgorithmResults results = new ClusteringAlgorithm(getGraphInputsProblemOne()).run(4);
        System.out.println("Max spacing between clusters: " + results.getMinDistanceBetweenClusters());
    }

    private void runAssessmentTwo() {
        HammingClusteringAlgorithm algorithm = new HammingClusteringAlgorithm(getBinaryData());
        HammingClusteringAlgorithmResult result = algorithm.run();
        System.out.println("Number of clusters required: " + result.getClusters());
    }

    private UndirectedGraphInputs getGraphInputsProblemOne() {
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("clustering1.txt");
        Scanner scanner = new Scanner(inputStream);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] entries = scanner.nextLine().split(" ");
            builder.addEntry(Integer.parseInt(entries[0]) - 1, Integer.parseInt(entries[1]) - 1, Integer.parseInt(entries[2]));
        }
        return builder.build();
    }

    private List<String> getBinaryData() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("clustering_big.txt");
        Scanner scanner = new Scanner(inputStream);
        String[] info = scanner.nextLine().split(" ");
        List<String> entries = new ArrayList<>(Integer.parseInt(info[0]));
        while (scanner.hasNextLine()) {
            entries.add(scanner.nextLine().replace(" ", ""));
        }
        return entries;
    }

    @Override
    public String getProblemDescription() {
        return "Clustering algorithm implementations, uses Kruskal's algorithm.";
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
