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

import com.ilyagubarev.algorithms.adt.meters.Counter;

/**
 * Item binary tree node.
 *
 * @version 1.02, 16 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class ItemBinaryNode {

    private final Counter _reads;
    private final Counter _writes;
    private final Counter _linkReads;
    private final Counter _linkWrites;

    private Item _item;
    private ItemBinaryNode _leftChild;
    private ItemBinaryNode _rightChild;
    private ItemBinaryNode _parent;

    ItemBinaryNode(Item item, Counter reads, Counter writes,
            Counter linkReads, Counter linkWrites) {
        _item = item;
        _reads = reads;
        _writes = writes;
        _linkReads = linkReads;
        _linkWrites = linkWrites;
    }

    /**
     * Gets a contained item.
     *
     * @return contained item.
     *
     * @see Item
     */
    public Item getItem() {
        _reads.increment();
        return _item;
    }

    /**
     * Gets a reference to the left child node.
     *
     * @return the left child node.
     */
    public ItemBinaryNode getLeftChild() {
        _linkReads.increment();
        return _leftChild;
    }

    /**
     * Gets a reference to the right child node.
     *
     * @return the right child node.
     */

    public ItemBinaryNode getRightChild() {
        _linkReads.increment();
        return _rightChild;
    }

    /**
     * Gets a reference to the parent node.
     *
     * @return the parent node.
     */
    public ItemBinaryNode getParent() {
        _linkReads.increment();
        return _parent;
    }

    /**
     * Sets a new contained item.
     *
     * @param item an item to be contained.
     *
     * @see Item
     */
    public void setItem(Item item) {
        _writes.increment();
        _item = item;
    }

    /**
     * Sets a reference to the left child node.
     *
     * @param node the left child node.
     */
    public void setLeftChild(ItemBinaryNode node) {
        _linkWrites.increment();
        _leftChild = node;
    }

    /**
     * Sets a reference to the right child node.
     *
     * @param node the right child node.
     */
    public void setRightChild(ItemBinaryNode node) {
        _linkWrites.increment();
        _rightChild = node;
    }

    /**
     * Sets a reference to the parent node.
     *
     * @param node the parent node.
     */
    public void setParent(ItemBinaryNode node) {
        _linkWrites.increment();
        _parent = node;
    }

    @Override
    public String toString() {
        return String.format("[item binary node: %s]", _item);
    }
}
