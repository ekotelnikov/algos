package com.ek9v.coursera.disjoinSet;

import com.ek9v.coursera.disjoinSet.MergingTables.Table;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 18.10.2017.
 */
public class TableTest {
    @Test
    public void getParent() throws Exception {
        Table t0 = new Table(1);
        Table t1 = new Table(1);
        Table t2 = new Table(1);
        Table t3 = new Table(1);

        t1.parent = t0;
        t2.parent = t1;
        t3.parent = t1;

        assertEquals(t1.getParent(), t0);
        assertEquals(t2.getParent(), t0);
        assertEquals(t3.getParent(), t0);
    }

    @Test
    public void mergeTables5Tables() throws Exception {
        Table[] tables = new Table[5];
        tables[0] = new Table(1);
        tables[1] = new Table(1);
        tables[2] = new Table(1);
        tables[3] = new Table(1);
        tables[4] = new Table(1);

        MergingTables mergingTables = new MergingTables(null, null);

        mergingTables.merge(tables[2], tables[4]);
        assertEquals(mergingTables.maximumNumberOfRows, 2);

        mergingTables.merge(tables[1], tables[3]);
        assertEquals(mergingTables.maximumNumberOfRows, 2);

        mergingTables.merge(tables[0], tables[3]);
        assertEquals(mergingTables.maximumNumberOfRows, 3);

        mergingTables.merge(tables[4], tables[3]);
        assertEquals(mergingTables.maximumNumberOfRows, 5);

        mergingTables.merge(tables[4], tables[2]);
        assertEquals(mergingTables.maximumNumberOfRows, 5);

    }

    @Test
    public void mergeTables6Tables() throws Exception {
        Table[] tables = new Table[6];
        tables[0] = new Table(10);
        tables[1] = new Table(0);
        tables[2] = new Table(5);
        tables[3] = new Table(0);
        tables[4] = new Table(3);
        tables[5] = new Table(3);

        MergingTables mergingTables = new MergingTables(null, null);
        mergingTables.maximumNumberOfRows = 10;

        mergingTables.merge(tables[5], tables[5]);
        assertEquals(mergingTables.maximumNumberOfRows, 10);

        mergingTables.merge(tables[5], tables[4]);
        assertEquals(mergingTables.maximumNumberOfRows, 10);

        mergingTables.merge(tables[4], tables[3]);
        assertEquals(mergingTables.maximumNumberOfRows, 10);

        mergingTables.merge(tables[3], tables[2]);
        assertEquals(mergingTables.maximumNumberOfRows, 11);
    }
}