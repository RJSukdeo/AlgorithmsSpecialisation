import Inversions.InversionsCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssessmentC1P2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/Course1/Problem2_SortingInversions/resources/IntegerArray.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> elements = new ArrayList<>();
        while (scanner.hasNextInt()) {
            elements.add(scanner.nextInt());
        }
        InversionsCounter counter = new InversionsCounter(elements);
        System.out.println("Number of Inversions: " + counter.getNumberOfInversions());
    }

}
