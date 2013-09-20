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

import com.ilyagubarev.algorithms.adt.nodes.ListNodeModel;

/**
 * Iterator over linked list node models.
 *
 * @see Iterator
 * @see ListNodeModel
 *
 * @version 1.06, 19 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class ListNodeModelIterator<E> implements Iterator<E> {

    private ListNodeModel<E> _next;

    /**
     * Creates a new instance of ListNodeModelIterator.
     *
     * @param start a starting node.
     *
     * @see ListNodeModel
     */
    public ListNodeModelIterator(ListNodeModel<E> start) {
        _next = start;
    }

    @Override
    public boolean hasNext() {
        return _next != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E result = _next.getItem();
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
