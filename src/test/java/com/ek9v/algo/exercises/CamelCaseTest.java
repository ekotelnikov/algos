package com.ek9v.algo.exercises;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 16.01.2017.
 */
public class CamelCaseTest {

	@Test
	public void testCountWords() {
		String s = "thisIsAWord";
		int w = CamelCase.countWords(s);

		Assert.assertThat(w, is(4));
	}

	@Test
	public void testCountNullWords() {
		String s = null;
		int w = CamelCase.countWords(s);

		Assert.assertThat(w, is(0));
	}

	@Test
	public void testCountOneWord() {
		String s = null;
		int w = CamelCase.countWords("word");

		Assert.assertThat(w, is(1));
	}

	@Test
	public void testCountWordWithNoLetterSigns() {
		String s = null;
		int w = CamelCase.countWords("word123:,/UpperCase");

		Assert.assertThat(w, is(3));
	}
}