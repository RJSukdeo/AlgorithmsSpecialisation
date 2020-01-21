package Graph;

public final class ContractionResult {

    private final int numCrossingEdges;

    public ContractionResult(final int crossingEdges) {
        this.numCrossingEdges = crossingEdges;
    }

    public int getCrossingEdges() {
        return numCrossingEdges;
    }

}
