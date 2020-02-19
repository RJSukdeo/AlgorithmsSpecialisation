package CourseSolutions.Course1.Problem3_QuickSort;

import CourseSolutions.ICourseSolution;
import Pivot.LeftMostPivotSelector;
import Pivot.MedianPivotSelector;
import Pivot.RightMostPivotSelector;
import QuickSort.QuickSort;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Expected output
// Number of Comparisons (Leftmost): 162085
// Number of Comparisons (Rightmost): 164123
// Number of Comparisons (Median): 138382

public final class AssessmentC1P3 implements ICourseSolution {

    @Override
    public void run() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("QuickSort.txt");
        Scanner scanner = new Scanner(inputStream);
        List<Integer> elementsLeftPivot = new ArrayList<>();
        while (scanner.hasNextInt()) {
            elementsLeftPivot.add(scanner.nextInt());
        }
        List<Integer> elementsRightPivot = new ArrayList<>(elementsLeftPivot);
        List<Integer> elementsMedianPivot = new ArrayList<>(elementsRightPivot);

        QuickSort sort = new QuickSort(elementsLeftPivot, new LeftMostPivotSelector());
        System.out.println("Number of Comparisons (Leftmost): " + sort.getNumberOfComparisons());

        sort = new QuickSort(elementsRightPivot, new RightMostPivotSelector());
        System.out.println("Number of Comparisons (Rightmost): " + sort.getNumberOfComparisons());

        sort = new QuickSort(elementsMedianPivot, new MedianPivotSelector());
        System.out.println("Number of Comparisons (Median): " + sort.getNumberOfComparisons());
    }

    @Override
    public String getProblemDescription() {
        return "Implementation of Quick Sort algorithm.";
    }

    @Override
    public short getCourseNumber() {
        return 1;
    }

    @Override
    public short getProblemNumber() {
        return 3;
    }
}
