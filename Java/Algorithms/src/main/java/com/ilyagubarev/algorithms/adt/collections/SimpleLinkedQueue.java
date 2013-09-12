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
package com.ilyagubarev.algorithms.adt.collections;

import java.util.Iterator;

/**
 * Simple ItemsQueue implementation based on a linked list.
 *
 * @see ItemsQueue
 *
 * @version 1.01, 03 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleLinkedQueue<E> implements ItemsQueue<E> {

    private int _size;
    private ListNode<E> _head;
    private ListNode<E> _tail;

    /**
     * Creates a new instance os SimpleLinkedQueue.
     */
    public SimpleLinkedQueue() {

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
    public E dequeue() {
        throwExceptionIfEmpty();
        E result = _head.getItem();
        _head = _head.getNext();
        --_size;
        return result;
        
    }

    @Override
    public void enqueue(E item) {
        ListNode<E> node = new ListNode<E>(item);
        if (isEmpty()) {
            _tail = node;
            _head = node;
        } else {
            _tail.setNext(node);
            _tail = node;
        }
        ++_size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListNodeIterator<E>(_head);
    }

    @Override
    public E poll() {
        throwExceptionIfEmpty();
        return _head.getItem();
    }

    @Override
    public String toString() {
        return String.format("[simple linked queue: %d items]", _size);
    }   

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
    }
}
