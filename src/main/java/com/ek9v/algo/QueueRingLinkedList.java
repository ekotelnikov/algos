package com.ek9v.algo;

import java.util.NoSuchElementException;

/**
 * Created by user on 25.12.2016.
 */
public class QueueRingLinkedList<T> implements Queue<T> {

	private Node<T> last;

	private int n;

	@Override
	public void enqueue(T value) {
		if (isEmpty()) {
			last = new Node<>(value, null);
			last.next = last;
		} else {
			Node<T> oldLast = last;
			Node first = getPrevious(last);
			last = new Node<>(value, oldLast);
			first.next = last;
		}
		n++;
	}

	private Node<T> getPrevious(Node<T> node) {
		Node<T> first = node.next;
		while (first.next != node) {
			first = first.next;
		}
		return first;
	}

	@Override
	public T dequeue() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		Node<T> first = getPrevious(last);
		Node<T> second = getPrevious(first);
		T value = first.value;
		second.next = last;
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

		private Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}
}
