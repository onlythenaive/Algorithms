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
import com.ilyagubarev.algorithms.adt.analysis.Stopwatch;

/**
 * Sorting algorithm analyser common implementation.
 *
 * @version 1.02, 12 September 2013
 * @since 07 September 2013
 * @author Ilya Gubarev
 */
public abstract class AbstractSorter {

    /**
     * Sorts the target by a concrete method in natural order.
     *
     * @param target a target array to be sorted.
     * @param aux an auxillary memory.
     * @param watch a stopwatch for time consumption registration.
     * @return true, if the target is sorted in natural order.
     *
     * @see Array
     * @see AuxMemory
     * @see Stopwatch
     */
    public final boolean sort(Array target, AuxMemory aux, Stopwatch watch) {
        prepare(target.getSize());
        watch.start();
        method(target, aux);
        watch.stop();
        post();
        return target.isSorted();
    }

    /**
     * Concrete sorting method implementation.
     *
     * @param target a target array to be sorted.
     * @param aux an auxillary memory.
     *
     * @see Array
     * @see AuxMemory
     */
    protected abstract void method(Array target, AuxMemory aux);

    /**
     * Pre-sorting actions (f.e. gap sequence generation for Shell method).
     *
     * @param n total amount of items in the target.
     */
    protected void prepare(int n) {

    }

    /**
     * Post-sorting actions.
     */
    protected void post() {

    }
}
