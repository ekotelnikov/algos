package com.ek9v.algo;

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