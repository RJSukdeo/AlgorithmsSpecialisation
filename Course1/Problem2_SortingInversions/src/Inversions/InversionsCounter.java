package Inversions;

import java.util.ArrayList;
import java.util.List;

public final class InversionsCounter {

    private final List<Integer> rawElements;
    private InversionsContainer processedElements;

    public InversionsCounter(List<Integer> elements) {
        this.rawElements = elements;
    }

    public long getNumberOfInversions() {
        if (processedElements == null) {
            processedElements = countSort(rawElements);
        }
        return processedElements.getNumInversions();
    }

    public List<Integer> getSortedElements() {
        if (processedElements == null) {
            processedElements = countSort(rawElements);
        }
        return processedElements.getElements();
    }

    private static InversionsContainer countSort(List<Integer> elements) {
        if (elements.size() < 2) {
            return new InversionsContainer(elements, 0);
        }
        InversionsContainer leftResult = InversionsCounter.countSort(elements.subList(0, elements.size() / 2));
        InversionsContainer rightResult = InversionsCounter.countSort(elements.subList(elements.size() / 2, elements.size()));
        InversionsContainer splitResult = InversionsCounter.countSortSplit(leftResult.getElements(), rightResult.getElements());
        return new InversionsContainer(splitResult.getElements(), leftResult.getNumInversions() + rightResult.getNumInversions() + splitResult.getNumInversions());
    }

    private static InversionsContainer countSortSplit(List<Integer> sortedElementsLeft, List<Integer> sortedElementsRight) {
        long numOfInversions = 0;
        int totalNumberOfElemeents = sortedElementsLeft.size() + sortedElementsRight.size();
        List<Integer> sortedElements = new ArrayList<>(totalNumberOfElemeents);
        int leftCounter = 0;
        int rightCounter = 0;
        for (int i = 0; i < totalNumberOfElemeents; i++) {
            if (leftCounter < sortedElementsLeft.size() && rightCounter < sortedElementsRight.size()){
                if (sortedElementsLeft.get(leftCounter) > sortedElementsRight.get(rightCounter)) {
                    sortedElements.add(sortedElementsRight.get(rightCounter));
                    numOfInversions += sortedElementsLeft.size()  - leftCounter;
                    rightCounter++;
                } else {
                    sortedElements.add(sortedElementsLeft.get(leftCounter));
                    leftCounter++;
                }
            } else {
                if (leftCounter >= sortedElementsLeft.size()){
                    sortedElements.addAll(sortedElementsRight.subList(rightCounter, sortedElementsRight.size()));
                } else {
                    sortedElements.addAll(sortedElementsLeft.subList(leftCounter, sortedElementsLeft.size()));
                }
                break;
            }
        }
        return new InversionsContainer(sortedElements, numOfInversions);
    }

}
