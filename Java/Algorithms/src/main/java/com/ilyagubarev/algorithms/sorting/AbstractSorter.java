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

import com.ilyagubarev.algorithms.adt.ItemArray;
import com.ilyagubarev.algorithms.adt.ItemArrayFactory;
import com.ilyagubarev.algorithms.adt.ItemHelper;
import com.ilyagubarev.algorithms.adt.ItemNodeFactory;
import com.ilyagubarev.algorithms.adt.tools.Stopwatch;

/**
 * Sorting algorithm common implementation.
 *
 * @version 1.03, 13 September 2013
 * @since 07 September 2013
 * @author Ilya Gubarev
 */
public abstract class AbstractSorter {

    /**
     * Template sequence of sorting actions.
     *
     * @param target an array to be sorted.
     * @param helper an item utility.
     * @param arrayFactory item arrays provider.
     * @param nodeFactory item nodes provider.
     * @param stopwatch a stopwatch for time consumption registering.
     *
     * @see ItemArray
     * @see ItemArrayFactory
     * @see ItemHelper
     * @see ItemNodeFactory
     * @see Stopwatch
     */
    public final void sort(ItemArray target, ItemHelper helper,
            ItemArrayFactory arrayFactory, ItemNodeFactory nodeFactory,
            Stopwatch stopwatch) {
        prepare(target.getSize());
        stopwatch.start();
        method(target, helper, arrayFactory, nodeFactory);
        stopwatch.stop();
        post();
    }

    /**
     * Concrete sorting method implementation.
     *
     * @param target an array to be sorted.
     * @param helper an item utility.
     * @param arrayFactory item arrays provider.
     * @param nodeFactory item nodes provider.
     *
     * @see ItemArray
     * @see ItemArrayFactory
     * @see ItemHelper
     * @see ItemNodeFactory
     */
    protected abstract void method(ItemArray target, ItemHelper helper,
            ItemArrayFactory arrayFactory, ItemNodeFactory nodeFactory);

    /**
     * Actions before the sorting is started.
     *
     * @param n target array size.
     */
    protected void prepare(int n) {

    }

    /**
     * Actions after the sorting is completed.
     */
    protected void post() {

    }
}
