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

import com.ilyagubarev.algorithms.adt.Item;
import com.ilyagubarev.algorithms.adt.tools.Counter;

/**
 * Items array model for sorting/searching methods analysis.
 *
 * @version 1.03, 13 September 2013
 * @since 12 September 2013
 * @author Ilya Gubarev
 */
public final class ItemsArray {

    private final Item[] _array;
    private final Counter _reads;
    private final Counter _writes;

    /**
     * Creates a new instance of ItemsArray with specified size.
     *
     * @param size array size.
     * @param reads a counter of read operations.
     * @param writes a counter of write operations.
     *
     * @see Counter
     */
    public ItemsArray(int size, Counter reads, Counter writes) {
        if (size < 0) {
            throw new IllegalArgumentException("array size is negative");
        }
        if (reads == null) {
            throw new NullPointerException("reads conuter is null");
        }
        if (writes == null) {
            throw new NullPointerException("writes conuter is null");
        }
        _array = new Item[size];
        _reads = reads;
        _writes = writes;
    }

    /**
     * Gets size of the array.
     *
     * @return array size.
     */
    public int getSize() {
        return _array.length;
    }

    /**
     * Gets an item at specified index.
     *
     * @param index item index.
     * @return an instance of Item.
     * @throws RuntimeException if specified index is illegal.
     *
     * @see Item
     */
    public Item read(int index) {
        Item result = _array[index];
        _reads.increment();
        return result;
    }

    /**
     * Sets an item to the specified index.
     *
     * @param index item index.
     * @param item an item to be set.
     * @throws RuntimeException if specified index is illegal.
     *
     * @see Item
     */
    public void write(int index, Item item) {
        _array[index] = item;
        _writes.increment();
    }
}
