package CourseSolutions.Course2.Problem4_TwoSumAlgorithm;

import CourseSolutions.ICourseSolution;
import DistinctPairIndentifier.TwoSumAlgorithm;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Expected output
// Number of Distinct Pairs [-10000, 10000]: 427

public final class AssessmentC2P4 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        System.out.println("Please note this algorithm takes some time to run, runs against all distinct sums [-10000,10000]!!!");
        TwoSumAlgorithm algorithm = TwoSumAlgorithm.getInstance(getData());
        int counter = 0;
        for (Integer targetSum : getTargetSums()) {
            if (algorithm.run(targetSum).getNoDistinctPairs() > 0) {
                counter++;
            }
        }
        System.out.println("Number of Distinct Pairs [-10000, 10000]: " + counter);
    }

    private static LinkedList<Integer> getTargetSums() {
        LinkedList<Integer> targetSums = new LinkedList<>();
        for (int i = -10000; i < 10001; i++) {
            targetSums.add(i);
        }
        return targetSums;
    }

    private static List<Long> getData() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("TwoSum.txt");
        Scanner scanner = new Scanner(inputStream);
        List<Long> elements = new ArrayList<>(1000000);
        while (scanner.hasNextLong()) {
            elements.add(scanner.nextLong());
        }
        return elements;
    }

    @Override
    public String getProblemDescription() {
        return "Algorithm that calculates the number of distinct pairs summing to [-10000, 10000].";
    }

    @Override
    public short getCourseNumber() {
        return 2;
    }

    @Override
    public short getProblemNumber() {
        return 4;
    }

}


