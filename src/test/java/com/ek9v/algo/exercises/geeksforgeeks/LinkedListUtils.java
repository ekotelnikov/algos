package com.ek9v.algo.exercises.geeksforgeeks;

public final class LinkedListUtils {

  private LinkedListUtils() {
  }

  static Node reverseList(Node head) {
    Node prev = null;
    Node cur = head;
    Node next = null;

    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    return prev;
  }

  static Node createLinkedList(int numNodes) {
    Node head = new Node(1);
    Node cur = head;
    for (int i = 2; i <= numNodes; i++) {
      cur.next = new Node(i);
      cur = cur.next;
    }
    ;
    return head;
  }

  static void print(Node node) {
    while (node != null) {
      System.out.print(node + "->");
      node = node.next;
    }
  }

  public static Node createLinkedList(int ... values) {
    Node head = new Node(values[0]);
    Node n = head;
    for (int i = 1; i < values.length; i++) {
      n.next = new Node(values[i]);
      n = n.next;
    }
    return head;
  }
}