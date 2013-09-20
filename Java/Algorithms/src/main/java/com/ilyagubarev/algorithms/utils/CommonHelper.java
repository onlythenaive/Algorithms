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
package com.ilyagubarev.algorithms.utils;

import java.util.Comparator;

/**
 * Common utility methods.
 *
 * @version 1.01, 20 September 2013
 * @since 20 September 2013
 * @author Ilya Gubarev
 */
public final class CommonHelper {

     /**
      * Compares the first item with the second item.
      *
      * @param comparator an item comparator.
      * @param first the first item.
      * @param second the second item.
      * @return an integer value similar to "Comparable.compareTo(Comparable)".
      *
      * @see Comparator
      */
     public static <T> int compare(Comparator<T> comparator,
             T first, T second) {
        if (comparator != null) {
            return comparator.compare(first, second);
        } else {
            return ((Comparable) first).compareTo(second);
        }
    }
}
