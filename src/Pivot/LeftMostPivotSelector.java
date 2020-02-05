package Pivot;

import java.util.List;

public final class LeftMostPivotSelector implements IPivotSelector {

    @Override
    public int getPivotIndex(final List<Integer> collection, final int startIndex, final int endIndex) {
        return startIndex;
    }

}
