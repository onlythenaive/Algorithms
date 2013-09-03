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
import java.util.Date;

/**
 * Simple stopwatch.
 *
 * @see Serializable
 *
 * @version 1.01, 03 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public class Stopwatch implements Serializable {

    /**
     * Creates and starts a new instance of Stopwatch.
     *
     * @param id stopwatch identifier.
     * @return a new instance of Stopwatch.
     * @throws IllegalArgumentException if specified id is null.
     */
    public static Stopwatch create(String id) {
        if (id == null) {
            throw new IllegalArgumentException("stopwatch id is null");
        }
        return new Stopwatch(id, System.currentTimeMillis());
    }

    private final String _id;
    private final long _start;

    Stopwatch(String id, long start) {
        _id = id;
        _start = start;
    }

    /**
     * Gets an identifier of the stopwatch.
     *
     * @return stopwatch identifier.
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets elapsed time in milliseconds since stopwatch start.
     *
     * @return elapsed time.
     */
    public long getElapsedTime() {
        return System.currentTimeMillis() - _start;
    }

    /**
     * Gets stopwatch start time.
     *
     * @return start time.
     */
    public Date getStartTime() {
        return new Date(_start);
    }

    @Override
    public String toString() {
        long elapsed = getElapsedTime();
        return String.format("[%s stopwatch: %d ms elapsed]", _id, elapsed);
    }
}
