package com.ek9v.algo;

import java.util.NoSuchElementException;

/**
 * Created by user on 25.12.2016.
 */
public class QueueArray<T> implements Queue<T> {

	//TODO уменьшить размер массива в процессе уменьшения кол-ва елементов.
	private T[] items;

	private int n = 0;
	private int k = 0;

	@SuppressWarnings("unchecked")
	public QueueArray() {
		items = (T[]) new Object[2];
	}

	@Override
	public void enqueue(T value) {
		if (n == items.length) {
			resize();
		}
		items[n++] = value;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		T[] newItems = (T[]) new Object[items.length * 2];
		for (int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		items = newItems;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T item = items[k++];
		items[k-1] = null;
		return item;
	}

	@Override
	public int getSize() {
		return n - k;
	}

	@Override
	public boolean isEmpty() {
		return n == k;
	}
}
