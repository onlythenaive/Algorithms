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
 * Item model provider.
 *
 * @version 1.04, 19 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemModelFactory {

    private final Counter _creations;
    private final Counter _comparisons;
    private final Counter _hashings;
    private final Counter _tests;

    /**
     * Creates a new instance of ItemModelFactory.
     *
     * @param creations a counter of item model creations.
     * @param comparisons a counter of item model comparisons.
     * @param hashings a counter of item model hashings.
     * @param tests a counter of item model equality tests.
     *
     * @see Counter
     */
    public ItemModelFactory(Counter creations, Counter comparisons,
            Counter hashings, Counter tests) {
        if (creations == null) {
            throw new NullPointerException("creations counter is null");
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
        _creations = creations;
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
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        _creations.increment();
        return new ItemModel(source, _comparisons, _hashings, _tests);
    }
}
