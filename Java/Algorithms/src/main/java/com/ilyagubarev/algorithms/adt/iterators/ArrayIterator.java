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

import com.ilyagubarev.algorithms.adt.arrays.ArrayModel;

/**
 * Iterator over an array model.
 *
 * @see Iterator
 *
 * @version 1.01, 30 September 2013
 * @since 23 September 2013
 * @author Ilya Gubarev
 */
public final class ArrayIterator<T> implements Iterator<T>{

    private final ArrayModel<T> _array;

    private int _next;

    /**
     * Creates a new instance of ArrayIterator.
     *
     * @param array an array model.
     *
     * @see ArrayModel
     */
    public ArrayIterator(ArrayModel<T> array) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        _array = array;
        _next = 0;
    }

    @Override
    public boolean hasNext() {
        return _next < _array.getSize();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("iterator has no next element");
        }
        return _array.read(_next++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("removal is not supported");
    }
}
