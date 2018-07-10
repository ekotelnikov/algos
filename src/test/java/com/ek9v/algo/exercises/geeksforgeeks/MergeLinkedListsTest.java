package com.ek9v.algo.exercises.geeksforgeeks;

import org.junit.Test;

/**
 * Created by user on 06.07.2018.
 */
public class MergeLinkedListsTest {

  @Test
  public void testMergeSortedLinkedLists() throws Exception {
    Node n = LinkedListUtils.createLinkedList(1, 3, 5, 7);
    Node p = LinkedListUtils.createLinkedList(2, 4, 6, 8);

    Node m = merge(n, p);
    LinkedListUtils.print(m);
    System.out.println();
    Node a = recursiveMerge(n, p);
    LinkedListUtils.print(a);
    System.out.println();

    n = LinkedListUtils.createLinkedList(1);
    p = LinkedListUtils.createLinkedList(2);

    m = merge(n, p);
    LinkedListUtils.print(m);
    System.out.println();

    n = LinkedListUtils.createLinkedList(1);
    p = LinkedListUtils.createLinkedList(1);

    m = merge(n, p);
    LinkedListUtils.print(m);
    System.out.println();
  }

  private Node recursiveMerge(Node a, Node b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    Node result;
    if (a.value <= b.value) {
      result = a;
      result.next = recursiveMerge(a.next, b);
    } else {
      result = b;
      result.next = recursiveMerge(a, b.next);
    }
    return result;
  }

  private Node merge(Node n, Node p) {
    Node n1 = n;
    Node p1 = p;
    Node prev = null;
    while (n1 != null && p1 != null) {
      while (n1 != null && n1.value <= p1.value) {
        prev = n1;
        n1 = n1.next;
      }
      if (prev != null) {
        prev.next = p1;
      }
      while (p1 != null && n1 != null && p1.value <= n1.value) {
        prev = p1;
        p1 = p1.next;
      }
      if (prev != null && n1 != null) {
        prev.next = n1;
      }
    }

    return n.value < p.value ? n : p;
  }
}
