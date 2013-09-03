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
package com.ilyagubarev.algorithms.adt.utils;

import java.io.Serializable;

/**
 * Simple numeric accumulator.
 *
 * @see Serializable
 * 
 * @version 1.02, 03 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class Accumulator implements Serializable {

    /**
     * Creates a new instance of Accumulator.
     *
     * @param id an identifier for the accumulator.
     * @return a new instance of Accumulator.
     * @throws IllegalArgumentException if specified id is null.
     */
    public static Accumulator create(String id) {
        if (id == null) {
            throw new IllegalArgumentException("accumulator id is null");
        }
        return new Accumulator(id);
    }

    private final String _id;

    private double _total;
    private int _size;

    Accumulator(String id) {
        _id = id;
    }

    /**
     * Gets accumulator identifier.
     *
     * @return identifier.
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets an average value.
     *
     * @return average value.
     * @throws IllegalStateException if the accumulator is empty.
     */
    public double getAverage() {
        if (isEmpty()) {
            throw new IllegalStateException("accumulator is empty");
        }
        return _total / _size;
    }

    /**
     * Gets current accumulator size.
     * 
     * @return accumulator size.
     */
    public int getSize() {
        return _size;
    }

    /**
     * Checks if the accumulator is empty.
     *
     * @return true if the accumulator is empty.
     */
    public boolean isEmpty() {
        return _size == 0;
    }

    /**
     * Adds specified numeric value to the accumulator.
     *
     * @param value numeric value.
     */
    public void add(double value) {
        _total += value;
        ++_size;
    }

    @Override
    public String toString() {
        String state;
        if (isEmpty()) {
            state = "empty";
        } else {
            state = String.format("%f on %d values", getAverage(), _size);
        }
        return String.format("[%s accumulator: %s]", _id, state);
    }
}
