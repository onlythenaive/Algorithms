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
 * Items provider.
 *
 * @version 1.02, 13 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemFactory {

    private final Counter _creations;

    /**
     * Creates a new instance of ItemFactory.
     *
     * @param creations a counter of item creations.
     *
     * @see Counter
     */
    public ItemFactory(Counter creations) {
        if (creations == null) {
            throw new NullPointerException("creations counter is null");
        }
        _creations = creations;
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     *
     * @see Item
     */
    public Item create(int source) {
        _creations.increment();
        return new Item(source);
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     *
     * @see Item
     */
    public Item create(double source) {
        _creations.increment();
        return new Item(source);
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     *
     * @see Item
     */
    public Item create(String source) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        _creations.increment();
        return new Item(source);
    }
}
