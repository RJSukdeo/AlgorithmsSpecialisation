package Pivot;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class PivotSelectorTest {

    private List<Integer> getEvenNumberOfElements() {
        List<Integer> elements = new ArrayList<>(6);
        elements.add(1);
        elements.add(3);
        elements.add(5);
        elements.add(2);
        elements.add(9);
        elements.add(11);
        return elements;
    }

    private List<Integer> getOddNumberOfElements() {
        List<Integer> elements = new ArrayList<>(7);
        elements.add(5);
        elements.add(15);
        elements.add(6);
        elements.add(1);
        elements.add(3);
        elements.add(11);
        elements.add(9);
        return elements;
    }

    private List<Integer> getElementsNotesExample1() {
        List<Integer> elements = new ArrayList<>(4);
        elements.add(4);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        return elements;
    }

    private List<Integer> getElementsNotesExample2() {
        List<Integer> elements = new ArrayList<>(8);
        elements.add(8);
        elements.add(2);
        elements.add(4);
        elements.add(5);
        elements.add(7);
        elements.add(1);
        return elements;
    }

    @Test
    public void testLeftMostPivotSelectorFullSet() {
        IPivotSelector selector = new LeftMostPivotSelector();
        List<Integer> elements = getEvenNumberOfElements();
        int startIndex = 0;
        int endIndex = elements.size() - 1;
        assertEquals(0, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testLeftMostPivotSelectorPartialSet() {
        IPivotSelector selector = new LeftMostPivotSelector();
        List<Integer> elements = getEvenNumberOfElements();
        int startIndex = 1;
        int endIndex = 4;
        assertEquals(1, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testRightMostPivotSelectorFullSet() {
        IPivotSelector selector = new RightMostPivotSelector();
        List<Integer> elements = getEvenNumberOfElements();
        int startIndex = 0;
        int endIndex = elements.size() - 1;
        assertEquals(elements.size() - 1, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testRightMostPivotSelectorPartialSet() {
        IPivotSelector selector = new RightMostPivotSelector();
        List<Integer> elements = getEvenNumberOfElements();
        int startIndex = 1;
        int endIndex = 4;
        assertEquals(4, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testMedianPivotSelectorEvenElementsFullSet() {
        IPivotSelector selector = new MedianPivotSelector();
        List<Integer> elements = getEvenNumberOfElements();
        int startIndex = 0;
        int endIndex = elements.size() - 1;
        assertEquals(2, selector.getPivotIndex(elements, startIndex, endIndex));

        elements = getElementsNotesExample1();
        startIndex = 0;
        endIndex = elements.size() - 1;
        assertEquals(1, selector.getPivotIndex(elements, startIndex, endIndex));

        elements = getElementsNotesExample2();
        startIndex = 0;
        endIndex = elements.size() - 1;
        assertEquals(2, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testMedianPivotSelectorWithTwoElements() {
        IPivotSelector selector = new MedianPivotSelector();
        List<Integer> elements = new ArrayList<>();
        elements.add(10);
        elements.add(3);
        int startIndex = 0;
        int endIndex = 1;
        assertEquals(1, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testMedianPivotSelectorEvenElementsPartialSet() {
        IPivotSelector selector = new MedianPivotSelector();
        List<Integer> elements = getEvenNumberOfElements();
        int startIndex = 1;
        int endIndex = 4;
        assertEquals(2, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testMedianPivotSelectorOddElementsFullSet() {
        IPivotSelector selector = new MedianPivotSelector();
        List<Integer> elements = getOddNumberOfElements();
        int startIndex = 0;
        int endIndex = elements.size() - 1;
        assertEquals(0, selector.getPivotIndex(elements, startIndex, endIndex));
    }

    @Test
    public void testMedianPivotSelectorOddElementsPartialSet() {
        IPivotSelector selector = new MedianPivotSelector();
        List<Integer> elements = getOddNumberOfElements();
        int startIndex = 1;
        int endIndex = 5;
        assertEquals(5, selector.getPivotIndex(elements, startIndex, endIndex));
    }

}
