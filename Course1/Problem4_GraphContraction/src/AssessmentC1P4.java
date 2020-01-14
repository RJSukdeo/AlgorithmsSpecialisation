import Graph.ContractionAlgorithmResults;
import Graph.GraphManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AssessmentC1P4 {

    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, List<Integer>> graphInfo = getGraphInfo();
        int numberOfNodes = graphInfo.keySet().size();
        int smallestCrossingEdges = numberOfNodes;
        for (int i = 0; i < Math.pow(numberOfNodes, 2); i++) {
            GraphManager graphManager = new GraphManager(graphInfo);
            ContractionAlgorithmResults results = graphManager.runContractionAlgorithm();
            if (results.getCrossingEdges() < smallestCrossingEdges) {
                smallestCrossingEdges = results.getCrossingEdges();
            }
        }
        System.out.println("Minimum number of crossing edges: " + smallestCrossingEdges);
    }

    private static Map<Integer, List<Integer>> getGraphInfo() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/Course1/Problem4_GraphContraction/resources/Graph.txt");
        Scanner scanner = new Scanner(file);
        Map<Integer, List<Integer>> graphInfo = new HashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] stringNumbers = line.split("\t");
            List<Integer> connectingNodes = new ArrayList<>(stringNumbers.length - 1);
            for (int i = 1; i < stringNumbers.length; i++) {
                connectingNodes.add(Integer.valueOf(stringNumbers[i]));
            }
            graphInfo.put(Integer.valueOf(stringNumbers[0]), connectingNodes);
        }
        return graphInfo;
    }

}
