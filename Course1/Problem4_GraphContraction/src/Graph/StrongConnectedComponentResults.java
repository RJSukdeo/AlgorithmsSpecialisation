package Graph;

import java.util.ArrayList;
import java.util.List;

final class StrongConnectedComponentResults {

    private final StrongConnectedComponentAlgorithm algorithm;

    StrongConnectedComponentResults(StrongConnectedComponentAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<Integer> getSccSizes() {
        return new ArrayList<>(algorithm.getSccLeaderToGraphSize().values());
    }
}
