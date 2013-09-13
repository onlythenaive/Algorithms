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

import com.ilyagubarev.algorithms.adt.collections.ItemsArray;
import com.ilyagubarev.algorithms.adt.collections.AuxMemory;
import com.ilyagubarev.algorithms.adt.tools.Counter;

/**
 * "Divide & merge" method sorting algorithm implementation.
 *
 * @see AbstractSorting
 *
 * @version 1.01, 12 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class MergeSorter extends AbstractSorter {

    @Override
    protected void method(ItemsArray target, AuxMemory aux) {
        aux.allocate(target.getSize());
        sort(target, 0, target.getSize(), aux);
    }

    private void merge(ItemsArray target, int leftFirst, int leftLast,
            int rightLast, AuxMemory aux) {
//        for (int i = leftFirst; i <= rightLast; ++i) {
//            target.set(i, aux, i);
//        }
//        int left = leftFirst;
//        int right = leftLast + 1;
//        for (int i = leftFirst; i <= rightLast; ++i) {
//            if (left > leftLast) {
//                target.get(i, aux, right++);
//            } else if (right > rightLast) {
//                target.get(i, aux, left++);
//            } else if (aux.less(right, left)) {
//                target.get(i, aux, right++);
//            } else {
//                target.get(i, aux, left++);
//            }
//        }
    }

    private void sort(ItemsArray target, int leftFirst, int rightLast,
            AuxMemory aux) {
        if (rightLast <= leftFirst) {
            return;
        }
        int leftLast = leftFirst + (rightLast - leftFirst) / 2;
        sort(target, leftFirst, leftLast, aux);
        sort(target, leftLast + 1, rightLast, aux);
        merge(target, leftFirst, leftLast, rightLast, aux);
    }
}
