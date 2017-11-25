package com.ek9v.coursera.hashing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 24.10.2017.
 */
public class PhoneBookTest {

    @Test
    public void processQuery_directAddressing() throws Exception {
        PhoneBook pb = new PhoneBook();
        pb.initContacts();
        PhoneBook.Query addOne = new PhoneBook.Query("add", "Name1", 999_999_9);
        PhoneBook.Query addTwo = new PhoneBook.Query("add", "Name2", 1);
        pb.processQueryFast(addOne);
        pb.processQueryFast(addTwo);
        PhoneBook.Query addThree = new PhoneBook.Query("add", "Name3", 9_999_999);
        pb.processQueryFast(addThree);
        PhoneBook.Query findOne = new PhoneBook.Query("find", 999_999_9);
        PhoneBook.Query delQuery = new PhoneBook.Query("del", 1);
        pb.processQueryFast(delQuery);
        PhoneBook.Query findTwo = new PhoneBook.Query("find", 1);
        pb.processQueryFast(findTwo);
        pb.processQueryFast(findOne);
    }
}