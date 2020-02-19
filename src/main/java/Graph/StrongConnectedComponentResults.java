package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StrongConnectedComponentResults {

    private final StrongConnectedComponentAlgorithm algorithm;

    StrongConnectedComponentResults(StrongConnectedComponentAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<Integer> getSccSizes() {
        List<Integer> sccSizes = new ArrayList<>(algorithm.getSccLeaderToGraphSize().values());
        Collections.sort(sccSizes);
        return sccSizes;
    }
}
