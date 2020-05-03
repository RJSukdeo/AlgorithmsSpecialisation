package CourseSolutions;

import CourseSolutions.Course1.Problem1_IntegerMultiplication.AssessmentC1P1;
import CourseSolutions.Course1.Problem2_SortingInversions.AssessmentC1P2;
import CourseSolutions.Course1.Problem3_QuickSort.AssessmentC1P3;
import CourseSolutions.Course1.Problem4_GraphContraction.AssessmentC1P4;
import CourseSolutions.Course2.Problem1_StronglyConnectedComponents.AssessmentC2P1;
import CourseSolutions.Course2.Problem2_DijkstraAlgorithm.AssessmentC2P2;
import CourseSolutions.Course2.Problem3_MedianMaintenance.AssessmentC2P3;
import CourseSolutions.Course2.Problem4_TwoSumAlgorithm.AssessmentC2P4;
import CourseSolutions.Course3.Problem1_GreedyAlgorithms.AssessmentC3P1;
import CourseSolutions.Course3.Problem2_ClusteringAlgorithms.AssessmentC3P2;
import CourseSolutions.Course3.Problem3_CompressionDynamicAlgorithms.AssessmentC3P3;
import CourseSolutions.Course3.Problem4_KnapSackAlgorithms.AssessmentC3P4;

import java.io.FileNotFoundException;
import java.util.*;

public final class SolutionManager {

    private static final List<ICourseSolution> solutions;
    private static final String SPACING = "     ";

    static {
        solutions = new ArrayList<>();
        populateSolutionImplementations();
    }

    public static void main(String[] args) throws FileNotFoundException {
        generateInputPage();
        runManager();
    }

    private static void runManager() throws FileNotFoundException {
        int courseInput = handleInput(CourseOrProblem.COURSE);
        int problemInput = handleInput(CourseOrProblem.PROBLEM);
        System.out.println();
        Optional<ICourseSolution> solution = solutions.stream().filter(s -> courseInput == s.getCourseNumber() && problemInput == s.getProblemNumber()).findFirst();
        if (solution.isPresent()) {
            solution.get().run();
        } else {
            System.out.println("Requested solution does not exist!!!");
            System.out.println();
            runManager();
        }
    }

    private static void generateInputPage() {
        System.out.println("Stanford Algorithm Specialisation Solutions - Author: Ryan Jude Sukdeo");
        System.out.println("Course" + SPACING + "Problem" + SPACING + "Problem Description");
        for (ICourseSolution solution : solutions) {
            StringBuilder sb = new StringBuilder();
            sb.append(solution.getCourseNumber()).append(SPACING).append(SPACING).append(solution.getProblemNumber()).append(SPACING).append(SPACING).append(" ").append(solution.getProblemDescription());
            System.out.println(sb.toString());
        }
        System.out.println();
    }

    private static int handleInput(final CourseOrProblem courseOrProblem) {
        while (true) {
            if (courseOrProblem.equals(CourseOrProblem.COURSE)) {
                System.out.print("Please select a course number: ");
            } else {
                System.out.print("Please select a problem number: ");
            }
            int input = handleIntInput();
            if (checkValidityOfInput(input, courseOrProblem)) {
                return input;
            }
        }
    }

    private static boolean checkValidityOfInput(final Integer input, final CourseOrProblem courseOrProblem) {
        if (courseOrProblem.equals(CourseOrProblem.COURSE)) {
            return handleCourseNumInput(input);
        }
        return handleProblemNumInput(input);
    }

    private static boolean handleCourseNumInput(Integer input) {
        boolean valid = true;
        PriorityQueue<Short> courseNumHeap = new PriorityQueue<>(solutions.size(), new tempComparator());
        solutions.forEach(s -> courseNumHeap.add(s.getCourseNumber()));
        short maxCourse = courseNumHeap.poll();
        if (input > maxCourse) {
            System.out.println("Max course number is " + maxCourse + ". Your input is invalid, since it is greater!!!");
            valid = false;
        }
        if (input < 0 && valid) {
            System.out.println("Course number is negative, your input is invalid!!!");
            valid = false;
        }
        return valid;
    }

    private static boolean handleProblemNumInput(Integer input) {
        boolean valid = true;
        PriorityQueue<Short> problemNumHeap = new PriorityQueue<>(solutions.size(), new tempComparator());
        solutions.forEach(s -> problemNumHeap.add(s.getProblemNumber()));
        short maxProblem = problemNumHeap.poll();
        if (input > maxProblem) {
            System.out.println("Max problem number is " + maxProblem + ". Your input is invalid, since it is greater!!!");
            valid = false;
        }
        if (input < 0 && valid) {
            System.out.println("Problem number is negative, your input is invalid!!!");
            valid = false;
        }
        return valid;
    }

    private static int handleIntInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // TODO Use dependency inversion to make this neater.
    private static void populateSolutionImplementations() {
        solutions.add(new AssessmentC1P1());
        solutions.add(new AssessmentC1P2());
        solutions.add(new AssessmentC1P3());
        solutions.add(new AssessmentC1P4());
        solutions.add(new AssessmentC2P1());
        solutions.add(new AssessmentC2P2());
        solutions.add(new AssessmentC2P3());
        solutions.add(new AssessmentC2P4());
        solutions.add(new AssessmentC3P1());
        solutions.add(new AssessmentC3P2());
        solutions.add(new AssessmentC3P3());
        solutions.add(new AssessmentC3P4());
    }

    private static class tempComparator implements Comparator<Short> {
        @Override
        public int compare(Short s1, Short s2) {
            return s2 - s1;
        }
    }

    private enum CourseOrProblem {
        COURSE,
        PROBLEM
    }

}
