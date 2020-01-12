package Pivot;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class MedianPivotSelector implements IPivotSelector {

    @Override
    public int getPivotIndex(List<Integer> collection, int startIndex, int endIndex) {
        int numberOfElements = endIndex - startIndex + 1;
        if (numberOfElements <= 2) {
            return getIndexSpecialCase(collection, startIndex, endIndex, numberOfElements);
        }
        int[] indices = new int[]{startIndex, (endIndex - startIndex) / 2 + startIndex, endIndex};
        int[] elements = new int[]{collection.get(indices[0]), collection.get(indices[1]), collection.get(indices[2])};
        return getMedianIndex(indices, elements);
    }

    private int getIndexSpecialCase(List<Integer> collection, int startIndex, int endIndex, int numberOfElements) {
        if (numberOfElements == 1) {
            return startIndex;
        }
        return collection.get(endIndex) < collection.get(startIndex) ? endIndex : startIndex;
    }

    private int getMedianIndex(int[] indices, int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[i]) {
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                    temp = indices[i];
                    indices[i]  = indices[j];
                    indices[j] = temp;
                }
            }
        }
        return indices[1];
    }

}
