package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public final class HuffmanAlgorithmInput {

    private final List<LeafNode> leafNodes;

    public HuffmanAlgorithmInput(int capacity) {
        leafNodes = new ArrayList<>(capacity);
    }

    public void addEntry(long id, long weight) {
        leafNodes.add(new LeafNode(weight, id));
    }

    List<LeafNode> getLeafNodes() {
        return leafNodes;
    }

}
