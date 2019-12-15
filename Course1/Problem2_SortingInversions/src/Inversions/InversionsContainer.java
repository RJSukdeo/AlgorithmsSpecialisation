package Inversions;

 public final class InversionsContainer {
    private int numInversions;
    private int[] array;

    public InversionsContainer(int[] array, int numInversions) {
        this.array = array;
        this.numInversions = numInversions;
    }

    public int getNumInversions() {
        return numInversions;
    }

    public int[] getArray() {
        return array;
    }

}
