package CourseSolutions.Course3.Problem3_CompressionDynamicAlgorithms;

import CourseSolutions.ICourseSolution;
import GreedyAlgorithms.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class AssessmentC3P3 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        runAssessmentOne();
        runAssessmentTwo();
    }

    private void runAssessmentOne() {
        HuffmanAlgorithm algorithm = new HuffmanAlgorithm(getHuffmanInputs());
        HuffmanAlgorithmResults results = algorithm.run();
        System.out.println("Maximum code length: " + results.getMaximumBitSize());
        System.out.println("Minimum code length: " + results.getMinimumBitSize());
    }

    private void runAssessmentTwo() {
        System.out.println();
        MaxIndependentSetAlgorithm algorithm = new MaxIndependentSetAlgorithm(getWeightInputs());
        MaxIndependentSetAlgorithmResults results = algorithm.run();
        List<Integer> includedInMaximumSet = results.getIncludedInMaximumSet();
        int[] vertices = new int[] {1, 2, 3, 4, 17, 117, 517, 997};
        for (int vertex: vertices) {
            System.out.println("Vertex " + vertex + " result: " + includedInMaximumSet.get(vertex - 1));
        }
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

    private List<Long> getWeightInputs() {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("mwis.txt"));
        int numberOfElements = Integer.parseInt(scanner.nextLine());
        List<Long> weights = new ArrayList<>(numberOfElements);
        while (scanner.hasNextLine()){
            weights.add(Long.parseLong(scanner.nextLine()));
        }
        return weights;
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
