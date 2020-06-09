package Combinatorics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public final class CombinatoricsTestCase {

    @Test
    public void testFactorial() {
        assertEquals(1, CombinatoricsUtil.factorial(0));
        assertEquals(120, CombinatoricsUtil.factorial(5));
    }

    @Test
    public void testCombination() {
        assertEquals(45, CombinatoricsUtil.getNumCombinations(10, 2));
        assertEquals(1, CombinatoricsUtil.getNumCombinations(10, 10));
    }

    @Test
    public void testAllPossibleCombinations() {
        Integer[] elements = new Integer[]{1, 2, 3, 4, 5};
        List<Set<Integer>> results = CombinatoricsUtil.getAllPossibleCombinations(elements, 3);
        assertEquals(10, results.size());
        assertEquals(getData(), results);
    }

    private List<Set<Integer>> getData() {
        List<Set<Integer>> sets = new ArrayList<>(10);
        sets.add(getIntegerSet(1, 2, 3));
        sets.add(getIntegerSet(1, 2, 4));
        sets.add(getIntegerSet(1, 2, 5));
        sets.add(getIntegerSet(1, 3, 4));
        sets.add(getIntegerSet(1, 3, 5));
        sets.add(getIntegerSet(1, 4, 5));
        sets.add(getIntegerSet(2, 3, 4));
        sets.add(getIntegerSet(2, 3, 5));
        sets.add(getIntegerSet(2, 4, 5));
        sets.add(getIntegerSet(3, 4, 5));
        return sets;
    }

    private Set<Integer> getIntegerSet(int input1, int input2, int input3) {
        Set<Integer> integerSet = new HashSet<>(3);
        integerSet.add(input1);
        integerSet.add(input2);
        integerSet.add(input3);
        return integerSet;
    }

}
