package MedianMaintenance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class MedianCalculatorTestCase {

    @Test
    public void testMedianCalculator() {
        int[] testElements = new int[]{6, 8, 20, 18, 32, 1};
        double[] medians = new double[6];
        MedianCalculator calculator = MedianCalculator.getInstance();
        for (int i = 0; i < testElements.length; i++) {
            medians[i] = calculator.addElement(testElements[i]).getMedian();
        }
        assertEquals(medians[0], 6, 1e-1);
        assertEquals(medians[1], 6, 1e-1);
        assertEquals(medians[2], 8, 1e-1);
        assertEquals(medians[3], 8, 1e-1);
        assertEquals(medians[4], 18, 1e-1);
        assertEquals(medians[5], 8, 1e-1);
    }

    @Test
    public void testMedianCalculatorWithRepeatedElements() {
        int[] testElements = new int[] {16, 15, 8, 8, 8, 12, 15, 6, 6};
        double[] medians = new double[9];
        MedianCalculator calculator = MedianCalculator.getInstance();
        for (int i = 0; i < testElements.length; i++) {
            medians[i] = calculator.addElement(testElements[i]).getMedian();
        }
        assertEquals(medians[0], 16, 1e-1);
        assertEquals(medians[1], 15, 1e-1);
        assertEquals(medians[2], 15, 1e-1);
        assertEquals(medians[3], 8, 1e-1);
        assertEquals(medians[4],  8, 1e-1);
        assertEquals(medians[5], 8, 1e-1);
        assertEquals(medians[6], 12, 1e-1);
        assertEquals(medians[7], 8, 1e-1);
        assertEquals(medians[8], 8, 1e-1);
    }

}
