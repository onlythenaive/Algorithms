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
import com.ilyagubarev.algorithms.sorting.utils.gapping.GapProvider;

/**
 * Donald Shell method sorting algorithm implementation.
 *
 * @see AbstractSorting
 *
 * @version 1.02, 12 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class ShellSorting extends AbstractSorting {

    /**
     * Creates a new instance of ShellSorting with specified gap provider.
     *
     * @param provider gap value provider.
     * @return a new instance of ShellSorting.
     *
     * @see GapProvider
     */
    public static ShellSorting create(GapProvider provider) {
        if (provider == null) {
            throw new NullPointerException("gaps provider is null");
        }
        return new ShellSorting(provider);
    }

    private final GapProvider _provider;

    private ShellSorting(GapProvider provider) {
        _provider = provider;
    }

    @Override
    public void sort(Comparable[] array, Counter tests, Counter exchanges) {
        _provider.reset(array.length);
        while (_provider.isEmpty()) {
            int gap = _provider.getNext();
            for (int pivot = gap; pivot < array.length; ++pivot) {
                int i = pivot;
                while ((i >= gap) && (isLess(array, i, i - gap, tests))) {
                    exchange(array, i, i - gap, exchanges);
                    i = i - gap;
                }
            }
        }
    }
}
