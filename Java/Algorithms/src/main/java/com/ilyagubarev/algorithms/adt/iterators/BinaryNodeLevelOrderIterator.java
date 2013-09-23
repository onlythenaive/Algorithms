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
package com.ilyagubarev.algorithms.adt.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.ilyagubarev.algorithms.adt.collections.QueueModel;
import com.ilyagubarev.algorithms.adt.collections.queues.SimpleQueueModel;
import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;

/**
 * Level order iterator over a tree based on binary node models.
 *
 * @see Iterator
 *
 * @version 1.01, 23 September 2013
 * @since 23 September 2013
 * @author Ilya Gubarev
 */
public final class BinaryNodeLevelOrderIterator<T> implements Iterator<T> {

    private final QueueModel<BinaryNodeModel<T>> _queue;

    /**
     * Creates a new instance of BinaryNodeLevelOrderIterator.
     *
     * @param root a root item of the heap.
     * @param factory a factory of node models.
     *
     * @see BinaryNodeModel
     * @see NodeModelFactory
     */
    public BinaryNodeLevelOrderIterator(BinaryNodeModel root,
            NodeModelFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("node factory is null");
        }
        _queue = new SimpleQueueModel<BinaryNodeModel<T>>(factory);
        addNode(root);
    }

    @Override
    public boolean hasNext() {
        return !_queue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("iterator has no next element");
        }
        BinaryNodeModel<T> next = _queue.dequeue();
        addNode(next.getLeftChild());
        addNode(next.getRightChild());
        return next.getItem();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("removal is not supported");
    }

    private void addNode(BinaryNodeModel<T> node) {
        if (node != null) {
            _queue.enqueue(node);
        }
    }
}
