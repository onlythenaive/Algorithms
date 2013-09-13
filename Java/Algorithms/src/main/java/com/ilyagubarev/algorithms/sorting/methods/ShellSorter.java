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
//
//import com.ilyagubarev.algorithms.adt.collections.ItemsArray;
//import com.ilyagubarev.algorithms.adt.tools.Auxiliary;
//import com.ilyagubarev.algorithms.sorting.utils.gapping.GapProvider;
//
///**
// * Donald Shell method sorting algorithm implementation.
// *
// * @see AbstractSorter
// *
// * @version 1.03, 12 September 2013
// * @since 11 September 2013
// * @author Ilya Gubarev
// */
//public final class ShellSorter extends AbstractSorter {
//
//    private final GapProvider _provider;
//
//    /**
//     * Creates a new instance of ShellSorting with specified gap provider.
//     *
//     * @param provider gap value provider.
//     *
//     * @see GapProvider
//     */
//    public ShellSorter(GapProvider provider) {
//        if (provider == null) {
//            throw new NullPointerException("gaps provider is null");
//        }
//        _provider = provider;
//    }
//
//    @Override
//    protected void method(ItemsArray target, Auxiliary aux) {
//        while (!_provider.isEmpty()) {
//            int gap = _provider.getNext();
//            for (int pivot = gap; pivot < target.getSize(); ++pivot) {
////                int i = pivot;
////                while (i >= gap && target.less(i, i - gap)) {
////                    target.swap(i, i - gap);
////                    i = i - gap;
////                }
//            }
//        }
//    }
//
//    @Override
//    protected void prepare(int n) {
//        _provider.reset(n);
//    }
//}
