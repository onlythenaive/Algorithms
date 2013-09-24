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
package com.ilyagubarev.algorithms.adt.arrays;

import com.ilyagubarev.algorithms.adt.utils.Counter;
import com.ilyagubarev.algorithms.adt.utils.Registry;

/**
 * Array model factory.
 *
 * @version 1.03, 24 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ArrayModelFactory {

    private final Registry _allocations;
    private final Counter _reads;
    private final Counter _writes;

    /**
     * Creates a new instance of ArrayModelFactory.
     *
     * @param allocations a registry of memory allocations.
     * @param reads a counter of array read operations.
     * @param writes a counter of array write operations.
     *
     * @see Counter
     * @see Registry
     */
    public ArrayModelFactory(Registry allocations, Counter reads,
            Counter writes) {
        if (allocations == null) {
            throw new NullPointerException("allocations registry is null");
        }
        if (reads == null) {
            throw new NullPointerException("reads counter is null");            
        }
        if (writes == null) {
            throw new NullPointerException("writes counter is null");            
        }
        _allocations = allocations;
        _reads = reads;
        _writes = writes;
    }

    /**
     * Creates a new instance of ArrayModel of specified size.
     *
     * @param size a size of the array.
     * @return a new instance of ArrayModel.
     * @throws IllegalArgumentException is specified size is negative.
     *
     * @see ArrayModel
     */
    public <T> ArrayModel<T> create(int size) {
        ArrayModel<T> result;
        if (size < 0) {
            throw new IllegalArgumentException("array size is negative");
        }
        result = new ArrayModel<T>(size, _reads, _writes);
        _allocations.register(result.getMemoryAllocation());
        return result;
    }

    /**
     * Marks specified array as desctructed.
     *
     * @param array an array to be marked as destructed.
     *
     * @see ArrayModel
     */
    public void desctruct(ArrayModel array) {
        _allocations.register(-array.getMemoryAllocation());
    }
}
