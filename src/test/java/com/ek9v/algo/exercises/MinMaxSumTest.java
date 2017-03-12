package com.ek9v.algo.exercises;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 18.01.2017.
 */
public class MinMaxSumTest {

	@Test
	public void testCalc() {
		long a = 1;
		long b = 3;
		long c = 5;
		long d = 2;
		long e = 4;

		long[] sum = MinMaxSum.calc(a, b, c, d, e);

		assertThat(sum[0], is(10L));
		assertThat(sum[1], is(14L));
	}

}