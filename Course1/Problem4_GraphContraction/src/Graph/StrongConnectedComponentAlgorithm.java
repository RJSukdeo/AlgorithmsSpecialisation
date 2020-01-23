package Graph;

// Implementation of the Kosaraju's Two Pass Algorithm

import java.util.*;
import java.util.stream.Collectors;

public final class StrongConnectedComponentAlgorithm {

    private final DirectedGraphGenerator graphGenerator;
    private Map<Integer, Integer> sccLeaderToGraphSize;
    private Set<Node> nodes;

    private StrongConnectedComponentAlgorithm(DirectedGraphGenerator graphGenerator) {
        this.graphGenerator = graphGenerator;
        this.nodes = graphGenerator.getNodes(true);
        this.sccLeaderToGraphSize = new HashMap<>();
    }

    public static StrongConnectedComponentAlgorithm getInstance(DirectedGraphGenerator graphGenerator) {
        return new StrongConnectedComponentAlgorithm(graphGenerator);
    }

    public StrongConnectedComponentResults run() {
        List<Integer> descendingNodeIds = nodes.stream().map(node -> node.getId()).sorted((Comparator.reverseOrder())).collect(Collectors.toList());
        DepthFirstSearchAlgorithm dfsAlgo = new DepthFirstSearchAlgorithm(graphGenerator);
        List<Integer> resultantOrderNodeIds = dfsAlgo.run(descendingNodeIds).getOrderedNodeIds();
        Collections.reverse(resultantOrderNodeIds);
        graphGenerator.swapDirectionsAllEdges();
        nodes = graphGenerator.getNodes(true);
        dfsAlgo = new DepthFirstSearchAlgorithm(graphGenerator);
        sccLeaderToGraphSize = dfsAlgo.run(resultantOrderNodeIds).getLeaderToGraphSize();
        return new StrongConnectedComponentResults(this);
    }

    Map<Integer, Integer> getSccLeaderToGraphSize() {
        return sccLeaderToGraphSize;
    }
}
