import MedianMaintenance.MedianCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class AssessmentC2P3 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/resources/Median.txt");
        Scanner scanner = new Scanner(file);
        MedianCalculator calculator = MedianCalculator.getInstance();
        double sum = 0;
        while (scanner.hasNextInt()) {
            int element = scanner.nextInt();
            sum += calculator.addElement(element).getMedian();
        }
        System.out.println("Sum of medians mod 10000: " + (sum % 10000));
    }

}
