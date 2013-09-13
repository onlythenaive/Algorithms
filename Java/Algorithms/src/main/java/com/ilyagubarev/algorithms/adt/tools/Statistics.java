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
package com.ilyagubarev.algorithms.adt.tools;

/**
 * Simple statistics provider.
 *
 * @version 1.03, 13 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class Statistics {

    private final Counter _values;

    private double _total;
    private Double _maximum;
    private Double _minimum;

    /**
     * Creates a new instance of Statistics.
     */
    public Statistics() {
        _values = new Counter();
    }

    /**
     * Gets current average value.
     *
     * @return average value.
     */
    public double getAverage() {
        if (_values.getValue() == 0) {
            return 0.0;
        }
        return _total / _values.getValue();
    }

    /**
     * Gets current maximum value.
     *
     * @return maximum value.
     */
    public double getMaximum() {
        if (_maximum == null) {
            return 0;
        }
        return _maximum;
    }

    /**
     * Gets current minimum value.
     *
     * @return minimum value.
     */
    public double getMinimum() {
        if (_minimum == null) {
            return 0;
        }
        return _minimum;
    }

    /**
     * Gets total collected value.
     *
     * @return total value.
     */
    public double getTotal() {
        return _total;
    }

    /**
     * Gets current collected values count.
     * 
     * @return values count.
     */
    public long getValuesCount() {
        return _values.getValue();
    }

    /**
     * Adds specified value to the statistics provider.
     *
     * @param value numeric value.
     */
    public void add(double value) {
        _total += value;
        _values.increment();
        if (_values.getValue() == 1) {
            _maximum = value;
            _minimum = value;
        } else {
            if (_maximum < value) {
                _maximum = value;
            }
            if (_minimum > value) {
                _minimum = value;
            }
        }
    }
}
