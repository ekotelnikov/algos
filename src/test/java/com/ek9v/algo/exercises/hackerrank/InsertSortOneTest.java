package com.ek9v.algo.exercises.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 21.01.2017.
 */
public class InsertSortOneTest {
	@Test
	public void insertIntoSorted() throws Exception {
		int[] a = {2,4,6,8,3};
		InsertSortOne.insertIntoSorted(a);

		assertThat(a, is(new int[] {2,3,4,6,8}));
	}

	@Test
	public void insertIntoSortedBegin() throws Exception {
		int[] a = {2,4,6,8,1};
		InsertSortOne.insertIntoSorted(a);

		assertThat(a, is(new int[] {1,2,4,6,8}));
	}

	@Test
	public void insertIntoSortedEnd() throws Exception {
		int[] a = {2,4,6,8,9};
		InsertSortOne.insertIntoSorted(a);

		assertThat(a, is(new int[] {2,4,6,8,9}));
	}

	@Test
	public void insertIntoSortedTen() throws Exception {
		int[] a = {2,3,4, 5, 6, 7, 8, 9, 10, 1};
		InsertSortOne.insertIntoSorted(a);

		assertThat(a, is(new int[] {1,2,3,4, 5, 6, 7, 8, 9, 10}));
	}
}