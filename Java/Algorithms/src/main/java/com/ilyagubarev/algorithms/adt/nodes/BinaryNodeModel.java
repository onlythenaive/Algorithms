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
package com.ilyagubarev.algorithms.adt.nodes;

import com.ilyagubarev.algorithms.adt.utils.Counter;

/**
 * Binary tree node model.
 *
 * @see NodeModel
 *
 * @version 1.04, 24 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class BinaryNodeModel<T> extends NodeModel<T> {

    private final Counter _linkReads;
    private final Counter _linkWrites;

    private BinaryNodeModel<T> _leftChild;
    private BinaryNodeModel<T> _rightChild;
    private BinaryNodeModel<T> _parent;

    BinaryNodeModel(T item, Counter reads, Counter writes,
            Counter linkReads, Counter linkWrites) {
        super(item, reads, writes);
        _linkReads = linkReads;
        _linkWrites = linkWrites;
    }

    /**
     * Gets a reference to the left child node.
     *
     * @return the left child node.
     */
    public BinaryNodeModel<T> getLeftChild() {
        throwExceptionIfDestructed();
        _linkReads.increment();
        return _leftChild;
    }

    /**
     * Gets a reference to the right child node.
     *
     * @return the right child node.
     */

    public BinaryNodeModel<T> getRightChild() {
        throwExceptionIfDestructed();
        _linkReads.increment();
        return _rightChild;
    }

    /**
     * Gets a reference to the parent node.
     *
     * @return the parent node.
     */
    public BinaryNodeModel<T> getParent() {
        throwExceptionIfDestructed();
        _linkReads.increment();
        return _parent;
    }

    /**
     * Sets a reference to the left child node.
     *
     * @param node the left child node.
     */
    public void setLeftChild(BinaryNodeModel<T> node) {
        throwExceptionIfDestructed();
        _linkWrites.increment();
        _leftChild = node;
    }

    /**
     * Sets a reference to the right child node.
     *
     * @param node the right child node.
     */
    public void setRightChild(BinaryNodeModel<T> node) {
        throwExceptionIfDestructed();
        _linkWrites.increment();
        _rightChild = node;
    }

    /**
     * Sets a reference to the parent node.
     *
     * @param node the parent node.
     */
    public void setParent(BinaryNodeModel<T> node) {
        throwExceptionIfDestructed();
        _linkWrites.increment();
        _parent = node;
    }

    @Override
    public String toString() {
        throwExceptionIfDestructed();
        return String.format("[binary node: %s]", getItem());
    }

    @Override
    protected int getMemoryAllocation() {
        return 4;
    }
}
