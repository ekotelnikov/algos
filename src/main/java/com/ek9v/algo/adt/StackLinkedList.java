package com.ek9v.algo.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by user on 24.12.2016.
 */
public class StackLinkedList<T> implements Stack<T>{

	private Node<T> first;

	private int n;

	public void push(T value) {
		Node<T> oldFirst = first;
		first = new Node<>(value, oldFirst);
		n++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("StackLinkedList is empty!");
		}
		T value = first.value;
		first = first.next;
		n--;
		return value;
	}

	public int getSize() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Node<T> current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				Node<T> r = current;
				current = current.next;
				return r.value;
			}
		};
	}

	private class Node<T> {

		private Node<T> next;

		private T value;

		private Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}
}
