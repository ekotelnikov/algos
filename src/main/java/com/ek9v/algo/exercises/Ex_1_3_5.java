package com.ek9v.algo.exercises;

import com.ek9v.algo.FixedCapacityStack;
import com.ek9v.algo.Stack;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by user on 25.12.2016.
 */
public class Ex_1_3_5 {

	public static void main(String[] args) {
		int n = 50;
		print(getBinary(n));
		System.out.println();

		Queue<Integer> q = new Queue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		print(q);
		System.out.println();
		Stack<Integer> s = new FixedCapacityStack<>();
		while (!q.isEmpty()) {
			s.push(q.dequeue());
		}
		while (!s.isEmpty()) {
			q.enqueue(s.pop());
		}
		print(q);

	}

	private static void print(Iterable<Integer> binStackOne) {
		for (Integer d : binStackOne) {
			StdOut.print(d);
		}
	}

	private static Stack<Integer> getBinary(int n) {
		Stack<Integer> binStack = new FixedCapacityStack<>();
		while (n > 0) {
			binStack.push(n%2);
			n = n / 2;
		}
		return binStack;
	}

}
