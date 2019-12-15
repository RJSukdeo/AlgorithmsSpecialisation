package Inversions;

import java.util.List;

public final class InversionsContainer {

    private final long numInversions;
    private final List<Integer> elements;

    public InversionsContainer(final List<Integer> elements, final long numInversions) {
        this.elements = elements;
        this.numInversions = numInversions;
    }

    public long getNumInversions() {
        return numInversions;
    }

    public List<Integer> getElements() {
        return elements;
    }

}
