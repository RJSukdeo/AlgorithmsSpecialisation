package Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class DepthFirstSearchResult {

    private DepthFirstSearchAlgorithm algorithm;

    DepthFirstSearchResult(final DepthFirstSearchAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<Integer> getOrderedNodeIds() {
        return algorithm.getNodesOrdered().stream().map(node -> node.getId()).collect(Collectors.toList());
    }

    public Map<Integer, Integer> getLeaderToGraphSize() {
        Map<Integer, Integer> leaderToGraphSize = new HashMap<>(algorithm.getLeaderToNodesVisited().size());
        for (Integer leaderNodeId : algorithm.getLeaderToNodesVisited().keySet()) {
            leaderToGraphSize.put(leaderNodeId, algorithm.getLeaderToNodesVisited().get(leaderNodeId).size());
        }
        return leaderToGraphSize;
    }

    public Map<Integer, List<Integer>> getLeaderToNodesVisited() {
        return algorithm.getLeaderToNodesVisited();
    }

}
