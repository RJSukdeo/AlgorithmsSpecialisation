package GreedyAlgorithms;

import java.util.Comparator;

public final class DivisionComparator implements Comparator<DataItem> {

    @Override
    public int compare(DataItem t0, DataItem t1) {
        double result0 = (t0.getWeight()*1.0)/(t0.getLength()*1.0);
        double result1 = (t1.getWeight()*1.0)/(t1.getLength()*1.0);
        if (result1 > result0) {
            return 1;
        }
        if (result1 < result0) {
            return -1;
        }
        return 0;
    }

}
