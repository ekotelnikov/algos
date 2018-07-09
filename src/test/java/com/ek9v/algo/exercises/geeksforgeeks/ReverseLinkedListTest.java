package com.ek9v.algo.exercises.geeksforgeeks;

import org.junit.Test;

/**
 * Created by user on 06.07.2018.
 */
public class ReverseLinkedListTest {

  @Test
  public void testReverseList() throws Exception {
    Node head = LinkedListUtils.createLinkedList(5);
    LinkedListUtils.print(head);

    Node rev = LinkedListUtils.reverseList(head);
    System.out.println();
    LinkedListUtils.print(rev);
  }
}
