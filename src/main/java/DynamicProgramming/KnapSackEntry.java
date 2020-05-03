package DynamicProgramming;

public final class KnapSackEntry {

    private final int weight;
    private final int value;

    KnapSackEntry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

}
