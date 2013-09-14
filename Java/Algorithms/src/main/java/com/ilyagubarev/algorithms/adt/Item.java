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

/**
 * Item model to be used in various tests and analyses.
 *
 * @version 1.02, 13 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class Item {

    private final Comparable _data;
    private final ItemType _type;

    Item(Comparable data, ItemType type) {
        _data = data;
        _type = type;
    }

    /**
     * Gets item type.
     *
     * @return item type.
     *
     * @see ItemType
     */
    public ItemType getType() {
        return _type;
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
