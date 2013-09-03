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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator implementation for single linked list nodes.
 *
 * @see Iterator
 *
 * @version 1.02, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
final class SingleLinkedNodeIterator<E> implements Iterator<E> {

    private SingleLinkedNode<E> _current;

    /**
     * Creates a new instance of SingleLinkedNodeIterator.
     *
     * @param start a starting node..
     */
    public SingleLinkedNodeIterator(SingleLinkedNode<E> start) {
        _current = start;
    }

    @Override
    public boolean hasNext() {
        return _current != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E result = _current.getItem();
            _current = _current.getNext();
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
