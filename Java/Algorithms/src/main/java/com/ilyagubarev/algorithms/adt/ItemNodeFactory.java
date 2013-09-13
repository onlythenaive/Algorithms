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
 * Item nodes provider.
 *
 * @version 1.01, 13 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemNodeFactory {

    private final Counter _creations;

    /**
     * Creates a new instance of ItemNodeFactory.
     *
     * @param creations a counter of item node creations.
     *
     * @see Counter
     */
    public ItemNodeFactory(Counter creations) {
        if (creations == null) {
            throw new NullPointerException("creations counter is null");
        }   
        _creations = creations;
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
        _creations.increment();
        return new ItemNode(item, reads, linkReads, linkWrites);
    }
}
