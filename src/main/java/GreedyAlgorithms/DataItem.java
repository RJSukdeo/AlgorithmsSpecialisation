package GreedyAlgorithms;

import java.util.Objects;

public final class DataItem {

    private final int weight;
    private final int length;

    public DataItem(final int weight, final int length) {
        this.weight = weight;
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataItem dataItem = (DataItem) o;
        return weight == dataItem.weight &&
                length == dataItem.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, length);
    }
}