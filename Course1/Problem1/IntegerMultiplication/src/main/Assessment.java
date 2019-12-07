package main;

import main.Multipliers.KaratsubaMultiplier;

import java.math.BigInteger;

public class Assessment {
    public static void main(String[] args) {
        KaratsubaMultiplier multiplier = new KaratsubaMultiplier(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592") ,
                new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"));
        System.out.println(multiplier.getResult());
    }
}
