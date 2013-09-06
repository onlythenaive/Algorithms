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

import com.ilyagubarev.algorithms.utils.std.StdDraw;

/**
 * Visual numeric accumulator.
 *
 * @see Accumulator
 *
 * @version 1.01, 03 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public class VisualAccumulator extends Accumulator {

    /**
     * Creates a new instance of VisualAccumulator.
     *
     * @param id an identifier for the accumulator.
     * @param cap maximum accumulator capacity.
     * @param scale expected values maximum.
     * @return a new instance of VisualAccumulator.
     * @throws IllegalArgumentException if specified arguments are illegal.
     */
    public static VisualAccumulator create(String id, int cap, double scale) {
        if (id == null) {
            throw new IllegalArgumentException("accumulator id is null");
        }
        if (cap < 0) {
            throw new IllegalArgumentException("accumulator size is negative");
        }        
        StdDraw.setXscale(0, cap);
        StdDraw.setYscale(0, scale);
        StdDraw.setPenRadius(0.005);
        return new VisualAccumulator(id, Counter.create(id), cap);
    }

    private final int _capacity;

    VisualAccumulator(String id, Counter values, int capacity) {
        super(id, values);
        _capacity = capacity;
    }

    /**
     * Gets maximum accumulator capacity.
     *
     * @return accumulator capacity.
     */
    public int getCapacity() {
        return _capacity;
    }

    /**
     * Adds specified numeric value to the accumulator.
     *
     * @param value a numeric value.
     * @throws IllegalStateException if accumulator is full.
     */
    @Override
    public void add(double value) {
        if (getSize() == _capacity) {
            throw new IllegalStateException("accumulator is full");
        }
        super.add(value);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(getSize(), value);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(getSize(), getAverage());
    }
}
