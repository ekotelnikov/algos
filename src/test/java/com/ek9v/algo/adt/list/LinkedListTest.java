package com.ek9v.algo.adt.list;

import com.ek9v.algo.adt.list.LinkedList.Link;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 02.09.2017.
 */
public class LinkedListTest {

    @Test
    public void createList_returnEmptyList() throws Exception {
        TreeMap<Double, String> map = new TreeMap<>();
        map.put(3., "3");
        map.put(1., "1");
        map.put(4., "4");
        map.put(0., "0");
        map.values();
        map.descendingMap().values();

        System.out.println(map.values());
        System.out.println(map.descendingMap().values());

        LinkedList<Integer> list = new LinkedList<>();
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void createOneElementList_returnNonEmptyList() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void shouldHasSize2_for2ElementsList() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertThat(list.getSize(), is(2));
    }

    @Test
    public void nextShouldReturnElement_whatWasPutBefore() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.getIterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }

    @Test
    public void shouldPrintList() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
        assertThat(list.toString(), is("1->2->3->null"));
    }

    @Test
    public void pushElement() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        assertThat(list.toString(), is("3->2->1->null"));
    }

    @Test
    public void deleteNthNode() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(3);
        list.push(4);
        list.push(5);
        list.delete(2);
        assertThat(list.toString(), is("5->3->null"));
    }

    @Test
    public void deleteFirstNode() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(3);
        list.push(4);
        list.push(5);
        list.delete(1);
        assertThat(list.toString(), is("4->3->null"));
    }

    @Test
    public void deleteLastNode() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(3);
        list.push(4);
        list.push(5);
        list.delete(3);
        assertThat(list.toString(), is("5->4->null"));
    }

    @Test
    public void deleteSingleNode() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(3);
        list.delete(1);
        assertThat(list.toString(), is("null"));
    }

    @Test
    public void insertNode() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.insert(2, new Link<>(4));
        assertThat(list.toString(), is("1->2->4->3->null"));
        list.insert(4, new Link<>(5));
        assertThat(list.toString(), is("1->2->4->3->5->null"));
    }

    @Test
    public void deleteLoop() throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Link<Integer> loop = new Link<>(4);
        loop.next = list.getLink(2);
        list.getLink(3).next = loop;
        list.deleteLoop();
        assertThat(list.toString(), is("1->2->3->4->null"));
    }
}