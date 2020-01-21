import Pivot.LeftMostPivotSelector;
import Pivot.MedianPivotSelector;
import Pivot.RightMostPivotSelector;
import QuickSort.QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class AssessmentC1P3 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/Course1/Problem3_QuickSort/resources/QuickSort.txt");
        Scanner scanner = new Scanner(file);
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
}
