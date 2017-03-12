package com.ek9v.algo.exercises;

import java.util.Arrays;

/**
 * Created by user on 18.01.2017.
 */
public class MinMaxSum {

	public static long[] calc(long a, long b, long c, long d, long e) {
		long[] digits = {a,b,c,d,e};
		Arrays.sort(digits);

		long min = digits[0] + digits[1] + digits[2] + digits[3];
		long max = digits[4] + digits[1] + digits[2] + digits[3];

		return new long[]{min, max};
	}
}
