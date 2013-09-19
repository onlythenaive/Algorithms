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

import com.ilyagubarev.algorithms.adt.Item;
import com.ilyagubarev.algorithms.adt.meters.Counter;

/**
 * Item nodes provider.
 *
 * @version 1.04, 16 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemNodeFactory {

    private final Counter _creations;
    private final Counter _reads;
    private final Counter _writes;
    private final Counter _linkReads;
    private final Counter _linkWrites;

    /**
     * Creates a new instance of ItemNodeFactory.
     *
     * @param creations a counter of item node creations.
     * @param reads a counter of item read operations.
     * @param writes a counter of item write operations.
     * @param linkReads a counter of link read operations.
     * @param linkWrites a counter of link write operations.
     *
     * @see Counter
     */
    public ItemNodeFactory(Counter creations, Counter reads, Counter writes,
            Counter linkReads, Counter linkWrites) {
        if (creations == null) {
            throw new NullPointerException("creations counter is null");
        }   
        if (reads == null) {
            throw new NullPointerException("reads counter is null");            
        }
        if (writes == null) {
            throw new NullPointerException("writes counter is null");            
        }
        if (linkReads == null) {
            throw new NullPointerException("link reads counter is null");            
        }        
        if (linkWrites == null) {
            throw new NullPointerException("link writes counter is null");            
        }        
        _creations = creations;
        _reads = reads;
        _writes = writes;
        _linkReads = linkReads;
        _linkWrites = linkWrites;
    }

    /**
     * Creates a new instance of ItemBinaryNode.
     *
     * @param item an item to be contained in the node.
     * @return a new instance of ItemBinaryNode.
     *
     * @see Item
     * @see ItemBinaryNode
     */
    public ItemBinaryNode createBinaryNode(Item item) {
        _creations.increment();
        return new ItemBinaryNode(item, _reads, _writes, _linkReads,
                _linkWrites);
    }

    /**
     * Creates a new instance of ItemListNode.
     *
     * @param item an item to be contained in the node.
     * @return a new instance of ItemListNode.
     *
     * @see Item
     * @see ItemListNode
     */
    public ItemListNode createListNode(Item item) {
        _creations.increment();
        return new ItemListNode(item, _reads, _writes, _linkReads, _linkWrites);
    }
}
