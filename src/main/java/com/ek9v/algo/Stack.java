package com.ek9v.algo;

/**
 * Created by user on 25.12.2016.
 */
public interface Stack<T> extends Iterable<T> {

	void push(T value);

	T pop();

	int getSize();

	boolean isEmpty();
}
