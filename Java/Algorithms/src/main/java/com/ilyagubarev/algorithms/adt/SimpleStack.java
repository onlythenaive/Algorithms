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
 * Simple FIFO policy collection.
 *
 * @see Iterable
 * @see Serializable
 *
 * @version 1.02, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public class SimpleStack<E> implements Iterable<E>, Serializable {

    private int _size;
    private ListNode<E> _top;

    /**
     * Creates a new instance of SimpleStack.
     */
    public SimpleStack() {

    }

    @Override
    public Iterator<E> iterator() {
        return new ListNodeIterator<E>(_top);
    }

    /**
     * Gets current stack size.
     *
     * @return current size.
     */
    public int getSize() {
        return _size;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty.
     */
    public boolean isEmpty() {
        return _size == 0;
    }

    /**
     * Gets top stack item.
     *
     * @return top stack item.
     * @throws IllegalStateException if the stack is empty.
     */
    public E peek() {
        throwExceptionIfEmpty();
        return _top.getItem();
    }

    /**
     * Gets top stack item and removes it from the stack.
     *
     * @return top stack item.
     * @throws IllegalStateException if the stack is empty.
     */
    public E pop() {
        throwExceptionIfEmpty();
        ListNode<E> buffer = _top;
        _top = _top.getNext();
        --_size;
        return buffer.getItem();
    }

    /**
     * Pushes a new item to the stack.
     *
     * @param item an item to be pushed.
     */
    public void push(E item) {
        ListNode<E> buffer = _top;
        _top = new SingleLinkedNode<E>(item);
        _top.setNext(buffer);
        ++_size;
    }

    @Override
    public String toString() {
        return String.format("[simple stack: %d items]", _size);
    }        

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }
}
