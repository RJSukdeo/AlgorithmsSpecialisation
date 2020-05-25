package Graph;

import java.util.Map;
import java.util.OptionalLong;

public final class JohnsonAlgorithmResults {

    private final JohnsonAlgorithm algorithm;

    JohnsonAlgorithmResults(JohnsonAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Map<Integer, Map<Integer, Long>> getNodeIdToResultMap() {
        return algorithm.getResultMap();
    }

    public OptionalLong getShortestShortestPath() {
        Map<Integer, Map<Integer, Long>> resultMap = algorithm.getResultMap();
        long minimumDistance = Long.MAX_VALUE;
        if (algorithm.isNegativeCycleDetected()) {
            return OptionalLong.empty();
        }
        for (Integer sourceId : resultMap.keySet()) {
            for (Integer nodeId : resultMap.get(sourceId).keySet()) {
                minimumDistance = Math.min(minimumDistance, resultMap.get(sourceId).get(nodeId));
            }
        }
        return OptionalLong.of(minimumDistance);
    }

}
