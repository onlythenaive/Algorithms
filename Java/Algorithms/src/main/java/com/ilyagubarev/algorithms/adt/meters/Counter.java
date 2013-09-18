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
package com.ilyagubarev.algorithms.adt.meters;

/**
 * Simple counter.
 * 
 * @version 1.03, 13 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class Counter {

    /**
     * Callback delegate for the increment operation.
     */
    public static interface OnIncrementHandler {

        /**
         * Actions to be performed on counter value is incremented.
         *
         * @param value counter incremented value.
         */
        void execute(long value);
    }

    private final OnIncrementHandler _handler;

    private long _value;

    /**
     * Creates a new instance of Counter.
     */
    public Counter() {
        this(null);
    }

    /**
     * Creates a new instance of Counter.
     *
     * @param handler a delegate instance for the increment operation.
     *
     * @see OnIncrementHandler
     */
    public Counter(OnIncrementHandler handler) {
        _handler = handler;
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
        if (_handler != null) {
            _handler.execute(_value);
        }
    }
}
