package com.ek9v.algo;

import com.ek9v.algo.adt.Queue;
import com.ek9v.algo.adt.QueueArray;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 25.12.2016.
 */
public class QueueTest {

	/* Return reference of new head of the reverse linked list*/
/* Return reference of new head of the reverse linked list*/
class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}
	class gfg {

		Stack s = new Stack();
		// This function should reverse linked list and return
		// head of the modified linked list.
		Node reverse(Node head) {
			while (head.next != null) {
				s.push(head);
			}
			Node h = s.pop();
			Node t = h;
			while (!s.empty()) {
				t.next = s.pop();
				t = t.next;
			}
			return h;
		}

		class Stack {

			private Node first;

			private int n;

			public void push(Node node) {
				Node oldFirst = first;
				first = new Node(node.value);
				first.next = oldFirst;
				n++;
			}

			public Node pop() {
				if (empty()) {
					//throw new NoSuchElementException("StackLinkedList is empty!");
				}
				Node node = first;
				first = first.next;
				n--;
				return node;
			}

			public int getSize() {
				return n;
			}

			public boolean empty() {
				return n == 0;
			}

		}
	}
	@Rule public ExpectedException expectedException = ExpectedException.none();
	private Queue<Integer> queue;

	@Before
	public void setUp() {
		queue = new QueueArray<>();
	}

	@Test
	public void testPushAndPop() throws Exception {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		assertThat(queue.dequeue(), is(1));
		assertThat(queue.dequeue(), is(2));
		assertThat(queue.dequeue(), is(3));

		assertThat(queue.isEmpty(), is(true));

		queue.enqueue(4);
		queue.enqueue(5);
		assertThat(queue.dequeue(), is(4));
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		assertThat(queue.dequeue(), is(5));
		assertThat(queue.dequeue(), is(6));
		assertThat(queue.getSize(), is(3));
	}

	@Test
	public void popFromEmptyQueue() throws Exception {
		expectedException.expect(NoSuchElementException.class);

		queue.dequeue();
	}

	@Test
	public void getSize() throws Exception {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		assertThat(queue.getSize(), is(3));

		queue.enqueue(4);
		queue.dequeue();
		queue.enqueue(5);
		queue.dequeue();

		assertThat(queue.getSize(), is(3));
	}

	@Test
	public void isEmpty() throws Exception {
		assertThat(queue.isEmpty(), is(true));
	}

}