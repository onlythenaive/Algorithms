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
package com.ilyagubarev.algorithms.analysis.sorting;

import java.io.Serializable;

/**
 * Sorting method test task specification.
 *
 * @see Serializable
 *
 * @version 1.02, 23 September 2013
 * @since 14 September 2013
 * @author Ilya Gubarev
 */
public final class SortTask implements Serializable {

    private final int _itemsCount;
    private final int _auxMemoryLimit;
    private final int _recursionLimit;
    private final int _timeLimit;

    /**
     * Creates a new instance of SortTask.
     *
     * @param itemsCount target array size.
     * @param auxMemoryLimit auxillary memory usage limit.
     * @param recursionLimit recursive call depth limit.
     * @param timeLimit time limit in milliseconds.
     */
    public SortTask(int itemsCount, int auxMemoryLimit, int recursionLimit,
            int timeLimit) {
        _itemsCount = itemsCount;
        _auxMemoryLimit = auxMemoryLimit;
        _recursionLimit = recursionLimit;
        _timeLimit = timeLimit;
    }

    /**
     * Gets target array size.
     *
     * @return target array size.
     */
    public int getItemsCount() {
        return _itemsCount;
    }

    /**
     * Gets auxillary memory usage limit.
     *
     * @return auxillary memory limit.
     */
    public int getAuxMemoryLimit() {
        return _auxMemoryLimit;
    }

    /**
     * Gets recursive call depth limit.
     *
     * @return recursion limit.
     */
    public int getRecursionLimit() {
        return _recursionLimit;
    }

    /**
     * Gets time limit in milliseconds.
     *
     * @return time limit.
     */
    public int getTimeLimit() {
        return _timeLimit;
    }
}
