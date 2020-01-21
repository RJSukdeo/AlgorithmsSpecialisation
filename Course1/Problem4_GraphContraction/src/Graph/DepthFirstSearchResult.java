package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class DepthFirstSearchResult {

    private List<Integer> nodeIds;

    DepthFirstSearchResult(final DepthFirstSearchAlgorithm algorithm) {
        Map<Node, Boolean> nodesVisitedMap = algorithm.getNodeVisited();
        List<Node> nodesVisited = nodesVisitedMap.keySet().stream().filter(node -> algorithm.getNodeVisited().get(node)).collect(Collectors.toList());
        Map<Node, Integer> orderNodesVisitedMap = algorithm.getOrderVisited();
        Integer[] tempArr = new Integer[nodesVisited.size()];
        for (Node node : nodesVisited) {
            tempArr[orderNodesVisitedMap.get(node)] = node.getId();
        }
        nodeIds = new ArrayList<>(Arrays.asList(tempArr));
    }

    public List<Integer> getVisitedNodes() {
        return nodeIds;
    }

}
