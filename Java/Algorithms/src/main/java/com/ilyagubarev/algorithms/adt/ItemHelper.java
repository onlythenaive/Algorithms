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

import com.ilyagubarev.algorithms.adt.tools.Counter;

/**
 * Item utility methods provider. 
 *
 * @version 1.01, 13 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemHelper {

    private final Counter _hashings;
    private final Counter _tests;

    /**
     * Creates a new instance of ItemHelper.
     */
    public ItemHelper() {
        _hashings = new Counter();
        _tests = new Counter();
    }

    /**
     * Gets total number of hash computations provided.
     *
     * @return number of hash computations.
     */
    public long getHashings() {
        return _hashings.getValue();
    }

    /**
     * Gets total number of less/equal/greater tests provided.
     *
     * @return number of tests.
     */
    public long getTests() {
        return _tests.getValue();
    }

    /**
     * Computes a hash code of the item.
     *
     * @param item an item.
     * @return item hash code.
     *
     * @see Item
     */
    public int hash(Item item) {
        int result = item.getHash();
        _hashings.increment();
        return result;
    }

    /**
     * Checks if specified items are equal to each other.
     *
     * @param first the first item.
     * @param second the second item.
     * @return true if specified items are equal.
     *
     * @see Item
     */
    public boolean equal(Item first, Item second) {
        boolean result = first.isEqualTo(second);
        _tests.increment();
        return result;
    }

    /**
     * Checks if specified item is greater than the sample.
     *
     * @param item an item to be tested.
     * @param sample a sample.
     * @return true if specified item is greater than the sample.
     * @throws IllegalArgumentException if specified items are incomparable.
     *
     * @see Item
     */
    public boolean greater(Item item, Item sample) {
        return compare(item, sample) > 0;
    }

    /**
     * Checks if specified item is less than the sample.
     *
     * @param item an item to be tested.
     * @param sample a sample.
     * @return true if specified item is less than the sample.
     * @throws IllegalArgumentException if specified items are incomparable.
     *
     * @see Item
     */
    public boolean less(Item item, Item sample) {
        return compare(item, sample) < 0;
    }

    private int compare(Item item, Item sample) {
        int result;
        try {
            result = item.compareTo(sample);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("arguments are incomparable");
        }
        _tests.increment();
        return result;
    }
}
