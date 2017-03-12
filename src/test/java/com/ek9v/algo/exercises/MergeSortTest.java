package com.ek9v.algo.exercises;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by user on 14.01.2017.
 */
public class MergeSortTest {

	@Test
	public void testSort() {
		int[] a = new int[] {7,5,3,4,0,9,1,6,8,2};

		int[] r = MergeSort.sort(a, 0, 9);

		int[] e = new int[] {0,1,2,3,4,5,6,7,8,9};
		Assert.assertThat(r, is(e));
	}

}
