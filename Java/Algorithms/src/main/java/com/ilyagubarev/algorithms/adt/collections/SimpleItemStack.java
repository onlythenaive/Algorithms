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
import com.ilyagubarev.algorithms.adt.nodes.ItemListNode;
import com.ilyagubarev.algorithms.adt.nodes.ItemNodeFactory;
import com.ilyagubarev.algorithms.adt.collections.iterators.ItemListNodeIterator;

/**
 * Simple ItemStack implementation based on item list nodes.
 *
 * @see ItemStack
 *
 * @version 1.04, 15 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleItemStack implements ItemStack {

    private final ItemNodeFactory _factory;

    private int _size;
    private ItemListNode _top;

    /**
     * Creates a new instance of SimpleItemStack.
     *
     * @param factory item nodes provider.
     *
     * @see ItemNodeFactory
     */
    public SimpleItemStack(ItemNodeFactory factory) {
        if (factory == null) {
            throw new NullPointerException("item nodes provider is null");
        }
        _factory = factory;
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
        return new ItemListNodeIterator(_top);
    }

    @Override
    public Item peek() {
        throwExceptionIfEmpty();
        return _top.getItem();
    }

    @Override
    public Item pop() {
        throwExceptionIfEmpty();
        ItemListNode buffer = _top;
        _top = _top.getNext();
        --_size;
        return buffer.getItem();
    }

    @Override
    public void push(Item item) {
        ItemListNode buffer = _top;
        _top = _factory.createListNode(item);
        _top.setNext(buffer);
        ++_size;
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }
}
