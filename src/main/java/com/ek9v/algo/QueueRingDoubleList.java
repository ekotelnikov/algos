package com.ek9v.algo;

import java.util.NoSuchElementException;

/**
 * Created by user on 25.12.2016.
 */
public class QueueRingDoubleList<T> implements Queue<T> {

	private Node<T> last;

	private int n;

	@Override
	public void enqueue(T value) {
		if (isEmpty()) {
			last = new Node<>(value);
			last.next = last;
			last.prev = last;
		} else {
			last = new Node<>(value, last, last.prev);
		}
		n++;
	}

	@Override
	public T dequeue() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		Node<T> first = last.prev;
		first.prev.next = first.next;
		last.prev = first.prev;
		T value = first.value;
		n--;
		if (n == 0) {
			last = null;
		}
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

		private Node<T> prev;

		private Node(T value) {
			this.value = value;
		}

		private Node(T value, Node<T> next, Node<T> prev) {
			this.value = value;

			this.next = next;
			this.next.prev = this;
			this.prev = prev;
			this.prev.next = this;
		}
	}
}
