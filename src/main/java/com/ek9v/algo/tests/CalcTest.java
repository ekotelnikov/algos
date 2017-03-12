package com.ek9v.algo.tests;


import com.ek9v.algo.StackLinkedList;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by user on 24.12.2016.
 */
public class CalcTest {

	public static void main(String[] args) {
		String[] strings = StdIn.readAllStrings();

		StackLinkedList<String> operations = new StackLinkedList<>();
		StackLinkedList<Double> operands = new StackLinkedList<>();
		for (String s : strings) {
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				operations.push(s);
			} else if (s.equals(")")) {
				double o1 = operands.pop();
				double o2 = operands.pop();
				String op = operations.pop();

				double r = calc(o1, o2, op);
				operands.push(r);
			} else if (!s.equals("(")) {
				operands.push(Double.valueOf(s));
			}
		}

		while (!operations.isEmpty()) {
			double o1 = operands.pop();
			double o2 = operands.pop();
			String op = operations.pop();
			double r = calc(o1, o2, op);
			operands.push(r);
		}
		System.out.println(operands.pop());
	}

	private static double calc(double o1, double o2, String op) {
		double r = 0;
		switch (op) {
			case "+":
				r = o1 + o2;
				break;
			case "-":
				r = o2 - o1;
				break;
			case "*":
				r = o1 * o2;
				break;
			case "/":
				r = o2 / o1;
				break;
			default:
				throw new UnsupportedOperationException(String.format("Operation %s is not supported.", op));
		}
		return r;
	}

}
