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

import com.ilyagubarev.algorithms.adt.tools.Counter;

/**
 * Item linked list node.
 *
 * @version 1.04, 15 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class ItemListNode {

    private final Item _item;
    private final Counter _reads;
    private final Counter _linkReads;
    private final Counter _linkWrites;

    private ItemListNode _next;

    ItemListNode(Item item, Counter reads, Counter linkReads,
            Counter linkWrites) {
        _item = item;
        _reads = reads;
        _linkReads = linkReads;
        _linkWrites = linkWrites;
    }

    /**
     * Gets a containing item.
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
     * Gets a reference to the next node.
     *
     * @return the next node.
     */
    public ItemListNode getNext() {
        _linkReads.increment();
        return _next;
    }

    /**
     * Sets a reference to the next node.
     *
     * @param node the next node.
     */
    public void setNext(ItemListNode node) {
        _linkWrites.increment();
        _next = node;
    }

    @Override
    public String toString() {
        return String.format("[item list node: %s]", _item);
    }
}