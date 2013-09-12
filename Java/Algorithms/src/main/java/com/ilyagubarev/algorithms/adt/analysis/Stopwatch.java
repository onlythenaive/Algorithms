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

import java.util.Date;

/**
 * Simple stopwatch.
 *
 * @version 1.03, 12 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public class Stopwatch {

    private final String _id;
    private final boolean _resetable;

    private long _start;

    /**
     * Creates a new instance of Stopwatch.
     *
     * @param id stopwatch identifier.
     * @param resetable true if reset operation is supported.
     */
    public Stopwatch(String id, boolean resetable) {
        if (id == null) {
            throw new NullPointerException("id is null");
        }
        _id = id;
        _resetable = resetable;
    }

    /**
     * Gets an identifier of the stopwatch.
     *
     * @return stopwatch identifier.
     */
    public final String getId() {
        return _id;
    }

    /**
     * Gets elapsed time in milliseconds.
     *
     * @return elapsed time.
     */
    public final long getElapsedTime() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets stopwatch start time.
     *
     * @return start time.
     */
    public final Date getStartTime() {
        return new Date(_start);
    }

    public final void start() {
        _start = System.currentTimeMillis();
    }

    public final void stop() {
        
    }

    public final void reset() {
        if (!_resetable) {
            throw new UnsupportedOperationException("reset is not supported");
        }
        
    }

    @Override
    public String toString() {
        long elapsed = getElapsedTime();
        return String.format("[stopwatch (%s): %d ms elapsed]", _id, elapsed);
    }
}
