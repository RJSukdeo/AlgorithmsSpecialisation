package CourseSolutions.Course3.Problem1_GreedyAlgorithms;

import CourseSolutions.ICourseSolution;
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

    private final class SchedulingData {
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

}
