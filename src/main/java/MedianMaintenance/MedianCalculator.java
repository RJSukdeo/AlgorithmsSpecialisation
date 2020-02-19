package MedianMaintenance;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class MedianCalculator {

    private final PriorityQueue<Integer> smallestElements;
    private final PriorityQueue<Integer> largestElements;
    private int counter;

    private MedianCalculator() {
        counter = 0;
        smallestElements = new PriorityQueue<>(new MaxComparator());
        largestElements = new PriorityQueue<>(new MinComparator());
    }

    public static MedianCalculator getInstance() {
        return new MedianCalculator();
    }

    public MedianCalculator addElement(int element) {
        ++counter;
        if (smallestElements.isEmpty()) {
            smallestElements.add(element);
            return this;
        }
        if (element <= smallestElements.peek()) {
            smallestElements.add(element);
        } else {
            largestElements.add(element);
        }
        rebalanceHeaps();
        return this;
    }

    public double getMedian() {
        if (smallestElements.isEmpty()) {
            return Double.NaN;
        }
        return smallestElements.peek();
    }

    private boolean evenElements() {
        return counter % 2 == 0;
    }

    private void rebalanceHeaps() {
        if (evenElements()) {
            if (smallestElements.size() == largestElements.size()) {
                return;
            }
            if (smallestElements.size() < largestElements.size()) {
                exchangeElements(largestElements, smallestElements);
                return;
            }
            exchangeElements(smallestElements, largestElements);
            return;
        }
        if (smallestElements.size() < largestElements.size()) {
            exchangeElements(largestElements, smallestElements);
        }
    }

    private void exchangeElements(PriorityQueue<Integer> fromHeap, PriorityQueue<Integer> toHeap) {
        toHeap.add(fromHeap.poll());
    }

    private final static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }

    private final static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2-i1;
        }
    }

}
