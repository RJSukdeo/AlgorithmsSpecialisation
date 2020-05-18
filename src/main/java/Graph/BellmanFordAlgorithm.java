package Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class BellmanFordAlgorithm {

    private final Set<Node> nodes;
    private final Map<Integer, Node> nodeIdToNodeMap;
    private long[][] matrix;

    public BellmanFordAlgorithm(DirectedGraphGenerator graphGenerator) {
        nodes = graphGenerator.getNodes(true);
        nodeIdToNodeMap = new HashMap<>(nodes.size());
        populateMaps();
    }

    public BellmanFordAlgorithmResults run(int startNodeId) {
        initialiseMatrix(startNodeId);
        for (int i = 1; i < nodes.size() + 1; i++) {
            boolean rowEqualToLast = true;
            for (int v = 0; v < nodes.size(); v++) {
                matrix[i][v] = Math.min(matrix[i - 1][v], getSmallestApplicableLength(v, i));
                if (rowEqualToLast && matrix[i][v] != matrix[i - 1][v]) {
                    rowEqualToLast = false;
                }
            }
            if (rowEqualToLast && i != nodes.size()) {
                // Early exit condition: no change from last row of matrix.
                populateFinalRows(i);
                break;
            }
        }
        return new BellmanFordAlgorithmResults(this);
    }

    boolean containsNegativeCycle() {
        int secondLastRow = nodes.size() - 1;
        for (int v = 0; v < nodes.size(); v++) {
            if (matrix[nodes.size()][v] != matrix[secondLastRow][v])
                return true;
        }
        return false;
    }

    long[][] getMatrix() {
        return matrix;
    }

    // On early exit, populate last two rows of matrix.
    private void populateFinalRows(int lastRowNumber) {
        for (int v = 0; v < nodes.size(); v++) {
            matrix[nodes.size()][v] = matrix[lastRowNumber][v];
            matrix[nodes.size() - 1][v] = matrix[lastRowNumber][v];
        }
    }

    private long getSmallestApplicableLength(int nodeId, int i) {
        Node node = nodeIdToNodeMap.get(nodeId);
        List<DirectedEdge> applicableEdges = node.getConnectedEdges().stream().map(e -> (DirectedEdge) e).filter(e -> e.getHead().equals(node)).collect(Collectors.toList());
        if (applicableEdges.size() == 0) {
            return 0;
        }
        long length = Integer.MAX_VALUE;
        for (DirectedEdge edge : applicableEdges) {
            length = Math.min(length, (long) edge.getLength() + matrix[i - 1][edge.getTail().getId()]);
        }
        return length;
    }

    private void populateMaps() {
        nodes.forEach(node -> nodeIdToNodeMap.put(node.getId(), node));
    }

    private void initialiseMatrix(int startNodeId) {
        matrix = new long[nodes.size() + 1][nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            matrix[0][i] = Integer.MAX_VALUE;
        }
        matrix[0][startNodeId] = 0;
    }

}
