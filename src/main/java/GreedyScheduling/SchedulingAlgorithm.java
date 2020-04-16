package GreedyScheduling;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public final class SchedulingAlgorithm {

    private final List<DataItem> entries;
    private PriorityQueue<DataItem> orderedEntries;

    public SchedulingAlgorithm(final List<DataItem> entries) {
        this.entries = entries;
    }

    public SchedulingAlgorithmResults run(final Comparator<DataItem> comparator) {
        orderedEntries = new PriorityQueue<>(entries.size(), comparator);
        orderedEntries.addAll(entries);
        return new SchedulingAlgorithmResults(this);
    }

    PriorityQueue<DataItem> getOrderedEntries() {
        return orderedEntries;
    }

}
