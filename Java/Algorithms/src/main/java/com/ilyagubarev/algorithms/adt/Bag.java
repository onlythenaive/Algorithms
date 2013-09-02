/*
 * Copyright 2013 Ilya Gubarev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ilyagubarev.algorithms.adt;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Simple collection not supporting items removal.
 *
 * @see Iterable
 * @see Serializable
 *
 * @version 1.01, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class Bag<E> implements Iterable<E>, Serializable {

    private ListNode<E> _head;

    /**
     * Creates a new instance of Bag.
     */
    public Bag() {

    }

    /**
     * Adds a new item to the bag.
     *
     * @param item a new item.
     */
    public void add(E item) {
        ListNode<E> buffer = _head;
        _head = new SingleLinkedNode<E>(item);
        _head.setNext(buffer);
    }

    @Override
    public Iterator<E> iterator() {
        return new ListNodeIterator<E>(_head);
    }
}
