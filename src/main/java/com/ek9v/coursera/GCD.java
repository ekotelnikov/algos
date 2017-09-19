package com.ek9v.coursera;

/**
 * Greatest common divisor.
 */
public class GCD {

    public static int calculate(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculate(b, a % b);
    }
}
