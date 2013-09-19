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
package com.ilyagubarev.algorithms.adt.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;

/**
 * Binary tree node model iterator.
 *
 * @see BinaryNodeModel
 * @see Iterator
 *
 * @version 1.03, 19 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class BinaryNodeModelIterator<E> implements Iterator<E> {

    private BinaryNodeModel<E> _next;

    /**
     * Creates a new instance of BinaryNodeModelIterator.
     *
     * @param root a root node.
     *
     * @see BinaryNodeModel
     */
    public BinaryNodeModelIterator(BinaryNodeModel<E> root) {
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
    public E next() {
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
