package Pivot;

import java.util.List;

public interface IPivotSelector {
    int getPivotIndex(final List<Integer> collection, final int startIndex, final int endIndex);
}
