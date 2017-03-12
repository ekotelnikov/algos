package com.ek9v.algo.exercises;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by user on 15.01.2017.
 */
public class MedianaTest {

	@Test
	public void split() {
		int[] a = new int[] {2,21,5,6,9,4,5,1,30};

		a = Mediana.split(a);

		int[] e = new int[] {2,4,1,5,5,21,6,9,30};
		Assert.assertThat(a, is(e));
	}

}
