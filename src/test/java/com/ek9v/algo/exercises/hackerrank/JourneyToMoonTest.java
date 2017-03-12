package com.ek9v.algo.exercises.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 19.01.2017.
 */
public class JourneyToMoonTest {

	@Test
	public void testCountPairs() {
		int[] c = {0, 1, 2, 3};

		long p = JourneyToMoon.countPairs(c, 4);

		assertThat(p, is(4L));
	}

	@Test
	public void testCountOnePair() {
		int[] c = {0, 1};

		long p = JourneyToMoon.countPairs(c, 2);

		assertThat(p, is(0L));
	}

	@Test
	public void testCountOneCountry() {
		int[] c = new int[10];
		int count = 0;
		for (int i = 0; i < c.length - 1; i+=2) {
			c[i] = count++;
			c[i+1] = count;
		}
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + ", ");
		}
//		c[0] = 1; c[1] = 100; c[2] = 2; c[3] = 3; c[4] = 1; c[5] = 3;
//		{1, 200, 2, 3, 1, 3};

		long p = JourneyToMoon.countPairs(c, 6);

		assertThat(p, is(0L));
	}

	@Test
	public void testCountOneCountry_1() {
		int[] c = {1, 4, 4, 1, 2, 3};

		long p = JourneyToMoon.countPairs(c, 5);

		assertThat(p, is(8L));
	}

	@Test
	public void testCountZeroCountry() {
		int[] c = {0, 1, 1, 2};

		long p = JourneyToMoon.countPairs(c, 3);

		assertThat(p, is(0L));
	}

	@Test
	public void testCountZeroCountry_1() {
		int[] c = {1, 5};

		long p = JourneyToMoon.countPairs(c, 6);

		assertThat(p, is(14L));
	}

	@Test
	public void testCountZeroCountryBig() {
		int[] c = {1, 2, 3, 4};

		long p = JourneyToMoon.countPairs(c, 100000);

		assertThat(p, is(4999949998L));
	}
}