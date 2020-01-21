package Multipliers;

import Splitter.*;
import java.math.BigInteger;
import java.util.List;

public final class KaratsubaMultiplier {

    private BigInteger result;

    public KaratsubaMultiplier(final BigInteger a, final BigInteger b) {
        this.result = multiply(SplitterUtil.split(a), SplitterUtil.split(b));
    }

    private BigInteger multiply(final List<BigInteger> elements1, final List<BigInteger> elements2) {
        int numElements = elements1.size();
        if (numElements == 1) {
            return BigInteger.valueOf(elements1.get(0).intValue() * elements2.get(0).intValue());
        }
        List<BigInteger> a = elements1.subList(0, numElements / 2);
        List<BigInteger> b = elements1.subList(numElements / 2, numElements);
        List<BigInteger> c = elements2.subList(0, numElements / 2);
        List<BigInteger> d = elements2.subList(numElements / 2, numElements);
        BigInteger ac = multiply(a, c);
        BigInteger bd = multiply(b, d);
        BigInteger ad = multiply(a, d);
        BigInteger bc = multiply(b, c);
        return padNumbers(ac, numElements).
                add(padNumbers(ad.add(bc), numElements / 2)).
                add(bd);
    }

    private BigInteger padNumbers(final BigInteger number, final long noOfZeros) {
        List<BigInteger> elements = SplitterUtil.split(number);
        for (int i = 0; i < noOfZeros; i++) {
            elements.add(BigInteger.ZERO);
        }
        return aggregateNumbers(elements);
    }

    private BigInteger aggregateNumbers(final List<BigInteger> elements) {
        StringBuilder sb = new StringBuilder();
        for (BigInteger e : elements) {
            sb.append(e);
        }
        return new BigInteger(sb.toString());
    }

    public BigInteger getResult() {
        return result;
    }
}
