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

import java.util.Random;

/**
 * Arrays service utilites.
 *
 * @version 1.01, 11 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class ArraysHelper {

    /**
     * Populates specified array with random integers.
     *
     * @param array an array to be populated.
     */
    public static void populate(Integer[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt();
        }
    }

    /**
     * Populates specified array with random integers (0 <= x < maxValue).
     *
     * @param array an array to be populated.
     * @param maxValue a max value of random integers (exclusive).
     */
    public static void populate(Integer[] array, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(maxValue);
        }
    }

    private ArraysHelper() {

    }
}
