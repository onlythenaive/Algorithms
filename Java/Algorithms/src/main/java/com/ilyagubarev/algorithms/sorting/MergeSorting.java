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
 * "Divide & merge" method sorting algorithm implementation.
 *
 * @see AbstractSorting
 *
 * @version 1.01, 12 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class MergeSorting extends AbstractSorting {

    private Comparable[] _auxillary;

    @Override
    public void sort(Comparable[] array, Counter tests, Counter exchanges) {
        _auxillary = new Comparable[array.length];
        sort(array, 0, array.length - 1, tests, exchanges);
    }

    /**
     * Merges two sorted subarrays with each other.
     *
     * @param array an array containing sorted subarrays.
     * @param leftFirst the first item index of left sorted subarray.
     * @param leftLast the last item index of left sorted subarray.
     * @param rightLast the last item index of right sorted subarray.
     * @param tests a counter of test operations.
     * @param exchanges a counter of item exchanging operations.     *
     * @throws RuntimeException if specified indeces are illegal.
     */
    void merge(Comparable[] array, int leftFirst, int leftLast,
            int rightLast, Counter tests, Counter exchanges) {
        for (int i = leftFirst; i <= rightLast; ++i) {
            _auxillary[i] = array[i];
            exchanges.increment();
        }
        int left = leftFirst;
        int right = leftLast + 1;
        for (int i = leftFirst; i <= rightLast; ++i) {
            if (left > leftLast) {
                array[i] = _auxillary[right++];
            } else if (right > rightLast) {
                array[i] = _auxillary[left++];
            } else if (isLess(_auxillary, right, left, tests)) {
                array[i] = _auxillary[right++];
            } else {
                array[i] = _auxillary[left++];
            }
            exchanges.increment();
        }
    }

    void sort(Comparable[] array, int leftFirst, int rightLast,
            Counter tests, Counter exchanges) {
        if (rightLast <= leftFirst) {
            return;
        }
        int leftLast = leftFirst + (rightLast - leftFirst) / 2;
        sort(array, leftFirst, leftLast, tests, exchanges);
        sort(array, leftLast + 1, rightLast, tests, exchanges);
        merge(array, leftFirst, leftLast, rightLast, tests, exchanges);
    }
}
