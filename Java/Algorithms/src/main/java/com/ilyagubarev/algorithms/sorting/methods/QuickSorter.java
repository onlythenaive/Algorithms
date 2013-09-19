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
import com.ilyagubarev.algorithms.adt.nodes.ItemNodeFactory;
import com.ilyagubarev.algorithms.adt.meters.Registry;

/**
 * Sorting algorithm implementation based on T. Hoare "quicksort" method.
 *
 * @see AbstractSorter
 *
 * @version 1.01, 16 September 2013
 * @since 16 September 2013
 * @author Ilya Gubarev
 */
public final class QuickSorter extends AbstractSorter {

    @Override
    public String getInfo() {
        return "Standard \"quicksort\" method";
    }

    @Override
    public void sort(ArrayModel target, ArrayModelFactory arrayFactory,
            ItemNodeFactory nodeFactory, Registry recursions) {
        sort(target, 0, target.getSize() - 1, recursions);
    }

    private void sort(ArrayModel target, int first, int last, Registry recs) {
        if (last <= first) {
            return;
        }
        int pivot = separate(target, 0, target.getSize() - 1);
        registerRecursiveCall(recs);
        sort(target, first, pivot - 1, recs);
        registerRecursiveReturn(recs);
        registerRecursiveCall(recs);
        sort(target, pivot + 1, last, recs);
        registerRecursiveReturn(recs);
    }

    private int separate(ArrayModel target, int first, int last) {
        int i = first;
        int j = last + 1;
        int pivot = first;
        while (true) {
            while (less(target, ++i, pivot)) {
                if (i == last) {
                    break;
                }
            }
            while (less(target, pivot, --j)) {
                if (j == first) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(target, i, j);
        }
        swap(target, first, j);
        return j;
    }
}
