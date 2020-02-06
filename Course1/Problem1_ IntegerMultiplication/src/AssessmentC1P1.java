import Multipliers.KaratsubaMultiplier;
import java.math.BigInteger;

public final class AssessmentC1P1 {

    // Expected output
    // 8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184
    public static void main(String[] args) {
        KaratsubaMultiplier multiplier = new KaratsubaMultiplier(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592") ,
                new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"));
        System.out.println(multiplier.getResult());
    }
}
