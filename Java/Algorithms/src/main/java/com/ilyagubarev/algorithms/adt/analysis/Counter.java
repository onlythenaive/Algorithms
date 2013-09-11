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
package com.ilyagubarev.algorithms.adt.analysis;

import java.io.Serializable;

/**
 * Simple counter.
 *
 * @see Serializable
 * 
 * @version 1.01, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public class Counter implements Serializable {

    /**
     * Creates a new instance of Counter.
     *
     * @param id counter identifier.
     * @return a new instance of Counter.
     * @throws IllegalArgumentException if specified id is null.
     */
    public static Counter create(String id) {
        if (id == null) {
            throw new IllegalArgumentException("counter id is null");
        }
        return new Counter(id);
    }

    private final String _id;

    private long _value;

    Counter(String id) {
        _id = id;
    }

    /**
     * Gets an identifier of the counter.
     *
     * @return counter identifier.
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets current counter value.
     *
     * @return current value.
     */
    public long getValue() {
        return _value;
    }

    /**
     * Increments counter value by one.
     */
    public void increment() {
        ++_value;
    }

    @Override
    public String toString() {
        return String.format("[%s counter: %d]", _id, _value);
    }
}
