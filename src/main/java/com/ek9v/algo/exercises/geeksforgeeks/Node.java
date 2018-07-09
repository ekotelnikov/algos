package com.ek9v.algo.exercises.geeksforgeeks;

import com.google.common.base.MoreObjects;
import java.util.Objects;

/**
 * Created by user on 06.07.2018.
 */
public class Node {

  int value;

  Node next;

  public Node(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return value == node.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
