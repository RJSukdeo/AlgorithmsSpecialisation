package Graph;

// Implementation of the Kosaraju's Two Pass Algorithm

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StrongConnectedComponentAlgorithm {

    private final DirectedGraphGenerator graphGenerator;
    private final List<Integer> sccSizes;
    private Set<Node> nodes;

    private StrongConnectedComponentAlgorithm(DirectedGraphGenerator graphGenerator) {
        this.graphGenerator = graphGenerator;
        this.nodes = graphGenerator.getNodes(true);
        this.sccSizes = new ArrayList<>();
    }

    public static StrongConnectedComponentAlgorithm getInstance(DirectedGraphGenerator graphGenerator) {
        return new StrongConnectedComponentAlgorithm(graphGenerator);
    }

    public StrongConnectedComponentResults run() {
        List<Integer> descendingNodeIds = nodes.stream().map(node -> node.getId()).sorted((node1, node2) -> node1 > node2 ? node1 : node2).collect(Collectors.toList());
        DepthFirstSearchAlgorithm dfsAlgo = new DepthFirstSearchAlgorithm(graphGenerator);
        List<Integer> resultantOrderNodeIds = dfsAlgo.run(descendingNodeIds).getNodeIdsVisited();
        graphGenerator.swapDirectionsAllEdges();
        nodes = graphGenerator.getNodes(true);
        dfsAlgo = new DepthFirstSearchAlgorithm(graphGenerator);

        return new StrongConnectedComponentResults(this);
    }

}
