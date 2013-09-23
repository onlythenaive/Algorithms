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

import java.util.Comparator;
import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.collections.QueueModel;
import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.iterators.BinaryNodeInOrderIterator;

/**
 * Priority ModelQueue implementation based on binary tree node model.
 *
 * @see QueueModel
 *
 * @version 1.03, 20 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class PriorityLinkedQueueModel<T> implements QueueModel<T> {

    private final Comparator<T> _comparator;
    private final NodeModelFactory _factory;

    private int _size;
    private BinaryNodeModel<T> _root;
    
    /**
     * Creates a new instance of PriorityLinkedQueueModel.
     *
     * @param comparator an item comparator.
     * @param factory node model provider.
     *
     * @see NodeModelFactory
     */
    public PriorityLinkedQueueModel(Comparator<T> comparator,
            NodeModelFactory factory) {
        if (factory == null) {
            throw new NullPointerException("item nodes provider is null");
        }
        _comparator = comparator;
        _factory = factory;
    }

    @Override
    public T dequeue() {
        throwExceptionIfEmpty();
        T result = _root.getItem();
        if (_size == 1) {
            _root = null;
        } else {
            _root.setItem(removeLeaf());
            sink(_root);
        }
        _size--;
        return result;
    }

    @Override
    public void enqueue(T item) {
        _size++;
        if (_size == 1) {
            _root = _factory.createBinaryNode(item);
        } else {
            surface(createLeaf(item));
        }
    }

    @Override
    public T poll() {
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
    public Iterator<T> iterator() {
        return new BinaryNodeInOrderIterator<T>(_root, _factory);
    }

    private BinaryNodeModel<T> getLeafParent() {
        BinaryNodeModel<T> result = _root;
        int items = 0;
        int level = 0;
        int levelMaxItems = 1;
        while ((items + levelMaxItems) < _size) {
            items += levelMaxItems;
            levelMaxItems *= 2;
            level++;
        }
        int itemsOnLevel = _size - items;
        while (level > 1) {
            levelMaxItems /= 2;
            if (itemsOnLevel > levelMaxItems) {
                result = result.getRightChild();
                itemsOnLevel -= levelMaxItems;
            } else {
                result = result.getLeftChild();
            }
            level--;
        }
        return result;
    }

    private int compare(T first, T second) {
        if (_comparator != null) {
            return _comparator.compare(first, second);
        } else {
            return ((Comparable) first).compareTo(second);
        }
    }

    private BinaryNodeModel<T> createLeaf(T item) {
        BinaryNodeModel<T> result = _factory.createBinaryNode(item);
        BinaryNodeModel<T> parent = getLeafParent();
        if (parent.getLeftChild() == null) {
            parent.setLeftChild(result);
        } else {
            parent.setRightChild(result);
        }
        result.setParent(parent);
        return result;
    }

    private T removeLeaf() {
        BinaryNodeModel<T> parent = getLeafParent();
        BinaryNodeModel<T> result = parent.getRightChild();
        if (result == null) {
            result = parent.getLeftChild();
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
        result.setParent(null);
        return result.getItem();
    }

    private void sink(BinaryNodeModel<T> node) {
        BinaryNodeModel<T> leftChild = node.getLeftChild();
        if (leftChild == null) {
            return;
        }
        T item = node.getItem();
        T leftItem = leftChild.getItem();
        BinaryNodeModel<T> rightChild = node.getRightChild();
        if (rightChild == null) {
            if (compare(leftItem, item) > 0) {
                leftChild.setItem(item);
                node.setItem(leftItem);
                sink(leftChild);
            }
        } else {
            T rightItem = rightChild.getItem();
            boolean leftIsGreater = compare(leftItem, item) > 0;
            boolean rightIsGreater = compare(rightItem, item) > 0;
            if (leftIsGreater || rightIsGreater) {
                if (leftIsGreater) {
                    leftChild.setItem(item);
                    node.setItem(leftItem);
                    sink(leftChild);
                } else {
                    rightChild.setItem(item);
                    node.setItem(rightItem);
                    sink(rightChild);
                }
            }
        }
    }

    private void surface(BinaryNodeModel<T> node) {
        BinaryNodeModel<T> parent = node.getParent();
        if (parent != null) {
            T item  = node.getItem();
            T parentItem = parent.getItem();
            if (compare(item, parentItem) > 0) {
                parent.setItem(item);
                node.setItem(parentItem);
                surface(parent);
            }
        }
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
    }
}
