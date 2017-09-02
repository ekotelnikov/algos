package com.ek9v.algo.tests;

import com.ek9v.algo.adt.QueueLinkedList;

/**
 * Created by user on 24.12.2016.
 */
public class QueueTest {

	public static void main(String[] args) {
		QueueLinkedList<String> stringQueue = new QueueLinkedList<>();
		stringQueue.enqueue("a");
		stringQueue.enqueue("b");
		stringQueue.enqueue("c");
		stringQueue.enqueue("d");
		stringQueue.enqueue("e");

		System.out.println(String.format("QueueLinkedList size is %s", stringQueue.getSize()));
//		for (String value : stringQueue ) {
//			System.out.println(value);
//		}
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());


	}

}
