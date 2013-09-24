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
 * Linked list node model.
 *
 * @see NodeModel
 *
 * @version 1.07, 24 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class ListNodeModel<T> extends NodeModel<T> {

    private final Counter _linkReads;
    private final Counter _linkWrites;

    private ListNodeModel<T> _next;

    ListNodeModel(T item, Counter reads, Counter writes, Counter linkReads,
            Counter linkWrites) {
        super(item, reads, writes);
        _linkReads = linkReads;
        _linkWrites = linkWrites;
    }

    /**
     * Gets a reference to the next node.
     *
     * @return the next node.
     */
    public ListNodeModel<T> getNext() {
        throwExceptionIfDestructed();
        _linkReads.increment();
        return _next;
    }

    /**
     * Sets a reference to the next node.
     *
     * @param node the next node.
     */
    public void setNext(ListNodeModel<T> node) {
        throwExceptionIfDestructed();
        _linkWrites.increment();
        _next = node;
    }

    @Override
    public String toString() {
        throwExceptionIfDestructed();
        return String.format("[list node: %s]", getItem());
    }

    @Override
    protected int getMemoryAllocation() {
        return 2;
    }
}
