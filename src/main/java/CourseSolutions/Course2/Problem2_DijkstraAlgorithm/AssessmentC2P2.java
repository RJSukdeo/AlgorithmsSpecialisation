package CourseSolutions.Course2.Problem2_DijkstraAlgorithm;

import CourseSolutions.ICourseSolution;
import Graph.DijkstraAlgorithm;
import Graph.DijkstraAlgorithmResults;
import Graph.UndirectedGraphGenerator;
import Graph.UndirectedGraphInputs;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

// Expected output
// Output: 2599,2610,2947,2052,2367,2399,2029,2442,2505,3068

public final class AssessmentC2P2 implements ICourseSolution {

    @Override
    public void run() throws FileNotFoundException {
        UndirectedGraphInputs graphInputs = getGraphInfo();
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(UndirectedGraphGenerator.getGenerator(graphInputs));
        DijkstraAlgorithmResults results = algorithm.run(1);
        int[] nodesToDisplay = new int[]{7, 37, 59, 82, 99, 115, 133, 165, 188, 197};
        StringBuilder sb = new StringBuilder();
        for (final int nodeToDisplay : nodesToDisplay) {
            sb.append((int) results.getDistanceToNode(nodeToDisplay)).append(",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        System.out.println("Output: " + sb.toString());
    }

    private static UndirectedGraphInputs getGraphInfo() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("dijkstraData.txt");
        Scanner scanner = new Scanner(inputStream);
        UndirectedGraphInputs.InputBuilder builder = new UndirectedGraphInputs.InputBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] stringNumbers = line.split("\t");
            int originationId = Integer.parseInt(stringNumbers[0]);
            for (int i = 1; i < stringNumbers.length; i++) {
                String[] splitString = stringNumbers[i].split(",");
                builder.addEntry(originationId, Integer.parseInt(splitString[0]), Double.parseDouble(splitString[1]));
            }
        }
        return builder.build();
    }

    @Override
    public String getProblemDescription() {
        return "Implementation of Dijkstra's Shortest Path algorithm.";
    }

    @Override
    public short getCourseNumber() {
        return 2;
    }

    @Override
    public short getProblemNumber() {
        return 2;
    }

}
