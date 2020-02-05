import Graph.DirectedGraphGenerator;
import Graph.DirectedGraphInputs;
import Graph.StrongConnectedComponentAlgorithm;
import Graph.StrongConnectedComponentResults;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static Graph.DirectedGraphInputs.InputBuilder;

public class AssessmentC2P1 {

    // Worked when running with VM Options : -Xms4096m -Xmx4096m -Xss1024m
    // Expected output
    // SCC Sizes: 434821 968 459 313 211
    public static void main(String[] args) throws FileNotFoundException {
        DirectedGraphInputs inputs = getGraphInfo();
        DirectedGraphGenerator graphGenerator = DirectedGraphGenerator.getGeneratorDirected(inputs);
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        StrongConnectedComponentResults results = algorithm.run();
        List<Integer> sccSizes = results.getSccSizes();
        Collections.sort(sccSizes);
        StringBuilder sb = new StringBuilder();
        sb.append("SCC Sizes:");
        sb.append(" ").append(sccSizes.get(sccSizes.size() - 1));
        sb.append(" ").append(sccSizes.get(sccSizes.size() - 2));
        sb.append(" ").append(sccSizes.get(sccSizes.size() - 3));
        sb.append(" ").append(sccSizes.get(sccSizes.size() - 4));
        sb.append(" ").append(sccSizes.get(sccSizes.size() - 5));
        System.out.println(sb.toString());
    }

    private static DirectedGraphInputs getGraphInfo() throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/resources/SCC.txt");
        Scanner scanner = new Scanner(file);
        InputBuilder builder = new InputBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> stringNumbers = Arrays.asList(line.split(" "));
            builder.addEntry(Integer.valueOf(stringNumbers.get(0)), Integer.valueOf(stringNumbers.get(1)));
        }
        return builder.build();
    }

}
