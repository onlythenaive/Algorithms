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
 * Node model provider.
 *
 * @version 1.05, 19 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class NodeModelFactory {

    private final Counter _creations;
    private final Counter _reads;
    private final Counter _writes;
    private final Counter _linkReads;
    private final Counter _linkWrites;

    /**
     * Creates a new instance of NodeModelFactory.
     *
     * @param creations a counter of node model creations.
     * @param reads a counter of node model read operations.
     * @param writes a counter of node model write operations.
     * @param linkReads a counter of node model link read operations.
     * @param linkWrites a counter of node model link write operations.
     *
     * @see Counter
     */
    public NodeModelFactory(Counter creations, Counter reads, Counter writes,
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
     * Creates a new instance of BinaryNodeModel.
     *
     * @param item an item to be contained in the node.
     * @return a new instance of BinaryNodeModel.
     *
     * @see BinaryNodeModel
     */
    public <T> BinaryNodeModel<T> createBinaryNode(T item) {
        _creations.increment();
        return new BinaryNodeModel<T>(item, _reads, _writes, _linkReads,
                _linkWrites);
    }

    /**
     * Creates a new instance of ItemListNode.
     *
     * @param item an item to be contained in the node.
     * @return a new instance of ItemListNode.
     *
     * @see ListNodeModel
     */
    public <T> ListNodeModel<T> createListNode(T item) {
        _creations.increment();
        return new ListNodeModel<T>(item, _reads, _writes, _linkReads,
                _linkWrites);
    }
}
