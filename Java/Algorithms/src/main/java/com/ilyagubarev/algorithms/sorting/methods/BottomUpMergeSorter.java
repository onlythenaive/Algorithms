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
import com.ilyagubarev.algorithms.adt.meters.Registry;

/**
 * Bottom-up merge method sorting algorithm implementation.
 *
 * @see MergeSorter
 *
 * @version 1.01, 15 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class BottomUpMergeSorter extends MergeSorter {

    @Override
    public String getInfo() {
        return "Bottom-up merge method";
    }

    @Override
    public void sort(ItemArray target, ItemArrayFactory arrayFactory,
            ItemNodeFactory nodeFactory, Registry recursions) {
        ItemArray aux = arrayFactory.create(target.getSize());
        for (int subSize = 1; subSize < target.getSize(); subSize += subSize) {
            for (int i = 0; i < target.getSize() - subSize; i += 2 * subSize) {
                int rightLast = Math.min(i + 2 * subSize, target.getSize());
                merge(target, i, i + subSize - 1, rightLast - 1, aux);
            }
        }
    }
}
