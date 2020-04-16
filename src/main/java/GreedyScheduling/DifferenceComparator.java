package GreedyScheduling;

import java.util.Comparator;

public class DifferenceComparator implements Comparator<DataItem> {

    @Override
    public int compare(DataItem t0, DataItem t1) {
        long result0 = t0.getWeight() - t0.getLength();
        long result1 = t1.getWeight() - t1.getLength();
        if (result1 > result0) {
            return 1;
        }
        if (result1 < result0) {
            return -1;
        }
        if (result1 == result0) {
            if (t1.getWeight() > t0.getWeight()) {
                return 1;
            }
            if (t1.getWeight() < t0.getWeight()) {
                return -1;
            }
        }
        return 0;
    }

}
