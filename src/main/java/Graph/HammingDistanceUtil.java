package Graph;

public final class HammingDistanceUtil {

    private HammingDistanceUtil() {
    }

    public static int getHammingDistance(String entry1, String entry2) {
        return getHammingDistance(entry1, entry2, entry1.length() + 1);
    }

    public static int getHammingDistance(String entry1, String entry2, int valueStop) {
        if (entry1.length() != entry2.length()) {
            System.out.println("Entries are not equal in length");
            System.exit(0);
        }
        int distance = 0;
        if (entry1.equals(entry2)) {
            return distance;
        }
        for (int i = 0; i < entry1.length(); i++) {
            if (entry1.charAt(i) != entry2.charAt(i)) {
                distance++;
                if (distance == valueStop) {
                    return distance;
                }
            }
        }
        return distance;
    }

}
