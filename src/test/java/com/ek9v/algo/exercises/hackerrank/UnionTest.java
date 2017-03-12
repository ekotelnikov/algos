package com.ek9v.algo.exercises.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 19.01.2017.
 */
public class UnionTest {

	@Test
	public void findRoot() throws Exception {
		Union u = new Union(4);
		assertThat(u.find(0), is(0));
		assertThat(u.find(3), is(3));
	}

	@Test
	public void connected() throws Exception {
		Union u = new Union(4);
		assertThat(u.connected(0, 3), is(false));
	}

	@Test
	public void union() throws Exception {
		Union u = new Union(6);
		u.union(0, 3);
		u.union(1, 2);
		u.union(2, 3);
		u.union(4, 5);

		assertThat(u.connected(0, 1), is(true));
		assertThat(u.connected(1, 2), is(true));
		assertThat(u.connected(2, 3), is(true));
		assertThat(u.connected(0, 5), is(false));
		assertThat(u.connected(4, 5), is(true));
		assertThat(u.getCount(), is(2));
		int[] sz = u.getSz();
		for (int i : sz) {
			System.out.print(i + ", ");
		}
	}

}