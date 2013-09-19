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
package com.ilyagubarev.algorithms.adt.collections.queues;

import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.ItemModel;
import com.ilyagubarev.algorithms.adt.collections.QueueModel;
import com.ilyagubarev.algorithms.adt.nodes.ListNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.iterators.ListNodeModelIterator;

/**
 * Simple ItemModel implementation based on list node models.
 *
 * @see ItemQueue
 *
 * @version 1.02, 19 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleQueueModel<E> implements QueueModel<E> {

    private final NodeModelFactory _factory;

    private int _size;
    private ListNodeModel<E> _newest;
    private ListNodeModel<E> _oldest;

    /**
     * Creates a new instance of SimpleQueueModel.
     *
     * @param factory 
     *
     * @see NodeModelFactory
     */
    public SimpleQueueModel(NodeModelFactory factory) {
        if (factory == null) {
            throw new NullPointerException("item nodes provider is null");
        }
        _factory = factory;
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
        E result = _oldest.getItem();
        _oldest = _oldest.getNext();
        _size--;
        return result;
    }

    @Override
    public void enqueue(E item) {
        ListNodeModel<E> node = _factory.createListNode(item);
        if (isEmpty()) {
            _oldest = node;
        } else {
            _newest.setNext(node);
        }
        _newest = node;
        _size++;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListNodeModelIterator<E>(_oldest);
    }

    @Override
    public E poll() {
        throwExceptionIfEmpty();
        return _oldest.getItem();
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
    }
}
