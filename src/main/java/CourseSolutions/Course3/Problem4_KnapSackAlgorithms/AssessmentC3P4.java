package CourseSolutions.Course3.Problem4_KnapSackAlgorithms;

import CourseSolutions.ICourseSolution;
import DynamicProgramming.KnapSackAlgorithm;
import DynamicProgramming.KnapSackAlgorithmResults;
import DynamicProgramming.KnapSackData;

import java.io.FileNotFoundException;

public final class AssessmentC3P4 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        runAssessmentOne();
        runAssessmentTwo();
    }

    private void runAssessmentOne() {
        KnapSackData data = new KnapSackData("knapsack1.txt");
        KnapSackAlgorithm algorithm = new KnapSackAlgorithm(data);
        KnapSackAlgorithmResults results = algorithm.run();
        System.out.println("Assessment One Optimal Solution: " + results.getOptimalValue());
    }

    private void runAssessmentTwo() {
        KnapSackData data = new KnapSackData("knapsack_big.txt");
        KnapSackAlgorithm algorithm = new KnapSackAlgorithm(data);
        KnapSackAlgorithmResults results = algorithm.run();
        System.out.println("Assessment Two Optimal Solution: " + results.getOptimalValue());
    }

    @Override
    public String getProblemDescription() {
        return "Dynamic programming: Knapsack Algorithms.";
    }

    @Override
    public short getCourseNumber() {
        return 3;
    }

    @Override
    public short getProblemNumber() {
        return 4;
    }

}
