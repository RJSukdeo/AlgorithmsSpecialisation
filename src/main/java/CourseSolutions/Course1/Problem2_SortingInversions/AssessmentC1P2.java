package CourseSolutions.Course1.Problem2_SortingInversions;

import CourseSolutions.ICourseSolution;
import Inversions.InversionsCounter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Expected output
// 2407905288

public final class AssessmentC1P2 implements ICourseSolution {

    @Override
    public String getProblemDescription() {
        return "Counting inversions in an array using Merge Sort algorithm.";
    }

    @Override
    public short getCourseNumber() {
        return 1;
    }

    @Override
    public short getProblemNumber() {
        return 2;
    }

    @Override
    public void run() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("IntegerArray.txt");
        Scanner scanner = new Scanner(inputStream);
        List<Integer> elements = new ArrayList<>();
        while (scanner.hasNextInt()) {
            elements.add(scanner.nextInt());
        }
        InversionsCounter counter = new InversionsCounter(elements);
        System.out.println("Number of Inversions: " + counter.getNumberOfInversions());
    }

}
