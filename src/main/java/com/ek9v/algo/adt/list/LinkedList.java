package com.ek9v.algo.adt.list;

import sun.awt.util.IdentityArrayList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by user on 02.09.2017.
 */
public class LinkedList<T> {

    private int count = 0;
    private Link<T> head;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        count++;
        if (head == null) {
            head = new Link<>(value);
            return;
        }
        append(value);
    }

    private void append(T value) {
        Link<T> link = head;
        while (link.next != null) {
            link = link.next;
        }
        link.next = new Link<>(value);
    }

    private void add(T value, Link<T> link) {
        if (link.next != null) {
            add(value, link.next);
        } else {
            link.next = new Link<>(value);
        }
    }

    public void push(T value) {
        Link<T> link = new Link<>(value);
        link.next = head;
        head = link;
    }

    public int getSize() {
        return count;
    }

    public String toString() {
        return printLink(head);
    }

    private String printLink(Link<T> link) {
        if (link == null) {
            return "null";
        } else {
            return link.value + "->" + printLink(link.next);
        }
    }

    public Iterator<T> getIterator() {
        return new LinkedListIterator(head);
    }

    public void delete(int index) {
        head = delete(head, index);
    }

    private Link<T> delete(Link<T> head, int index) {
        int count = 1;
        Link<T> prev = null;
        Link<T> link = head;
        while (count < index) {
            prev = link;
            link = link.next;
            count++;
        }
        if (prev != null) {
            prev.next = link.next;
        } else {
            head = link.next;
        }
        return head;
    }

    public void insert(int afterIndex, Link<T> insertedLink) {
        Link<T> nLink = getLink(afterIndex);
        insertedLink.next = nLink.next;
        nLink.next = insertedLink;
    }

    public Link<T> getLink(int index) {
        int count = 1;
        Link<T> link = head;
        while (count < index) {
            link = link.next;
            count++;
        }
        return link;
    }

    public void deleteLoop() {
        Set<Link> links = new HashSet<>();
        Link<T> link = head;
        Link<T> prev = null;
        while (!links.contains(link)) {
            links.add(link);
            prev = link;
            link = link.next;
        }
        if (prev != null) {
            prev.next = null;
        }
    }

    static class Link<U> {

        Link<U> next;

        private U value;

        public Link(U value) {
            this.value = value;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        private Link<T> current;

        public LinkedListIterator(Link<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null && current.next != null;
        }

        @Override
        public T next() {
            T value = current == null ? null : current.value;
            if (current != null) {
                current = current.next;
            }
            return value;
        }
    }
}
