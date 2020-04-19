package GreedyAlgorithms;

import java.util.PriorityQueue;

public final class SchedulingAlgorithmResults {

    private final SchedulingAlgorithm algorithm;

    SchedulingAlgorithmResults(SchedulingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public DataItem[] getOrderdEntries() {
        PriorityQueue<DataItem> heap = algorithm.getOrderedEntries();
        DataItem[] orderedEntries = new DataItem[heap.size()];
        int counter = 0;
        while(heap.peek() != null) {
            orderedEntries[counter] = heap.poll();
            counter++;
        }
        return orderedEntries;
    }

}
