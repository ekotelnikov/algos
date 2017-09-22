package com.ek9v.coursera.greedy;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 20.09.2017.
 */
public class LargestNumberTest {
    @Test
    public void largestNumber_2_21() throws Exception {
        assertThat(LargestNumber.largestNumber(new String[] {"2", "21"}), is("221"));
    }

    @Test
    public void largestNumber_23_3() throws Exception {
        assertThat(LargestNumber.largestNumber(new String[] {"23", "3"}), is("323"));
    }

    @Test
    public void largestNumber_94619() throws Exception {
        assertThat(LargestNumber.largestNumber(new String[] {"9", "4", "6", "1", "9"}), is("99641"));
    }

}