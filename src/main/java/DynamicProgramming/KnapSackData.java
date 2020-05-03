package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnapSackData {

    private final int maxWeight;
    private final int numberOfElements;
    private List<KnapSackEntry> elements;

    public KnapSackData(String filename) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(filename));
        String[] info = scanner.nextLine().split(" ");
        this.maxWeight = Integer.parseInt(info[0]);
        this.numberOfElements = Integer.parseInt(info[1]);
        this.elements = new ArrayList<>(numberOfElements);
        populateElements(scanner);
    }

    public KnapSackData(int maxWeight, int[] weights, int[] values) {
        this.maxWeight = maxWeight;
        this.numberOfElements = weights.length;
        elements = new ArrayList<>(weights.length);
        for (int i = 0; i < weights.length; i++) {
            elements.add(new KnapSackEntry(weights[i], values[i]));
        }
    }

    private void populateElements(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String[] stringEntries = scanner.nextLine().split(" ");
            elements.add(new KnapSackEntry(Integer.parseInt(stringEntries[1]), Integer.parseInt(stringEntries[0])));
        }
    }

    int getMaxWeight() {
        return maxWeight;
    }

    int getNumberOfElements() {
        return numberOfElements;
    }

    List<KnapSackEntry> getElements() {
        return elements;
    }

}
