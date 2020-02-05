package QuickSort;

import Pivot.IPivotSelector;

import java.util.Collections;
import java.util.List;

public final class QuickSort {

    private final IPivotSelector pivotSelector;
    private final QuickSortResults results;

    public QuickSort(final List<Integer> elements, final IPivotSelector pivotSelector) {
        this.pivotSelector = pivotSelector;
        this.results = sort(elements, 0, elements.size() - 1);
    }

    private QuickSortResults sort(final List<Integer> elements, final int startIndex, final int endIndex) {
        int augStartIndex = Math.max(startIndex, 0);
        if (endIndex - augStartIndex <= 0) {
            return new QuickSortResults(elements, 0);
        }
        int updatedPivotIndex = partitionElements(elements, pivotSelector.getPivotIndex(elements, augStartIndex, endIndex), augStartIndex, endIndex);
        QuickSortResults leftSortedElements = sort(elements, augStartIndex, updatedPivotIndex - 1);
        QuickSortResults rightSortedElements = sort(elements, updatedPivotIndex + 1, endIndex);
        return new QuickSortResults(elements, endIndex - augStartIndex + leftSortedElements.getNumberOfComparisons() + rightSortedElements.getNumberOfComparisons());
    }

    private int partitionElements(final List<Integer> elements, final int pivotIndex, final int startIndex, final int endIndex) {
        int pivotValue = elements.get(pivotIndex);
        Collections.swap(elements, startIndex, pivotIndex);
        int i = startIndex + 1;
        for (int j = i; j < endIndex + 1; j++) {
            if (elements.get(j) < pivotValue) {
                Collections.swap(elements, j, i);
                i++;
            }
        }
        Collections.swap(elements, startIndex, i - 1);
        return i - 1;
    }

    public final long getNumberOfComparisons() {
        return results.getNumberOfComparisons();
    }

    public List<Integer> getSortedList() {
        return results.getList();
    }

}
