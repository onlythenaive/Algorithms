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
import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.collections.iterators.ItemBinaryNodeIterator;

/**
 * Priority ItemQueue implementation based on item binary tree nodes.
 *
 * @see ItemQueue
 *
 * @version 1.01, 15 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class PriorityItemQueue implements ItemQueue {

    private final NodeModelFactory _factory;

    private int _size;
    private BinaryNodeModel _root;
    
    /**
     * Creates a new instance of PriorityItemQueue.
     *
     * @param factory 
     *
     * @see ItemNodeFactory
     */
    public PriorityItemQueue(NodeModelFactory factory) {
        if (factory == null) {
            throw new NullPointerException("item nodes provider is null");
        }
        _factory = factory;
    }

    @Override
    public ItemModel dequeue() {
        throwExceptionIfEmpty();
            throw new UnsupportedOperationException();        
    }

    @Override
    public void enqueue(ItemModel item) {
        BinaryNodeModel node = _factory.createBinaryNode(item);
        if (isEmpty()) {
            _root = node;
        } else {
            throw new UnsupportedOperationException();        
        }
        _size++;
    }

    @Override
    public ItemModel poll() {
        throwExceptionIfEmpty();
        return _root.getItem();
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
    public Iterator<ItemModel> iterator() {
        return new ItemBinaryNodeIterator(_root);
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
    }
}
