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
package com.ilyagubarev.algorithms.sorting.methods;

import com.ilyagubarev.algorithms.adt.ItemArray;
import com.ilyagubarev.algorithms.adt.ItemArrayFactory;
import com.ilyagubarev.algorithms.adt.ItemHelper;
import com.ilyagubarev.algorithms.adt.ItemNodeFactory;
import com.ilyagubarev.algorithms.adt.tools.Registry;

/**
 * Sorting algorithm common interface.
 *
 * @version 1.03, 14 September 2013
 * @since 10 September 2013
 * @author Ilya Gubarev
 */
public interface Sorter {

    /**
     * Gets a text info about the algorithm.
     *
     * @return algorithm info.
     */
    String getInfo();

    /**
     * Pre-sorting actions.
     *
     * @param n target array items count.
     */
    void prepare(int n);

    /**
     * Concrete sorting method implementation.
     *
     * @param target target array to be sorted.
     * @param helper item utility methods provider.
     * @param arrayFactory item arrays allocator.
     * @param nodeFactory item nodes provider.
     * @param recursions registry of recursive calls.
     *
     * @see ItemArray
     * @see ItemArrayFactory
     * @see ItemNodeFactory
     * @see ItemHelper
     * @see Registry
     */
    void sort(ItemArray target, ItemHelper helper,
            ItemArrayFactory arrayFactory, ItemNodeFactory nodeFactory,
            Registry recursions);
}
