package DynamicProgramming;

public class KnapSackAlgorithmResults {

    private final KnapSackAlgorithm algorithm;

    KnapSackAlgorithmResults(KnapSackAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public long getOptimalValue() {
        return algorithm.getOptimalValue();
    }
}
