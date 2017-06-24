package com.ek9v.patterns;

import com.ek9v.patterns.proxy.Foo;
import com.ek9v.patterns.proxy.FooImpl;
import com.ek9v.patterns.proxy.FooInvocationHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by user on 22.06.2017.
 */
public class ProxyExampleTest {

    @Test
    public void testCreateProxy() {
        Foo fooObj = new FooImpl();
        Foo foo = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class},
                new FooInvocationHandler(fooObj));

        foo.sayHello();
    }

}