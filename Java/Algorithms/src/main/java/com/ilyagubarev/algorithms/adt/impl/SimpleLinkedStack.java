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
package com.ilyagubarev.algorithms.adt.impl;

import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.Stack;

/**
 * Simple implementation of Stack based on linked nodes.
 *
 * @see Stack
 *
 * @version 1.02, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleLinkedStack<E> implements Stack<E> {

    private int _size;
    private SingleLinkedNode<E> _top;

    /**
     * Creates a new instance of SimpleLinkedStack.
     */
    public SimpleLinkedStack() {

    }

    @Override
    public Iterator<E> iterator() {
        return new SingleLinkedNodeIterator<E>(_top);
    }

    @Override
    public int getSize() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public E peek() {
        throwExceptionIfEmpty();
        return _top.getItem();
    }

    @Override
    public E pop() {
        throwExceptionIfEmpty();
        SingleLinkedNode<E> buffer = _top;
        _top = _top.getNext();
        --_size;
        return buffer.getItem();
    }

    @Override
    public void push(E item) {
        SingleLinkedNode<E> buffer = _top;
        _top = new SingleLinkedNode<E>(item);
        _top.setNext(buffer);
        ++_size;
    }

    @Override
    public String toString() {
        return String.format("[simple linked stack: %d items]", _size);
    }        

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }
}
