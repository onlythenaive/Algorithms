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

import com.ilyagubarev.algorithms.adt.ItemModel;
import com.ilyagubarev.algorithms.adt.nodes.ListNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.collections.iterators.ItemListNodeIterator;

/**
 * Simple ItemQueue implementation based on item list nodes.
 *
 * @see ItemQueue
 *
 * @version 1.01, 15 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleItemQueue implements ItemQueue {

    private final NodeModelFactory _factory;

    private int _size;
    private ListNodeModel _newest;
    private ListNodeModel _oldest;

    /**
     * Creates a new instance of SimpleItemQueue.
     *
     * @param factory 
     *
     * @see ItemNodeFactory
     */
    public SimpleItemQueue(NodeModelFactory factory) {
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
    public ItemModel dequeue() {
        throwExceptionIfEmpty();
        ItemModel result = _oldest.getItem();
        _oldest = _oldest.getNext();
        _size--;
        return result;
    }

    @Override
    public void enqueue(ItemModel item) {
        ListNodeModel node = _factory.createListNode(item);
        if (isEmpty()) {
            _oldest = node;
        } else {
            _newest.setNext(node);
        }
        _newest = node;
        _size++;
    }

    @Override
    public Iterator<ItemModel> iterator() {
        return new ItemListNodeIterator(_oldest);
    }

    @Override
    public ItemModel poll() {
        throwExceptionIfEmpty();
        return _oldest.getItem();
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
    }
}
