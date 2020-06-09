package Graph;

public class TwoSATAlgorithmResults {

    private final TwoSATAlgorithm algorithm;

    public TwoSATAlgorithmResults(TwoSATAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public boolean isSatisfiable() {
        return algorithm.isSatisfiable();
    }

}
