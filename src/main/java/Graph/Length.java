package Graph;

public final class Length implements IEdgeLength {

    private final double edgeLength;

    public Length(final double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public double getLength() {
        return edgeLength;
    }

}
