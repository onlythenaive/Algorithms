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
package com.ilyagubarev.algorithms.adt.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.ilyagubarev.algorithms.adt.Item;
import com.ilyagubarev.algorithms.adt.ItemListNode;

/**
 * Item linked list node iterator.
 *
 * @see ItemListNode
 * @see Iterator
 *
 * @version 1.05, 15 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class ItemListNodeIterator implements Iterator<Item> {

    private ItemListNode _next;

    /**
     * Creates a new instance of ItemNodeIterator.
     *
     * @param start a starting node.
     *
     * @see ItemListNode
     */
    public ItemListNodeIterator(ItemListNode start) {
        _next = start;
    }

    @Override
    public boolean hasNext() {
        return _next != null;
    }

    @Override
    public Item next() {
        if (hasNext()) {
            Item result = _next.getItem();
            _next = _next.getNext();
            return result;
        } else {
            throw new NoSuchElementException("iterator has no next element");
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("removal is not supported");
    }
}
