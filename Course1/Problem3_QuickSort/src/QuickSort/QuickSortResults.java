package QuickSort;

import java.util.List;

public final class QuickSortResults {

    private final long numberOfComparisons;
    private final List<Integer> collection;

    public QuickSortResults(List<Integer> collection, long numberOfComparisons){
        this.numberOfComparisons = numberOfComparisons;
        this.collection = collection;
    }

    public long getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public List<Integer> getList() {
        return collection;
    }
}
