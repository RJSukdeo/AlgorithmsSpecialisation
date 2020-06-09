package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    public List<List<Integer>> getSCCs() {
        Map<Integer, List<Integer>> leaderToNodesVisited = algorithm.getLeaderToNodesVisited();
        List<List<Integer>> components = new ArrayList<>(leaderToNodesVisited.keySet().size());
        leaderToNodesVisited.keySet().forEach(id -> components.add(leaderToNodesVisited.get(id)));
        return components;
    }
}
