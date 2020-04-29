package CourseSolutions.Course3.Problem3_CompressionDynamicAlgorithms;

import CourseSolutions.ICourseSolution;
import GreedyAlgorithms.HuffmanAlgorithm;
import GreedyAlgorithms.HuffmanAlgorithmInput;
import GreedyAlgorithms.HuffmanAlgorithmResults;

import java.io.FileNotFoundException;
import java.util.Scanner;

public final class AssessmentC3P3 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        runAssessmentOne();
    }

    private void runAssessmentOne() {
        HuffmanAlgorithm algorithm = new HuffmanAlgorithm(getHuffmanInputs());
        HuffmanAlgorithmResults results = algorithm.run();
        System.out.println("Maximum code length: " + results.getMaximumBitSize());
        System.out.println("Minimum code length: " + results.getMinimumBitSize());
    }

    private void runAssessmentTwo() {

    }

    private HuffmanAlgorithmInput getHuffmanInputs() {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("huffman.txt"));
        int numberOfElements = scanner.nextInt();
        HuffmanAlgorithmInput input = new HuffmanAlgorithmInput(numberOfElements);
        for (int i = 0; i < numberOfElements; i++) {
            input.addEntry(i, Long.parseLong(scanner.next()));
        }
        return input;
    }

    @Override
    public String getProblemDescription() {
        return "Huffman codes and Maximum Weighted Independent Sets.";
    }

    @Override
    public short getCourseNumber() {
        return 3;
    }

    @Override
    public short getProblemNumber() {
        return 3;
    }
}
