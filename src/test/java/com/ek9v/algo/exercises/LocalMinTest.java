package com.ek9v.algo.exercises;

import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 08.01.2017.
 */
public class LocalMinTest {

	@Test
	public void testFirstHalf() {
		TreeSet<Integer> time = new TreeSet<>();
		time.floor(5);


		LocalMin localMin = new LocalMin(3,2,1,2,3,4,5).invoke();
		assertThat(localMin.getMidIndex(), is(2));

		localMin = new LocalMin(2,1,1,2,3,4,5).invoke();
		assertThat(localMin.getMidIndex(), is(1));

		localMin = new LocalMin(2,1,0,1,2,3,4,5,6,7,8,9,10).invoke();
		assertThat(localMin.getMidIndex(), is(2));

		localMin = new LocalMin(0,1,2,3,4).invoke();
		assertThat(localMin.getMidIndex(), is(0));

		localMin = new LocalMin(0,1,1,1,0).invoke();
		assertThat(localMin.getMidIndex(), is(2));
	}

	@Test
	public void testSecondHalf() {
		LocalMin localMin = new LocalMin(5,4,3,2,1,2,3).invoke();
		assertThat(localMin.getMidIndex(), is(4));

		localMin = new LocalMin(5,4,3,2,1,0).invoke();
		assertThat(localMin.getMidIndex(), is(5));
	}

	@Test
	public void testPerformance() {
		for (int i = 100; i <= 100000000; i=i*10) {
			int[] a = generateArray(i);
			LocalMin localMin = new LocalMin(a).invoke();

			System.out.println(String.format("Count for %s is %s", i, localMin.getCount()));
		}
	}

	private int[] generateArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < a.length - 1; i++) {
			a[i] = length - (i + 1);
		}
		return a;
	}
}