package Inversions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class InversionsCounterTest {

    @Test
    public void testBasicSorting() {
        InversionsCounter inversionsCounter = new InversionsCounter(getElements1());
        List<Integer> sortedElements = inversionsCounter.getSortedElements();
        assertEquals((Integer) 0, sortedElements.get(0));
        assertEquals((Integer) 1, sortedElements.get(1));
        assertEquals((Integer) 2, sortedElements.get(2));
        assertEquals((Integer) 3, sortedElements.get(3));
        assertEquals((Integer) 4, sortedElements.get(4));
        assertEquals((Integer) 5, sortedElements.get(5));
        assertEquals((Integer) 6, sortedElements.get(6));
        assertEquals((Integer) 7, sortedElements.get(7));
        assertEquals((Integer) 8, sortedElements.get(8));
        assertEquals((Integer) 9, sortedElements.get(9));
        assertEquals((Integer) 10, sortedElements.get(10));
    }

    @Test
    public void testInversionCount() {
        InversionsCounter inversionsCounter = new InversionsCounter(getElements1());
        assertEquals(23, inversionsCounter.getNumberOfInversions());
    }

    private List<Integer> getElements1() {
        List<Integer> elements = new ArrayList<>();
        elements.add(10);
        elements.add(0);
        elements.add(2);
        elements.add(9);
        elements.add(3);
        elements.add(5);
        elements.add(1);
        elements.add(7);
        elements.add(4);
        elements.add(6);
        elements.add(8);
        return elements;
    }


}
