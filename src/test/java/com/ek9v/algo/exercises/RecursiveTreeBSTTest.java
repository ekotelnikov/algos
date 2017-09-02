package com.ek9v.algo.exercises;

import com.ek9v.algo.adt.RecursiveTreeBST;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by user on 15.01.2017.
 */
public class RecursiveTreeBSTTest {
	@Test
	public void add() throws Exception {
		TreeSet s = new TreeSet();

		int[] a = new int[] {5,4,1,1,7,3,8};

		System.out.println(Arrays.binarySearch(a, 0));

		RecursiveTreeBST bst = RecursiveTreeBST.valueOf(a);

		bst.print();
		System.out.println(bst.distance(3));
	}

	private static int findRoot(int[] values, int node1) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] == node1) {
				return i;
			}
		}
		return -1;
	}

//	public static int bstDistance(int[] values, int n, int node1, int node2)
//	{
//		// WRITE YOUR CODE HERE
//		int r = Arrays.binarySearch(values, node1);
//		if (r == -1) {
//			return -1;
//		}
//		TreeBST bst = new TreeBST();
//		bst.add(values[r]);
//		for (int i = 0; i < values.length; i++) {
//			if (i != r) {
//				bst.add(values[i]);
//			}
//		}
//
//	}

}