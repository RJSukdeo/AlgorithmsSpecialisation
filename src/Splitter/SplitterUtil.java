package Splitter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SplitterUtil {

    private SplitterUtil() {
    }

    public static List<BigInteger> split(final BigInteger input) {
        List<BigInteger> terms = new ArrayList<>();
        split(input, terms);
        Collections.reverse(terms);
        return terms;
    }

    private static List<BigInteger> split(final BigInteger input, final List<BigInteger> terms) {
        if (input.compareTo(new BigInteger("9")) == 1) {
            terms.add(input.divideAndRemainder(new BigInteger("10"))[1]);
            return split(input.divide(new BigInteger("10")), terms);
        }
        terms.add(input);
        return terms;
    }

}
