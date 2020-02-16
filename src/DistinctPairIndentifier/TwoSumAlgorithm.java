package DistinctPairIndentifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TwoSumAlgorithm {

    private final Map<Long, Long> elements;
    private int numDistinctPairs;


    private TwoSumAlgorithm(final Map<Long, Long> elements) {
        this.elements = elements;
    }

    public static TwoSumAlgorithm getInstance(final List<Long> elements) {
        Map<Long, Long> elementsMap = new HashMap<>(elements.size());
        elements.forEach(e -> elementsMap.put(e, e));
        return new TwoSumAlgorithm(elementsMap);
    }

    public TwoSumAlgorithmResults run(final int targetSum) {
        numDistinctPairs = 0;
        for (Long key : elements.keySet()) {
            if (elements.containsKey(targetSum - key) && !(key.equals(targetSum - key))) {
                numDistinctPairs++;
            }
        }
        numDistinctPairs = numDistinctPairs / 2;
        return new TwoSumAlgorithmResults(this);
    }

    int getNumDistinctPairs() {
        return numDistinctPairs;
    }

}
