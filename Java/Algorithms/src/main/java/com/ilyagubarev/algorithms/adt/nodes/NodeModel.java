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
package com.ilyagubarev.algorithms.adt.nodes;

import com.ilyagubarev.algorithms.adt.Model;
import com.ilyagubarev.algorithms.adt.utils.Counter;

/**
 * Abstract node model.
 *
 * @see Model
 *
 * @version 1.01, 24 September 2013
 * @since 24 September 2013
 * @author Ilya Gubarev
 */
public abstract class NodeModel<T> extends Model {

    private final Counter _reads;
    private final Counter _writes;

    private T _item;

    protected NodeModel(T item, Counter reads, Counter writes) {
        _item = item;
        _reads = reads;
        _writes = writes;
    }

    /**
     * Gets a stored item.
     *
     * @return a stored item.
     */
    public T getItem() {
        throwExceptionIfDestructed();
        _reads.increment();
        return _item;
    }

    /**
     * Sets a new stored item.
     *
     * @param item an item to be stored.
     */
    public void setItem(T item) {
        throwExceptionIfDestructed();
        _writes.increment();
        _item = item;
    }

    @Override
    protected abstract int getMemoryAllocation();
}
