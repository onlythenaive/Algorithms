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
 * @version 1.03, 30 September 2013
 * @since 14 September 2013
 * @author Ilya Gubarev
 */
public final class SortTask implements Serializable {

    private final int _itemsCount;
    private final Integer _auxMemoryLimit;
    private final Integer _recursionLimit;
    private final Integer _timeLimit;

    /**
     * Creates a new instance of SortTask.
     *
     * @param itemsCount size of an array to be sorted.
     * @param auxMemoryLimit auxillary memory usage limit (optional).
     * @param recursionDepthLimit recursive call stack size limit (optional).
     * @param timeLimit time limit in milliseconds (optional).
     * @throws IllegalArgumentException if specified limits are illegal.
     */
    public SortTask(int itemsCount, Integer auxMemoryLimit,
            Integer recursionDepthLimit, Integer timeLimit) {
        if (itemsCount < 0) {
            throw new IllegalArgumentException("items count is negative");
        }
        if (auxMemoryLimit != null && auxMemoryLimit < 0) {
            throw new IllegalArgumentException("aux memory limit is negative");
        }
        if (recursionDepthLimit != null && recursionDepthLimit < 0) {
            throw new IllegalArgumentException("recursion limit is negative");
        }
        if (timeLimit != null && timeLimit < 0) {
            throw new IllegalArgumentException("time limit is negative");
        }
        _itemsCount = itemsCount;
        _auxMemoryLimit = auxMemoryLimit;
        _recursionLimit = recursionDepthLimit;
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
    public Integer getAuxMemoryLimit() {
        return _auxMemoryLimit;
    }

    /**
     * Gets recursive call depth limit.
     *
     * @return recursion limit.
     */
    public Integer getRecursionLimit() {
        return _recursionLimit;
    }

    /**
     * Gets time limit in milliseconds.
     *
     * @return time limit.
     */
    public Integer getTimeLimit() {
        return _timeLimit;
    }

    @Override
    public String toString() {
        StringBuilder state = new StringBuilder();
        state.append(String.format("items count: %s, ", _itemsCount));
        state.append(String.format("aux memory limit: %s, ", _auxMemoryLimit));
        state.append(String.format("recursion limit: %s, ", _recursionLimit));
        state.append(String.format("time limit: %s", _timeLimit));
        return String.format("[sort task: {%s}]", state);
    }
}
