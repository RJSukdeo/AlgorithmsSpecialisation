package Graph;

public final class ContractionAlgorithmResults {

    private final int numCrossingEdges;

    public ContractionAlgorithmResults(final int crossingEdges) {
        this.numCrossingEdges = crossingEdges;
    }

    public int getCrossingEdges() {
        return numCrossingEdges;
    }

}
