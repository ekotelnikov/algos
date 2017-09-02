package com.ek9v.patterns.phantomRef;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by user on 24.06.2017.
 */
public class PhantomRefExample extends PhantomReference {
    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     * <p>
     * <p> It is possible to create a phantom reference with a <tt>null</tt>
     * queue, but such a reference is completely useless: Its <tt>get</tt>
     * method will always return null and, since it does not have a queue, it
     * will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     */
    public PhantomRefExample(Object referent, ReferenceQueue q) {
        super(referent, q);
    }
}
