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

import com.ilyagubarev.algorithms.adt.analysis.Counter;

/**
 * Insertion sorting algorithm implementation.
 *
 * @see AbstractSorting
 *
 * @version 1.01, 11 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class InsertionSorting extends AbstractSorting {

    @Override
    public void sort(Comparable[] array, Counter tests, Counter exchanges) {
        for (int pivot = 1; pivot < array.length; ++pivot) {
            int i = pivot - 1;
            while ((i >= 0) && (isLess(pivot, i, tests))) {
                exchange(array, pivot, i, exchanges);
                --i;
            }
        }
    }
}
