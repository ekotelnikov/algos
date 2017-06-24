package com.ek9v.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by user on 22.06.2017.
 */
public class FooInvocationHandler implements InvocationHandler {

    private final Foo object;

    public FooInvocationHandler(Foo object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking " + method.getName() + ": ");
        return method.invoke(object, args);
    }
}
