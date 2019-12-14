package Multipliers;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigInteger;

public class KaratsubaMultiplierTest {

    @Test
    public void testMultiplier(){
        KaratsubaMultiplier multiplier = new KaratsubaMultiplier(new BigInteger("25") , new BigInteger("25"));
        Assert.assertEquals("625", multiplier.getResult().toString());

        KaratsubaMultiplier tutorialExample = new KaratsubaMultiplier(new BigInteger("1234"), new BigInteger("5678"));
        Assert.assertEquals("7006652", tutorialExample.getResult().toString());

        KaratsubaMultiplier assessmentExample = new KaratsubaMultiplier(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592"),
                new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"));
        Assert.assertEquals("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184", assessmentExample.getResult().toString());
    }
}
