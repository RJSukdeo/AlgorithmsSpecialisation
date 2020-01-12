package QuickSort;

import Pivot.IPivotSelector;
import Pivot.LeftMostPivotSelector;
import Pivot.MedianPivotSelector;
import Pivot.RightMostPivotSelector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    @Test
    public void testQuickSortSorting() {
        IPivotSelector pivotSelector = new LeftMostPivotSelector();
        QuickSort sort = new QuickSort(getElements(), pivotSelector);
        List<Integer> sortedElements = sort.getSortedList();
        assertEquals(0, (int) sortedElements.get(0));
        assertEquals(1, (int) sortedElements.get(1));
        assertEquals(2, (int) sortedElements.get(2));
        assertEquals(3, (int) sortedElements.get(3));
        assertEquals(4, (int) sortedElements.get(4));
        assertEquals(5, (int) sortedElements.get(5));
        assertEquals(6, (int) sortedElements.get(6));
        assertEquals(7, (int) sortedElements.get(7));
        assertEquals(8, (int) sortedElements.get(8));
        assertEquals(9, (int) sortedElements.get(9));
        assertEquals(10, (int) sortedElements.get(10));

        pivotSelector = new RightMostPivotSelector();
        sort = new QuickSort(getElements(), pivotSelector);
        sortedElements = sort.getSortedList();
        assertEquals(0, (int) sortedElements.get(0));
        assertEquals(1, (int) sortedElements.get(1));
        assertEquals(2, (int) sortedElements.get(2));
        assertEquals(3, (int) sortedElements.get(3));
        assertEquals(4, (int) sortedElements.get(4));
        assertEquals(5, (int) sortedElements.get(5));
        assertEquals(6, (int) sortedElements.get(6));
        assertEquals(7, (int) sortedElements.get(7));
        assertEquals(8, (int) sortedElements.get(8));
        assertEquals(9, (int) sortedElements.get(9));
        assertEquals(10, (int) sortedElements.get(10));

        pivotSelector = new MedianPivotSelector();
        sort = new QuickSort(getElements(), pivotSelector);
        sortedElements = sort.getSortedList();
        assertEquals(0, (int) sortedElements.get(0));
        assertEquals(1, (int) sortedElements.get(1));
        assertEquals(2, (int) sortedElements.get(2));
        assertEquals(3, (int) sortedElements.get(3));
        assertEquals(4, (int) sortedElements.get(4));
        assertEquals(5, (int) sortedElements.get(5));
        assertEquals(6, (int) sortedElements.get(6));
        assertEquals(7, (int) sortedElements.get(7));
        assertEquals(8, (int) sortedElements.get(8));
        assertEquals(9, (int) sortedElements.get(9));
        assertEquals(10, (int) sortedElements.get(10));
    }


    private List<Integer> getElements() {
        List<Integer> elements = new ArrayList<>();
        elements.add(7);
        elements.add(1);
        elements.add(10);
        elements.add(4);
        elements.add(3);
        elements.add(6);
        elements.add(8);
        elements.add(9);
        elements.add(2);
        elements.add(0);
        elements.add(5);
        return elements;
    }
}
