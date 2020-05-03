package DynamicProgramming;

import java.util.List;

public class KnapSackAlgorithm {

    private long optimalValue;
    private final int maxWeight;
    private final List<KnapSackEntry> entries;

    public KnapSackAlgorithm(KnapSackData inputData) {
        maxWeight = inputData.getMaxWeight();
        entries = inputData.getElements();
        optimalValue = 0;
    }

    public KnapSackAlgorithmResults run() {
        long[][] solution = new long[2][maxWeight + 1];
        for (int i = 0; i < entries.size(); i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (j - entries.get(i).getWeight() < 0) {
                    solution[1][j] = solution[0][j];
                } else {
                    solution[1][j] = Math.max(solution[0][j], solution[0][j - entries.get(i).getWeight()] + entries.get(i).getValue());
                }
            }
            for (int j = 0; j <= maxWeight; j++) {
                solution[0][j] = solution[1][j];
            }
        }
        optimalValue = solution[1][maxWeight];
        return new KnapSackAlgorithmResults(this);
    }

    long getOptimalValue() {
        return optimalValue;
    }

}
