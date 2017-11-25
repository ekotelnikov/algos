package com.ek9v.coursera.hashing;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 24.10.2017.
 */
public class HashChainsTest {

    @Test
    public void shouldReturnNotEmptyList_whenAddElements() throws Exception {
        HashChains chains = new HashChains();
        chains.setBucketCount(5);
        chains.initializeHashTable();
        chains.add("string1");
        chains.add("world");
        chains.add("Hell0");
        assertThat(chains.check(4), is("Hell0 world"));
    }

    @Test
    public void shouldFindElement_whenItIsAdded() throws Exception {
        HashChains chains = new HashChains();
        chains.setBucketCount(5);
        chains.initializeHashTable();
        chains.add("string1");
        chains.add("world");
        chains.add("Hell0");

        assertThat(chains.find("test"), is(false));
        assertThat(chains.find("string1"), is(true));
        assertThat(chains.find("world"), is(true));
    }

    @Test
    public void shouldReturnEmptString_whenElementDeleted() throws Exception {
        HashChains chains = new HashChains();
        chains.setBucketCount(5);
        chains.initializeHashTable();
        chains.add("string1");
        assertThat(chains.check(1), is("string1"));
        chains.delete("string1");
        assertThat(chains.check(1), is(""));
    }

    @Test
    public void shouldContainOneElement_whenElementAddedTwice() throws Exception {
        HashChains chains = new HashChains();
        chains.setBucketCount(5);
        chains.initializeHashTable();
        chains.add("string1");
        chains.add("string1");
        assertThat(chains.check(1), is("string1"));
    }
}