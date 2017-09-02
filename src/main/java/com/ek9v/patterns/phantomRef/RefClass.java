package com.ek9v.patterns.phantomRef;

/**
 * Created by user on 24.06.2017.
 */
public class RefClass {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
