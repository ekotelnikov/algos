package com.ek9v.algo.adt;

import java.util.NoSuchElementException;

/**
 * Created by user on 25.12.2016.
 */
public class QueueLinkedList<T> implements Queue<T> {

	private Node<T> first;
	private Node<T> last;

	private int n;

	@Override
	public void enqueue(T value) {
		Node oldLast = last;
		last = new Node<>(value, null);
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		n++;
	}

	@Override
	public T dequeue() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T value = first.value;
		first = first.next;
		n--;
		return value;
	}

	@Override
	public int getSize() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	private class Node<T> {

		private T value;

		private Node<T> next;

		private Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}
}
