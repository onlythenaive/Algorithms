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

import com.ilyagubarev.algorithms.adt.utils.Counter;

/**
 * Item model to be used in various tests and analyses.
 *
 * @see Comparable
 *
 * @version 1.05, 24 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemModel<T extends Comparable> extends Model
        implements Comparable<ItemModel<T>> {

    private final T _data;
    private final Counter _comparisons;
    private final Counter _hashings;    
    private final Counter _tests;

    ItemModel(T data, Counter comparisons, Counter hashings, Counter tests) {
        _data = data;
        _comparisons = comparisons;
        _hashings = hashings;
        _tests = tests;
    }

    @Override
    public int compareTo(ItemModel<T> item) {
        throwExceptionIfDestructed();
        _comparisons.increment();
        return _data.compareTo(item._data);
    }

    @Override
    public boolean equals(Object object) {
        throwExceptionIfDestructed();
        _tests.increment();
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        return _data.equals(((ItemModel)object)._data);
    }

    @Override
    public int hashCode() {
        throwExceptionIfDestructed();
        _hashings.increment();
        return _data.hashCode();
    }

    @Override
    public String toString() {
        throwExceptionIfDestructed();
        return String.format("[item: %s]", _data);
    }

    @Override
    protected int getMemoryAllocation() {
        return 1;
    }
}
