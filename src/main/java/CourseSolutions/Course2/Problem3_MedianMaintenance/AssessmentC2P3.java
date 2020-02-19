package CourseSolutions.Course2.Problem3_MedianMaintenance;

import CourseSolutions.ICourseSolution;
import MedianMaintenance.MedianCalculator;

import java.io.InputStream;
import java.util.Scanner;

// Expected output
// Sum of medians mod 10000: 1213.0

public final class AssessmentC2P3 implements ICourseSolution {

    @Override
    public void run() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("Median.txt");
        Scanner scanner = new Scanner(inputStream);
        MedianCalculator calculator = MedianCalculator.getInstance();
        double sum = 0;
        while (scanner.hasNextInt()) {
            int element = scanner.nextInt();
            sum += calculator.addElement(element).getMedian();
        }
        System.out.println("Sum of medians mod 10000: " + (sum % 10000));
    }

    @Override
    public String getProblemDescription() {
        return "Algorithm that finds the sum of all medians mod 10000, using heap data structures.";
    }

    @Override
    public short getCourseNumber() {
        return 2;
    }

    @Override
    public short getProblemNumber() {
        return 3;
    }

}
