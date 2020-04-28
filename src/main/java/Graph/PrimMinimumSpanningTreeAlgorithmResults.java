package Graph;

import java.util.List;

public final class PrimMinimumSpanningTreeAlgorithmResults {

    private final PrimMinimumSpanningTreeAlgorithm algorithm;

    PrimMinimumSpanningTreeAlgorithmResults(final PrimMinimumSpanningTreeAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public long getTreeLength() {
        return algorithm.getTotalTreeLength();
    }

    public List<Node> getOrderedVisitedNodes() {
        return algorithm.getOrderedVisitedNodes();
    }

}
