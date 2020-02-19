package CourseSolutions.Course1.Problem1_IntegerMultiplication;

import CourseSolutions.ICourseSolution;
import Multipliers.KaratsubaMultiplier;

import java.math.BigInteger;

// Expected output
// 8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184

public final class AssessmentC1P1 implements ICourseSolution {

    @Override
    public String getProblemDescription() {
        return "Implementation of Karatsuba Multiplication algorithm.";
    }

    @Override
    public short getCourseNumber() {
        return 1;
    }

    @Override
    public short getProblemNumber() {
        return 1;
    }

    @Override
    public void run() {
        KaratsubaMultiplier multiplier = new KaratsubaMultiplier(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592"),
                new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"));
        System.out.println(multiplier.getResult());
    }

}
