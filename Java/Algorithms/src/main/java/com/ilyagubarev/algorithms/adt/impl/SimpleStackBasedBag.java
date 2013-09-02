/*
 * Copyright 2013 gubarev.
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
package com.ilyagubarev.algorithms.adt.impl;

import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.Bag;
import com.ilyagubarev.algorithms.adt.Stack;

/**
 * Bag implementation based on simple linked stack.
 *
 * @see Iterable
 * @see Serializable
 *
 * @version 1.01, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleStackBasedBag<E> implements Bag<E> {

    private Stack<E> _stack;

    /**
     * Creates a new instance of SimpleStackBasedBag
     */
    public SimpleStackBasedBag() {
        _stack = new SimpleLinkedStack<E>();
    }

    @Override
    public int getSize() {
        return _stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return _stack.isEmpty();
    }

    @Override
    public void add(E item) {
        _stack.push(item);
    }

    @Override
    public Iterator<E> iterator() {
        return _stack.iterator();
    }
}
