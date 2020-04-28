package Graph;

import org.junit.Assert;
import org.junit.Test;

public final class HammingDistanceUtilTestCase {

    @Test
    public void testHammingDistance() {
        String entry1 = "110111100101101101000101";
        String entry2 = "001001100110010011100110";
        Assert.assertEquals(15, HammingDistanceUtil.getHammingDistance(entry1, entry2));
    }

}
