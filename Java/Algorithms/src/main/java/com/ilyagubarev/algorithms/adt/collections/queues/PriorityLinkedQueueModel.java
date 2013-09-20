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

import com.ilyagubarev.algorithms.adt.collections.QueueModel;
import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.iterators.BinaryNodeModelIterator;

/**
 * Priority ModelQueue implementation based on binary tree node model.
 *
 * @see QueueModel
 *
 * @version 1.03, 20 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class PriorityLinkedQueueModel<E extends Comparable<E>>
        implements QueueModel<E> {

    private final NodeModelFactory _factory;

    private int _size;
    private BinaryNodeModel<E> _root;
    
    /**
     * Creates a new instance of PriorityLinkedQueueModel.
     *
     * @param factory node model provider.
     *
     * @see NodeModelFactory
     */
    public PriorityLinkedQueueModel(NodeModelFactory factory) {
        if (factory == null) {
            throw new NullPointerException("item nodes provider is null");
        }
        _factory = factory;
    }

    @Override
    public E dequeue() {
        throwExceptionIfEmpty();
        E result = _root.getItem();
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
    public void enqueue(E item) {
        _size++;
        if (_size == 1) {
            _root = _factory.createBinaryNode(item);
        } else {
            surface(createLeaf(item));
        }
    }

    @Override
    public E poll() {
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
    public Iterator<E> iterator() {
        return new BinaryNodeModelIterator<E>(_root, _factory);
    }

    private BinaryNodeModel<E> getLeafParent() {
        BinaryNodeModel<E> result = _root;
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

    private BinaryNodeModel<E> createLeaf(E item) {
        BinaryNodeModel<E> result = _factory.createBinaryNode(item);
        BinaryNodeModel<E> parent = getLeafParent();
        if (parent.getLeftChild() == null) {
            parent.setLeftChild(result);
        } else {
            parent.setRightChild(result);
        }
        result.setParent(parent);
        return result;
    }

    private E removeLeaf() {
        BinaryNodeModel<E> parent = getLeafParent();
        BinaryNodeModel<E> result = parent.getRightChild();
        if (result == null) {
            result = parent.getLeftChild();
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
        result.setParent(null);
        return result.getItem();
    }

    private void sink(BinaryNodeModel<E> node) {
        BinaryNodeModel<E> leftChild = node.getLeftChild();
        if (leftChild == null) {
            return;
        }
        E item = node.getItem();
        E leftItem = leftChild.getItem();
        BinaryNodeModel<E> rightChild = node.getRightChild();
        if (rightChild == null) {
            if (leftItem.compareTo(item) > 0) {
                leftChild.setItem(item);
                node.setItem(leftItem);
                sink(leftChild);
            }
        } else {
            E rightItem = rightChild.getItem();
            if (leftItem.compareTo(item) > 0 || rightItem.compareTo(item) > 0) {
                if (leftItem.compareTo(rightItem) > 0) {
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

    private void surface(BinaryNodeModel<E> node) {
        BinaryNodeModel<E> parent = node.getParent();
        if (parent != null) {
            E item  = node.getItem();
            E parentItem = parent.getItem();
            if (item.compareTo(parentItem) > 0) {
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
