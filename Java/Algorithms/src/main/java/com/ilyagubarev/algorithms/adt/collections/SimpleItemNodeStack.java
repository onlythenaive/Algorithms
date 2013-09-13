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
package com.ilyagubarev.algorithms.adt.collections;

import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.Item;
import com.ilyagubarev.algorithms.adt.ItemNode;
import com.ilyagubarev.algorithms.adt.ItemNodeFactory;
import com.ilyagubarev.algorithms.adt.tools.Counter;

/**
 * Simple ItemStack implementation based on item nodes.
 *
 * @see ItemStack
 *
 * @version 1.03, 13 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleItemNodeStack implements ItemStack {

    private final Counter _reads;
    private final Counter _linkReads;
    private final Counter _linkWrites;
    private final ItemNodeFactory _factory;

    private int _size;
    private ItemNode _top;

    /**
     * Creates a new instance of SimpleItemNodeStack.
     *
     * @param factory an item nodes provider.
     * @param reads a counter of item read operations.
     * @param linkReads a counter of item node link read operations.
     * @param linkWrites a counter of item node link write operations.
     *
     * @see Counter
     * @see ItemNodeFactory
     */
    public SimpleItemNodeStack(ItemNodeFactory factory, Counter reads,
            Counter linkReads, Counter linkWrites) {
        if (factory == null) {
            throw new NullPointerException("item nodes provider is null");
        }
        if (reads == null) {
            throw new NullPointerException("item reads counter is null");
        }
        if (linkReads == null) {
            throw new NullPointerException("node link reads counter is null");
        }
        if (linkWrites == null) {
            throw new NullPointerException("node link writes counter is null");
        }
        _factory = factory;
        _reads = reads;
        _linkReads = linkReads;
        _linkWrites = linkWrites;
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
    public Iterator<Item> iterator() {
        return new ItemNodeIterator(_top);
    }

    @Override
    public Item peek() {
        throwExceptionIfEmpty();
        return _top.getItem();
    }

    @Override
    public Item pop() {
        throwExceptionIfEmpty();
        ItemNode buffer = _top;
        _top = _top.getNext();
        --_size;
        return buffer.getItem();
    }

    @Override
    public void push(Item item) {
        ItemNode buffer = _top;
        _top = _factory.createNode(item, _reads, _linkReads, _linkWrites);
        _top.setNext(buffer);
        ++_size;
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }
}
