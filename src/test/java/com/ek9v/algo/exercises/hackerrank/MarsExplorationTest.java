package com.ek9v.algo.exercises.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 18.01.2017.
 */
public class MarsExplorationTest {

	@Test
	public void testExplore() {
//		String s = "SOSSPSSQSSOR";
		String s = "SOSSOT";
		int n = MarsExploration.explore(s);

		Assert.assertThat(n, is(3));
	}

}