package com.ek9v.algo.exercises.graph;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by user on 15.01.2017.
 */
public class GraphMovieTest {

	private int deep = 3;
	private int id = 0;

	@Test
	public void testExplore() {

		Movie m = generateMovies(1);

		GraphMovie g = new GraphMovie(m);
	}

	private Movie generateMovies(int level) {
		Movie m = new Movie(++id, generateRate());
		if (level == deep) return m;
		int n = 3;
		for (int i = 1; i <= n; i++) {
			m.addRelated(generateMovies(level + 1));
		}
		return m;
	}

	private Float generateRate() {
		return (float)Math.random() * 10;
	}

}