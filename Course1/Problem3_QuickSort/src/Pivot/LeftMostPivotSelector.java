package Pivot;

import java.util.List;

public class LeftMostPivotSelector implements IPivotSelector {

    @Override
    public int getPivotIndex(List<Integer> collection, int startIndex, int endIndex) {
        return startIndex;
    }

}
