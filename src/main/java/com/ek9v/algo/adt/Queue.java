package com.ek9v.algo.adt;

/**
 * Created by user on 25.12.2016.
 */
public interface Queue<T> {

	void enqueue(T value);

	T dequeue();

	int getSize();

	boolean isEmpty();
}
