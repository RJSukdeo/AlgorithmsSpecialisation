package DataStructures;

// This class was influenced by the Princeton notes regarding Union-Find implementations.
// Union: O(logN) and Find: O(logN)

public final class QuickUnion {

    private int[] id;
    private int[] size;

    public QuickUnion(int numElements) {
        id = new int[numElements];
        size = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    // Finds the leader node of the set.
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    // Checks if both elements exist in the same set.
    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    // Merge two sets.
    public void unite(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

}
