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

import com.ilyagubarev.algorithms.adt.tools.Counter;
import java.io.Serializable;

/**
 * Simple numeric accumulator.
 *
 * @see Serializable
 *
 * @version 1.02, 12 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public class Accumulator implements Serializable {

    private final String _id;
    private final Counter _values;

    private double _total;

    /**
     * Creates a new instance of Accumulator.
     *
     * @param id accumulator identifier.
     */
    public Accumulator(String id) {
        if (id == null) {
            throw new NullPointerException("accumulator id is null");
        }
        _id = id;
        _values = new Counter();
    }

    /**
     * Gets an identifier of the accumulator.
     *
     * @return accumulator identifier.
     */
    public final String getId() {
        return _id;
    }

    /**
     * Gets an average value.
     *
     * @return an average value.
     * @throws IllegalStateException if the accumulator is empty.
     */
    public final double getAverage() {
        if (isEmpty()) {
            throw new IllegalStateException("accumulator is empty");
        }
        return _total / getSize();
    }

    /**
     * Gets current accumulator size.
     * 
     * @return accumulator size.
     */
    public final long getSize() {
        return _values.getValue();
    }

    /**
     * Checks if the accumulator is empty.
     *
     * @return true if the accumulator is empty.
     */
    public final boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Adds specified numeric value to the accumulator.
     *
     * @param value a numeric value.
     */
    public final void add(double value) {
        _total += value;
        _values.increment();
        onAdd(value);
    }

    @Override
    public String toString() {
        String state;
        if (isEmpty()) {
            state = "empty";
        } else {
            state = String.format("%f on %d values", getAverage(), getSize());
        }
        return String.format("[accumulator (%s): %s]", _id, state);
    }

    /**
     * Action on value adding.
     *
     * @param value a numeric value.
     */
    protected void onAdd(double value) {

    }
}
