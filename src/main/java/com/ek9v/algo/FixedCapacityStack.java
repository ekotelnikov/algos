package com.ek9v.algo;

import java.util.Iterator;

/**
 * Created by user on 25.12.2016.
 */
public class FixedCapacityStack<T> implements Stack<T>, Iterable<T> {

	private T[] values;

	private int n = 0;

	@SuppressWarnings("unchecked")
	public FixedCapacityStack() {
		values = (T[]) new Object[8];
	}

	public void push(T value) {
		if (n == values.length) {
			values = resize(values.length * 2);
		}
		values[n++] = value;
	}

	@SuppressWarnings("unchecked")
	private T[] resize(int newSize) {
		T[] newValues = (T[]) new Object[newSize];
		for (int i = 0; i < n; i++) {
			newValues[i] = values[i];
		}
		return newValues;
	}

	public T pop() {
		T value = values[--n];
		values[n] = null;
		if (n > 0 && n == values.length / 4) {
			values = resize(values.length / 2);
		}
		return value;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int getSize() {
		return n;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			int t = n;

			@Override
			public boolean hasNext() {
				return t > 0;
			}

			@Override
			public T next() {
				return values[--t];
			}
		};
	}
}
