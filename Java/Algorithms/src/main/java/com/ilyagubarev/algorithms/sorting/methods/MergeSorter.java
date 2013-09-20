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

import java.util.Comparator;

import com.ilyagubarev.algorithms.adt.arrays.ArrayModel;
import com.ilyagubarev.algorithms.utils.CommonHelper;

/**
 * Abstract merge method sorting implementation.
 *
 * @see AbstractSorting
 *
 * @version 1.02, 20 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public abstract class MergeSorter extends AbstractSorter {

    protected final <T> void merge(ArrayModel<T> target,
            Comparator<T> comparator, int leftFirst, int leftLast,
            int rightLast, ArrayModel<T> aux) {
        for (int i = leftFirst; i <= rightLast; ++i) {
            aux.write(i, target.read(i));
        }
        int left = leftFirst;
        int right = leftLast + 1;
        for (int i = leftFirst; i <= rightLast; ++i) {
            if (left > leftLast) {
                target.write(i, aux.read(right++));
            } else if (right > rightLast) {
                target.write(i, aux.read(left++));
            } else {
                T leftItem = aux.read(left);
                T rightItem = aux.read(right);
                if (CommonHelper.compare(comparator, rightItem, leftItem) < 0) {
                    target.write(i, rightItem);
                    right++;
                } else {
                    target.write(i, leftItem);
                    left++;
                }
            }
        }
    }
}
