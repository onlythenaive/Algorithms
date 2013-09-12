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

import java.io.Serializable;

/**
 * Item model to be used in various tests and analyses.
 *
 * @see Serializable
 *
 * @version 1.01, 13 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class Item implements Serializable {

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     */
    public static Item create(int source) {
        return new Item(source);
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     */
    public static Item create(double source) {
        return new Item(source);
    }

    /**
     * Creates a new instance of Item based on the source.
     *
     * @param source a source the item to be based on.
     * @return a new instance of Item.
     */
    public static Item create(String source) {
        if (source == null) {
            throw new NullPointerException("source is null");
        }
        return new Item(source);
    }

    private final Comparable _data;

    private Item(Comparable data) {
        _data = data;
    }

    @Override
    public String toString() {
        return String.format("[item: %s]", _data);
    }

    int getHash() {
        return _data.hashCode();
    }

    boolean isEqualTo(Item item) {
        return _data.equals(item._data);
    }

    int compareTo(Item item) {
        return _data.compareTo(item._data);
    }
}
