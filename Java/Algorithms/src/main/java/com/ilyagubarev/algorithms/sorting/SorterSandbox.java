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

import java.util.Comparator;

import com.ilyagubarev.algorithms.sorting.methods.Sorter;
import com.ilyagubarev.algorithms.adt.arrays.ArrayModel;
import com.ilyagubarev.algorithms.adt.arrays.ArrayModelFactory;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.utils.Registry;
import com.ilyagubarev.algorithms.adt.utils.Stopwatch;

/**
 * Sorting method analyses sandbox.
 *
 * @version 1.03, 20 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class SorterSandbox {

    /**
     * Runs specified sorter on the target.
     *
     * @param sorter sorting algorithm implementation.
     * @param target target array to be sorted.
     * @param comparator an item comparator.
     * @param arrayFactory item arrays allocator.
     * @param nodeFactory item nodes provider.
     * @param recursions registry of recursive calls
     * @param stopwatch time consumption registry.
     *
     * @see Comparator
     * @see ItemArray
     * @see ItemArrayFactory
     * @see ItemNodeFactory
     * @see Registry
     * @see Sorter
     * @see Stopwatch
     */
    public static <T> void run(Sorter sorter, ArrayModel<T> target,
            Comparator<T> comparator, ArrayModelFactory arrayFactory,
            NodeModelFactory nodeFactory, Registry recursions,
            Stopwatch stopwatch) {
        sorter.prepare(target.getSize());
        stopwatch.start();
        sorter.sort(target, comparator, arrayFactory, nodeFactory, recursions);
        stopwatch.stop();
    }

    private SorterSandbox() {

    }
}
