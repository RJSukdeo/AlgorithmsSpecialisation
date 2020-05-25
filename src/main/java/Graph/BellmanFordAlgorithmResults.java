package Graph;

import java.util.HashMap;
import java.util.Map;

public final class BellmanFordAlgorithmResults {

    private final BellmanFordAlgorithm algorithm;

    BellmanFordAlgorithmResults(BellmanFordAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Map<Integer, Long> getShortestDistances() {
        if (!algorithm.containsNegativeCycle()) {
            long[][] matrix = algorithm.getMatrix();
            Map<Integer, Integer> indexToNodeId = algorithm.getIndexToNodeId();
            Map<Integer, Long> nodeIdToDistance = new HashMap<>(matrix[1].length);
            for (int v = 0; v < matrix[1].length; v++) {
                nodeIdToDistance.put(indexToNodeId.get(v), matrix[matrix[1].length][v]);
            }
            return nodeIdToDistance;
        }
        System.out.println("Negative cycle present, outputting empty map!!!");
        return new HashMap<>();
    }

}
