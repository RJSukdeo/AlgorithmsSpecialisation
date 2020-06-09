package Graph;

import java.util.List;

public class TwoSATAlgorithm {

    private final DirectedGraphGenerator graphGenerator;
    private boolean isSatisfiable;

    // Requires two integers separated by a space eg: "20 -30" would represent node 20 and the complement of node 30.
    public TwoSATAlgorithm(String[] conditions) {
        this.graphGenerator = DirectedGraphGenerator.getGenerator(getGraphInputs(conditions));
    }

    public TwoSATAlgorithmResults run() {
        StrongConnectedComponentAlgorithm algorithm = StrongConnectedComponentAlgorithm.getInstance(graphGenerator);
        isSatisfiable = problemSatisfiable(algorithm.run());
        return new TwoSATAlgorithmResults(this);
    }

    boolean isSatisfiable() {
        return isSatisfiable;
    }

    private boolean problemSatisfiable(StrongConnectedComponentResults results) {
        List<List<Integer>> allComponents = results.getSCCs();
        for (List<Integer> component : allComponents) {
            for (Integer node : component) {
                if (component.contains(-node)) {
                    return false;
                }
            }
        }
        return true;
    }


    // Create implication graph.
    private DirectedGraphInputs getGraphInputs(String[] rawData) {
        DirectedGraphInputs.InputBuilder builder = new DirectedGraphInputs.InputBuilder();
        for (String entry : rawData) {
            String[] splitResults = entry.split(" ");
            int tailNodeId = Integer.parseInt(splitResults[0]);
            int headNodeId = Integer.parseInt(splitResults[1]);
            builder.addEntry(-tailNodeId, headNodeId);
            builder.addEntry(-headNodeId, tailNodeId);
        }
        return builder.build();
    }

}
