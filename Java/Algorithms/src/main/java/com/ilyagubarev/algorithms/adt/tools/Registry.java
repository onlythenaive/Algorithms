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
 * @version 1.03, 14 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class Registry {

    /**
     * Callback delegate for the register operation.
     */
    public static interface OnRegisterHandler {

        /**
         * Actions to be performed on a new value is registered.
         *
         * @param value
         * @param count
         * @param total
         * @param maxTotal
         * @param minTotal
         * @param averageValue
         * @param maxValue
         * @param minValue 
         */
        void execute(double value, long count, double total, double maxTotal,
                double minTotal, double averageValue, double maxValue,
                double minValue);
    }

    private final double _basis;
    private final OnRegisterHandler _handler;

    private int _count;
    private double _total;
    private double _maxTotal;
    private double _minTotal;
    private Double _maxValue;
    private Double _minValue;

    /**
     * Creates a new instance of Registry.
     *
     * @param basis a basis of the registry.
     */
    public Registry(double basis) {
        this(basis, null);
    }

    /**
     * Creates a new instance of Registry.
     *
     * @param basis a basis of the registry.
     * @param handler an instance of delegate for the register operation.
     *
     * @see OnRegisterHandler
     */
    public Registry(double basis, OnRegisterHandler handler) {
        _basis = basis;
        _maxTotal = basis;
        _minTotal = basis;
        _handler = handler;
    }

    /**
     * Gets average registered value.
     *
     * @return average registered value.
     * @throws IllegalStateException if the registry is empty.
     */
    public double getAverageValue() {
        throwExceptionIfEmpty();
        return (_total - _basis) / _count;
    }

    /**
     * Gets maximum total value.
     *
     * @return maximum total value.
     */
    public double getMax() {
        return _maxTotal;
    }

    /**
     * Gets maximum registered value.
     *
     * @return maximum registered value.
     * @throws IllegalStateException if the registry is empty.
     */
    public double getMaxValue() {
        throwExceptionIfEmpty();
        return _maxValue;
    }

    /**
     * Gets minimum total value.
     *
     * @return minimum total value.
     */
    public double getMin() {
        return _minTotal;
    }

    /**
     * Gets minimum registered value.
     *
     * @return minimum registered value.
     * @throws IllegalStateException if the registry is empty.
     */
    public double getMinValue() {
        throwExceptionIfEmpty();
        return _minValue;
    }

    /**
     * Gets a total of registered values.
     *
     * @return total value.
     */
    public double getTotal() {
        return _total;
    }

    /**
     * Gets current registered values count.
     * 
     * @return registered values count.
     */
    public long getValuesCount() {
        return _count;
    }

    /**
     * Checks if the registry has no registered values.
     *
     * @return true if the registry is empty.
     */
    public boolean isEmpty() {
        return getValuesCount() == 0;
    }

    /**
     * Registers specified value at the registry.
     *
     * @param value a numeric value.
     */
    public void register(double value) {
        if (isEmpty()) {
            _maxValue = value;
            _minValue = value;
        } else {
            if (_maxValue < value) {
                _maxValue = value;
            }
            if (_minValue > value) {
                _minValue = value;
            }
        }
        _count++;
        _total += value;
        if (_maxTotal < _total) {
            _maxTotal = _total;
        }
        if (_minTotal > _total) {
            _minTotal = _total;
        }        
        if (_handler != null) {
            _handler.execute(value, _count, _total, _maxTotal, _minTotal,
                    getAverageValue(), _maxTotal, _minValue);
        }
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("registry is empty");
        }
    }
}
