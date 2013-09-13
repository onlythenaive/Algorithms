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
import com.ilyagubarev.algorithms.adt.tools.Registry;

/**
 * Provider of items, item nodes and item arrays.
 *
 * @version 1.02, 13 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemFactory {

    private final Registry _arrayAllocations;
    private final Counter _itemAllocations;
    private final Counter _nodeAllocations;

    /**
     * Creates a new instance of ItemFactory.
     *
     * @param arrayAllocations a registry of item array allocations.
     * @param itemAllocations a counter of item allocations.
     * @param nodeAllocations a counter of item node allocations.
     *
     * @see Counter
     * @see Registry
     */
    public ItemFactory(Registry arrayAllocations, Counter itemAllocations,
            Counter nodeAllocations) {
        if (arrayAllocations == null) {
            throw new NullPointerException("array allocs registry is null");
        }
        if (itemAllocations == null) {
            throw new NullPointerException("item allocs counter is null");
        }
        if (nodeAllocations == null) {
            throw new NullPointerException("node allocs counter is null");
        }
        _itemAllocations = itemAllocations;
        _arrayAllocations = arrayAllocations;
        _nodeAllocations = nodeAllocations;
    }

    /**
     * Creates a new instance of ItemArray of specified size.
     *
     * @param size a size of the array.
     * @param reads a counter of array read operations.
     * @param writes a counter of array write operations.
     * @return a new instance of ItemArray.
     * @throws IllegalArgumentException is specified size is negative.
     *
     * @see Counter
     * @see ItemArray
     */
    public ItemArray allocate(int size, Counter reads, Counter writes) {
        if (size < 0) {
            throw new IllegalArgumentException("array size is negative");
        }
        if (reads == null) {
            throw new NullPointerException("reads counter is null");            
        }
        if (writes == null) {
            throw new NullPointerException("writes counter is null");            
        }
        _arrayAllocations.add(size);
        return new ItemArray(size, reads, writes);
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     *
     * @see Item
     */
    public Item create(int source) {
        _itemAllocations.increment();
        return new Item(source);
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     *
     * @see Item
     */
    public Item create(double source) {
        _itemAllocations.increment();
        return new Item(source);
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     *
     * @see Item
     */
    public Item create(String source) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        _itemAllocations.increment();
        return new Item(source);
    }

    /**
     * Creates a new instance of ItemNode.
     *
     * @param item an item to be contained in the node.
     * @param reads a counter of item read operations.
     * @param linkReads a counter of link read operations.
     * @param linkWrites a counter of link write operations.
     * @return a new instance of ItemNode.
     *
     * @see Counter
     * @see Item
     * @see ItemNode
     */
    public ItemNode createNode(Item item, Counter reads, Counter linkReads,
            Counter linkWrites) {
        if (reads == null) {
            throw new NullPointerException("reads counter is null");            
        }
        if (linkReads == null) {
            throw new NullPointerException("link reads counter is null");            
        }        
        if (linkWrites == null) {
            throw new NullPointerException("link writes counter is null");            
        }        
        _nodeAllocations.increment();
        return new ItemNode(item, reads, linkReads, linkWrites);
    }
}
