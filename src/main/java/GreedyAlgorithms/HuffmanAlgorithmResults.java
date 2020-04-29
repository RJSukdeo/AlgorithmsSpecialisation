package GreedyAlgorithms;

import java.util.Map;
import java.util.PriorityQueue;

public final class HuffmanAlgorithmResults {

    private final HuffmanAlgorithm algorithm;

    HuffmanAlgorithmResults(HuffmanAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public long getMaximumBitSize() {
        PriorityQueue<Integer> heap = new PriorityQueue<>(algorithm.getNodeIdToBinaryEncoding().size(), (t0, t1) -> {
            return t1 - t0;
        });
        for (Long nodeId : algorithm.getNodeIdToBinaryEncoding().keySet()) {
            heap.add(algorithm.getNodeIdToBinaryEncoding().get(nodeId).length());
        }
        return heap.poll();
    }

    public long getMinimumBitSize() {
        PriorityQueue<Integer> heap = new PriorityQueue<>(algorithm.getNodeIdToBinaryEncoding().size(), (t0, t1) -> {
            return t0 - t1;
        });
        for (Long nodeId : algorithm.getNodeIdToBinaryEncoding().keySet()) {
            heap.add(algorithm.getNodeIdToBinaryEncoding().get(nodeId).length());
        }
        return heap.poll();
    }

    public Map<Long, String> getNodeIdToBinaryEncoding() {
        return algorithm.getNodeIdToBinaryEncoding();
    }

}
