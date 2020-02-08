import Graph.DijkstraAlgorithm;
import Graph.DijkstraAlgorithmResults;
import Graph.UndirectedGraphGenerator;
import Graph.UndirectedGraphInputs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssessmentC2P2 {

    public static void main(String[] args) throws FileNotFoundException {
        UndirectedGraphInputs graphInputs = getGraphInfo();
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(UndirectedGraphGenerator.getGenerator(graphInputs));
        DijkstraAlgorithmResults results = algorithm.run(1);
        int[] nodesToDisplay = new int[]{7,37,59,82,99,115,133,165,188,197};
        StringBuilder sb = new StringBuilder();
        for (final int nodeToDisplay : nodesToDisplay) {
            sb.append((int) results.getDistanceToNode(nodeToDisplay)).append(",");
        }
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        System.out.println("Output: " + sb.toString());
    }

    private static UndirectedGraphInputs getGraphInfo() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/resources/dijkstraData.txt");
        Scanner scanner = new Scanner(file);
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

}
