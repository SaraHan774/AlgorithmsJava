package com.gahee.algorithms.coursera;


import java.math.BigInteger;

//So: what's the product of the following two 64-digit numbers?
//3141592653589793238462643383279502884197169399375105820974944592
//2718281828459045235360287471352662497757247093699959574966967627
public class KaratsubaProduct {

    public static void main(String[] args) {

        String x = "3141592653589793238462643383279502884197169399375105820974944592";
        String y = "2718281828459045235360287471352662497757247093699959574966967627";

        long start = System.currentTimeMillis();
        BigInteger result = product(new BigInteger(x), new BigInteger(y));
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("duration : " + (end - start));
    }

    private static BigInteger product(BigInteger x, BigInteger y) {

            int N = Math.max(x.bitLength(), y.bitLength());
            if(N <= 10){
                return x.multiply(y);
            }

            N = (N/2) + (N%2);

            BigInteger b = x.shiftRight(N);
            BigInteger a = x.subtract(b.shiftLeft(N));
            BigInteger d = y.shiftRight(N);
            BigInteger c = y.subtract(d.shiftLeft(N));
            System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);

            BigInteger ac = product(a, c);
            BigInteger bd = product(b, d);
            BigInteger abcd = product(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }
}
