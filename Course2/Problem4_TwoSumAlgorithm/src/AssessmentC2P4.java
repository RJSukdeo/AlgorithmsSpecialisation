import DistinctPairIndentifier.TwoSumAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class AssessmentC2P4 {

    public static void main(String[] args) throws FileNotFoundException {
        TwoSumAlgorithm algorithm = TwoSumAlgorithm.getInstance(getData());
        int counter = 0;
        int counterDisplay = 0;
        for (Integer targetSum : getTargetSums()) {
            System.out.println(counterDisplay++);
            if (algorithm.run(targetSum).getNoDistinctPairs() > 0) {
                counter++;
            }
        }
        System.out.println("Number of Distinct Pairs [-10000, 10000]: " + counter);
    }

    private static LinkedList<Integer> getTargetSums() {
        LinkedList targetSums = new LinkedList();
        for (int i = -10000; i < 10001; i++) {
            targetSums.add(i);
        }
        return targetSums;
    }

    private static List<Long> getData() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/resources/TwoSum.txt");
        Scanner scanner = new Scanner(file);
        List<Long> elements = new ArrayList<>(1000000);
        while (scanner.hasNextLong()) {
            elements.add(scanner.nextLong());
        }
        return elements;
    }

}


