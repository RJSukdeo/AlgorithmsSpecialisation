package CourseSolutions.Course3.Problem1_GreedyAlgorithms;

import CourseSolutions.ICourseSolution;
import Graph.PrimMinimumSpanningTreeAlgorithm;
import Graph.PrimMinimumSpanningTreeAlgorithmResults;
import Graph.UndirectedGraphGenerator;
import Graph.UndirectedGraphInputs;
import GreedyScheduling.*;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class AssessmentC3P1 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        SchedulingData schedulingData = new SchedulingData();
        runFirstAssessment(schedulingData);
        runSecondAssessment(schedulingData);
        runThirdAssessment(new GraphData());
    }

    private void runFirstAssessment(final SchedulingData schedulingData) {
        SchedulingAlgorithmResults results = new SchedulingAlgorithm(schedulingData.getEntries()).run(new DifferenceComparator());
        DataItem[] orderedEntries = results.getOrderdEntries();
        System.out.println("Weighted sum of completion time (Difference Comparator):" + getWeightedCompletionSum(orderedEntries));
    }

    private void runSecondAssessment(final SchedulingData schedulingData) {
        SchedulingAlgorithmResults results = new SchedulingAlgorithm(schedulingData.getEntries()).run(new DivisionComparator());
        DataItem[] orderedEntries = results.getOrderdEntries();
        System.out.println("Weighted sum of completion time (Division Comparator):" + getWeightedCompletionSum(orderedEntries));
    }

    private void runThirdAssessment(final GraphData graphData) {
        PrimMinimumSpanningTreeAlgorithmResults results = new PrimMinimumSpanningTreeAlgorithm(UndirectedGraphGenerator.getGenerator(graphData.getUndirectedGraphInputs())).run();
        System.out.println("Sum of paths of Minimum Spanning Tree: " + results.getTreeLength());
    }

    private long getWeightedCompletionSum(final DataItem[] orderedEntries) {
        long sum = 0;
        long completionTime = 0;
        for (DataItem orderedEntry : orderedEntries) {
            completionTime += orderedEntry.getLength();
            sum += orderedEntry.getWeight() * completionTime;
        }
        return sum;
    }

    @Override
    public String getProblemDescription() {
        return "Implementation of scheduling algorithm and Prim's Minimum Spanning Tree Algorithm.";
    }

    @Override
    public short getCourseNumber() {
        return 3;
    }

    @Override
    public short getProblemNumber() {
        return 1;
    }

    private static final class SchedulingData {
        private final int jobNum;
        private final List<DataItem> entries;

        SchedulingData() {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("jobs.txt");
            Scanner scanner = new Scanner(inputStream);
            jobNum = Integer.valueOf(scanner.nextLine());
            entries = new ArrayList<>(jobNum);
            while (scanner.hasNext()) {
                String[] stringEntries = scanner.nextLine().split(" ");
                entries.add(new DataItem(Integer.parseInt(stringEntries[0]), Integer.parseInt(stringEntries[1])));
            }
        }

        public int getJobNum() {
            return jobNum;
        }

        public List<DataItem> getEntries() {
            return entries;
        }
    }

    private static final class GraphData {
        private final int numEdges;
        private final int numVertices;
        private final UndirectedGraphInputs undirectedGraphInputs;

        public GraphData() {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("edges.txt");
            Scanner scanner = new Scanner(inputStream);
            String[] numElements = scanner.nextLine().split(" ");
            numVertices = Integer.parseInt(numElements[0]);
            numEdges = Integer.parseInt(numElements[1]);
            UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
            while(scanner.hasNextLine()) {
                String[] edgeInfo = scanner.nextLine().split(" ");
                builder.addEntry(Integer.parseInt(edgeInfo[0]), Integer.parseInt(edgeInfo[1]), Double.parseDouble(edgeInfo[2]));
            }
            undirectedGraphInputs = builder.build();
        }

        public UndirectedGraphInputs getUndirectedGraphInputs() {
            return undirectedGraphInputs;
        }
    }

}
