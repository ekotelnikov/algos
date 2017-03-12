package com.ek9v.algo.exercises.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 18.01.2017.
 */
public class SockMerchantTest {

	@Test
	public void testCalc() {
//		int[] s = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		int[] s = {10, 10, 10, 10};
		Scanner sc = new Scanner(System.in);

		int p = SockMerchant.calc(s);

		Assert.assertThat(p, is(2));
	}

}