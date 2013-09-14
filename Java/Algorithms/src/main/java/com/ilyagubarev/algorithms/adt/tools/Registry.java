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
public final class Registry {

    /**
     * Callback delegate for the adding operation.
     */
    public static interface AddingDelegate {

        /**
         * Actions to be performed after a new value is added to the provider.
         *
         * @param n total collected values count.
         * @param total total collected value.
         * @param mean current average value.
         * @param max current maximum value.
         * @param min current minimum value.
         */
        void execute(long n, double total, double mean, double max, double min);
    }

    private final AddingDelegate _addingDelegate;

    private int _values;
    private double _total;
    private Double _maximumValue;
    private Double _minimumValue;

    /**
     * Creates a new instance of Statistics.
     */
    public Registry() {
        this(null);
    }

    /**
     * Creates a new instance of Statistics.
     *
     * @param addingDelegate an instance of  delegate for the adding operation.
     */
    public Registry(AddingDelegate addingDelegate) {
        _addingDelegate = addingDelegate;
    }

    /**
     * Gets current average value.
     *
     * @return average value.
     */
    public double getAverageValue() {
        if (_values == 0) {
            return 0.0;
        }
        return _total / _values;
    }

    /**
     * Gets current maximum value.
     *
     * @return maximum value.
     */
    public double getMaximumValue() {
        if (_maximumValue == null) {
            return 0;
        }
        return _maximumValue;
    }

    /**
     * Gets current minimum value.
     *
     * @return minimum value.
     */
    public double getMinimumValue() {
        if (_minimumValue == null) {
            return 0;
        }
        return _minimumValue;
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
        return _values;
    }

    /**
     * Adds specified value to the statistics provider.
     *
     * @param value numeric value.
     */
    public void register(double value) {
        _total += value;
        _values++;
        if (_values == 1) {
            _maximumValue = value;
            _minimumValue = value;
        } else {
            if (_maximumValue < value) {
                _maximumValue = value;
            }
            if (_minimumValue > value) {
                _minimumValue = value;
            }
        }
        if (_addingDelegate != null) {
            _addingDelegate.execute(_values, _total, getAverageValue(), _maximumValue, _minimumValue);
        }
    }
}
