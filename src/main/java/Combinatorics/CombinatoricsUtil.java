package Combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CombinatoricsUtil {

    private CombinatoricsUtil() {
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return Math.multiplyExact(n, factorial(n - 1));
    }

    // n choose k = n!/(k!(n-k)!)
    public static long getNumCombinations(int n, int k) {
        return factorial(n) / Math.multiplyExact(factorial(k), factorial(n - k));
    }

    public static <T> List<Set<T>> getAllPossibleCombinations(final T[] elements, final int k) {
        List<Set<T>> combinations = new ArrayList<>();
        List<T> tempElements = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            tempElements.add(elements[i]);
        }
        getAllPossibleCombinations(elements, tempElements, combinations, 0, elements.length - 1, 0, k);
        return combinations;
    }

    private static <T> void getAllPossibleCombinations(final T[] arr, final List<T> tempArr, List<Set<T>> result, final int startIndex, final int endIndex, final int index, final int k) {
        if (index == k) {
            result.add(new HashSet<>(tempArr));
            return;
        }
        for (int i = startIndex; i <= endIndex && (endIndex - i + 1 >= k - index); i++) {
            tempArr.set(index, arr[i]);
            getAllPossibleCombinations(arr, tempArr, result,i + 1, endIndex, index + 1, k);
        }
    }

}
