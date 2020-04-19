package GreedyAlgorithms;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class SchedulingAlgorithmTestCase {

    @Test
    public void testRun() {
        SchedulingAlgorithm algorithm = new SchedulingAlgorithm(getData());
        SchedulingAlgorithmResults results = algorithm.run((t0, t1) -> {
            return t0.getWeight() - t1.getWeight();
        });
        DataItem[] orderedEntries = results.getOrderdEntries();
        assertEquals(new DataItem(1, 11), orderedEntries[0]);
        assertEquals(new DataItem(2, 5), orderedEntries[1]);
        assertEquals(new DataItem(3, 8), orderedEntries[2]);
        assertEquals(new DataItem(6, 4), orderedEntries[3]);
        assertEquals(new DataItem(7, 3), orderedEntries[4]);
        assertEquals(new DataItem(8, 20), orderedEntries[5]);
        assertEquals(new DataItem(14, 8), orderedEntries[6]);
    }

    private List<DataItem> getData() {
        List<DataItem> data = new ArrayList<>(6);
        data.add(new DataItem(2, 5));
        data.add(new DataItem(7, 3));
        data.add(new DataItem(6, 4));
        data.add(new DataItem(1, 11));
        data.add(new DataItem(8, 20));
        data.add(new DataItem(14, 8));
        data.add(new DataItem(3, 8));
        return data;
    }

}
