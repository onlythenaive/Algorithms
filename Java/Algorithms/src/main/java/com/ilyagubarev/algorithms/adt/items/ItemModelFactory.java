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
package com.ilyagubarev.algorithms.adt.items;

import com.ilyagubarev.algorithms.adt.utils.Counter;
import com.ilyagubarev.algorithms.adt.utils.Registry;

/**
 * Item model factory.
 *
 * @version 1.04, 24 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemModelFactory {

    private final Registry _allocations;
    private final Counter _comparisons;
    private final Counter _hashings;
    private final Counter _tests;

    /**
     * Creates a new instance of ItemModelFactory.
     *
     * @param allocations a registry of memory allocations.
     * @param comparisons a counter of item model comparisons.
     * @param hashings a counter of item model hashings.
     * @param tests a counter of item model equality tests.
     *
     * @see Counter
     * @see Registry
     */
    public ItemModelFactory(Registry allocations, Counter comparisons,
            Counter hashings, Counter tests) {
        if (allocations == null) {
            throw new NullPointerException("allocations registry is null");
        }
        if (comparisons == null) {
            throw new NullPointerException("comparisons counter is null");
        }
        if (hashings == null) {
            throw new NullPointerException("hashings counter is null");
        }
        if (tests == null) {
            throw new NullPointerException("tests counter is null");
        }
        _allocations = allocations;
        _comparisons = comparisons;
        _hashings = hashings;
        _tests = tests;
    }

    /**
     * Creates a new instance of ItemModel based on the source.
     *
     * @param source a source the item model to be based on.
     * @return a new instance of ItemModel.
     *
     * @see Comparable
     * @see ItemModel
     */
    public <T extends Comparable> ItemModel<T> create(T source) {
        ItemModel<T> result;
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        result = new ItemModel(source, _comparisons, _hashings, _tests);
        _allocations.register(result.getMemoryAllocation());
        return result;
    }

    /**
     * Marks specified item as desctructed.
     *
     * @param array an item to be marked as destructed.
     *
     * @see ItemModel
     */
    public void desctruct(ItemModel item) {
        _allocations.register(-item.getMemoryAllocation());
    }
}
