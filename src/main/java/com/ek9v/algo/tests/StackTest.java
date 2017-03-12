package com.ek9v.algo.tests;

import com.ek9v.algo.FixedCapacityStack;

/**
 * Created by user on 24.12.2016.
 */
public class StackTest {

	public static void main(String[] args) {
		FixedCapacityStack<String> stringStack = new FixedCapacityStack<>();
		stringStack.push("a");
		stringStack.push("b");
		stringStack.push("c");
		stringStack.push("d");
		stringStack.push("e");

		System.out.println(String.format("StackLinkedList size is %s", stringStack.getSize()));
		for (String value : stringStack ) {
			System.out.println(value);
		}
		System.out.println(stringStack.pop());
		System.out.println(stringStack.pop());
		System.out.println(stringStack.pop());
		System.out.println(stringStack.pop());
	}

}
