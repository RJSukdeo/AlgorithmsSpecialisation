package Pivot;

import java.util.List;

public interface IPivotSelector {
    int getPivotIndex(List<Integer> collection, int startIndex, int endIndex);
}
