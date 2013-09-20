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

import com.ilyagubarev.algorithms.adt.arrays.ArrayModel;
import com.ilyagubarev.algorithms.adt.arrays.ArrayModelFactory;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.utils.Registry;

/**
 * Sorting algorithm common interface.
 *
 * @version 1.05, 20 September 2013
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
     * @param target target array model to be sorted.
     * @param arrayFactory array model factory.
     * @param nodeFactory node model factory.
     * @param recursions registry of recursive calls.
     *
     * @see ArrayModel
     * @see ArrayModelFactory
     * @see NodeModelFactory
     * @see Registry
     */
    <T extends Comparable<T>> void sort(ArrayModel<T> target,
            ArrayModelFactory arrayFactory, NodeModelFactory nodeFactory,
            Registry recursions);
}
