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
import com.ilyagubarev.algorithms.adt.ItemNodeFactory;
import com.ilyagubarev.algorithms.adt.tools.Registry;

/**
 * Top-down merge method sorting algorithm implementation.
 *
 * @see AbstractSorting
 *
 * @version 1.04, 15 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class TopDownMergeSorter extends MergeSorter {

    @Override
    public String getInfo() {
        return "Top-down merge method";
    }

    @Override
    public void sort(ItemArray target, ItemArrayFactory arrayFactory,
            ItemNodeFactory nodeFactory, Registry recursions) {
        ItemArray aux = arrayFactory.create(target.getSize());
        sort(target, 0, target.getSize() - 1, aux, recursions);
    }

    private void sort(ItemArray target, int leftFirst, int rightLast,
            ItemArray aux, Registry recursions) {
        if (rightLast <= leftFirst) {
            return;
        }
        int leftLast = leftFirst + (rightLast - leftFirst) / 2;
        registerRecursiveCall(recursions);
        sort(target, leftFirst, leftLast, aux, recursions);
        registerRecursiveReturn(recursions);
        registerRecursiveCall(recursions);
        sort(target, leftLast + 1, rightLast, aux, recursions);
        registerRecursiveReturn(recursions);
        merge(target, leftFirst, leftLast, rightLast, aux);
    }
}