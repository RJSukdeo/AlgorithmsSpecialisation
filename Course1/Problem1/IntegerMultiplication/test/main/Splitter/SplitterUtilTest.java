package main.Splitter;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

public class SplitterUtilTest {

    @Test
    public void testSplitDouble() {
        BigInteger input = new BigInteger("881030");
        List<BigInteger> output = SplitterUtil.split(input);
        Assert.assertEquals(output.get(0).intValue(), 8);
        Assert.assertEquals(output.get(1).intValue(), 8);
        Assert.assertEquals(output.get(2).intValue(), 1);
        Assert.assertEquals(output.get(3).intValue(), 0);
        Assert.assertEquals(output.get(4).intValue(), 3);
        Assert.assertEquals(output.get(5).intValue(), 0);
    }

}
