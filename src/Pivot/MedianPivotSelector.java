package Pivot;

import java.util.List;

public final class MedianPivotSelector implements IPivotSelector {

    @Override
    public int getPivotIndex(final List<Integer> collection, final int startIndex, final int endIndex) {
        int numberOfElements = endIndex - startIndex + 1;
        if (numberOfElements <= 2) {
            return getIndexSpecialCase(collection, startIndex, endIndex, numberOfElements);
        }
        int[] indices = new int[]{startIndex, (endIndex - startIndex) / 2 + startIndex, endIndex};
        int[] elements = new int[]{collection.get(indices[0]), collection.get(indices[1]), collection.get(indices[2])};
        return getMedianIndex(indices, elements);
    }

    private int getIndexSpecialCase(final List<Integer> collection, final int startIndex, final int endIndex, final int numberOfElements) {
        if (numberOfElements == 1) {
            return startIndex;
        }
        return collection.get(endIndex) < collection.get(startIndex) ? endIndex : startIndex;
    }

    private int getMedianIndex(final int[] indices, final int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[i]) {
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                    temp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = temp;
                }
            }
        }
        return indices[1];
    }

}
