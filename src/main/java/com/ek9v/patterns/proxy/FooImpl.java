package com.ek9v.patterns.proxy;

/**
 * Created by user on 22.06.2017.
 */
public class FooImpl implements Foo {
    @Override
    public String sayHello() {
        String s = "Hello!";
        System.out.println(s);
        return s;
    }
}
