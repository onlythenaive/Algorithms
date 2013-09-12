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
package com.ilyagubarev.algorithms.sorting;

import com.ilyagubarev.algorithms.adt.analysis.Array;
import com.ilyagubarev.algorithms.adt.analysis.AuxMemory;
import com.ilyagubarev.algorithms.adt.analysis.Counter;
import com.ilyagubarev.algorithms.adt.analysis.Stopwatch;

/**
 * Sorting algorithm common implementation.
 *
 * @version 1.02, 12 September 2013
 * @since 07 September 2013
 * @author Ilya Gubarev
 */
public abstract class AbstractSorter {

    public final boolean sort(Array target, AuxMemory aux, Stopwatch watch) {
        throw new UnsupportedOperationException();
    }

    protected void prepare() {
        
    }

    protected void post() {
        
    }

    /**
     * Sorts specified array in a natural order.
     *
     * @param array an array to be sorted.
     * @param tests a counter of test operations.
     * @param exchanges a counter of item exchanging operations.
     *
     * @see Counter
     */
    public abstract void sort(Comparable[] array, Counter tests, Counter exchanges);

    /**
     * Exchanges a couple of array items of specified indeces with each other.
     *
     * @param array an array with the objects to be exchanged.
     * @param firstIndex an index of the first object.
     * @param secondIndex an index of the second object.
     * @param counter a counter to register the operation.
     * @throws RuntimeException if the indeces are illegal.
     *
     * @see Counter
     */
    protected void exchange(Object[] array, int firstIndex, int secondIndex,
            Counter counter) {
        counter.increment();
        Object buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;
    }

    /**
     * Checks if one array item is less than another.
     *
     * @param subjectIndex an index of a subject to be tested.
     * @param sampleIndex an index of a sample object.
     * @param counter a counter to register the operation.
     * @return true if the subject is less than the sample.
     * @throws ClassCastException if the objects are incomparable.
     * @throws RuntimeException if the indeces are illegal.
     *
     * @see Counter
     */
    protected boolean isLess(Comparable[] array, int subjectIndex,
            int sampleIndex, Counter counter) {
        counter.increment();
        return array[subjectIndex].compareTo(array[sampleIndex]) < 0;
    }
}
