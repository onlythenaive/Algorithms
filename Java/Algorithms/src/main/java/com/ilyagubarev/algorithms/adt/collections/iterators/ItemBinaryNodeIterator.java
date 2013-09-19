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

import com.ilyagubarev.algorithms.adt.ItemModel;
import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;

/**
 * Item binary tree node iterator.
 *
 * @see ItemBinaryNode
 * @see Iterator
 *
 * @version 1.02, 18 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class ItemBinaryNodeIterator implements Iterator<ItemModel> {

    private BinaryNodeModel _next;

    /**
     * Creates a new instance of ItemBinaryIterator.
     *
     * @param root a root node.
     *
     * @see ItemBinaryNode
     */
    public ItemBinaryNodeIterator(BinaryNodeModel root) {
        _next = root;
        while (_next.getLeftChild() != null) {
            _next = _next.getLeftChild();
        }
    }

    @Override
    public boolean hasNext() {
        return _next != null;
    }

    @Override
    public ItemModel next() {
        if (!hasNext()) {
            throw new NoSuchElementException("iterator has no next element");
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("removal is not supported");
    }
}
