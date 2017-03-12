package com.ek9v.algo.exercises.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 15.01.2017.
 */
public class Movie {

	private int id;
	private float rate;

	private Set<Movie> related = new HashSet<>();

	public Movie(int id, float rate) {
		this.id = id;
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public float getRate() {
		return rate;
	}

	public Set<Movie> getRelated() {
		return related;
	}

	public void addRelated(Movie movie) {
		this.related.add(movie);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Movie movie = (Movie) o;

		return id == movie.id;

	}

	@Override
	public int hashCode() {
		return id;
	}
}
