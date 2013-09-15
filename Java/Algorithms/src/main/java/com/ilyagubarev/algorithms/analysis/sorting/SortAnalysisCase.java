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

/**
 * Task case for sorting method analyser.
 *
 * @version 1.01, 14 September 2013
 * @since 14 September 2013
 * @author Ilya Gubarev
 */
public final class SortAnalysisCase {

    private final String _id;
    private final int _itemsCount;
    private final ItemType _itemType;
    private final int _auxMemoryLimit;
    private final int _recursionLimit;
    private final int _timeLimit;

    /**
     * 
     *
     * @param id
     * @param itemsCount
     * @param itemType
     * @param auxMemoryLimit
     * @param recursionLimit
     * @param timeLimit 
     *
     * @see ItemType
     */
    public SortAnalysisCase(String id, int itemsCount, ItemType itemType,
            int auxMemoryLimit, int recursionLimit, int timeLimit) {
        _id = id;
        _itemsCount = itemsCount;
        _itemType = itemType;
        _auxMemoryLimit = auxMemoryLimit;
        _recursionLimit = recursionLimit;
        _timeLimit = timeLimit;
    }

    /**
     * 
     *
     * @return 
     */
    public String getId() {
        return _id;
    }

    /**
     * 
     *
     * @return 
     */
    public int getItemsCount() {
        return _itemsCount;
    }

    /**
     * 
     *
     * @return 
     *
     * @see ItemType
     */
    public ItemType getItemType() {
        return _itemType;
    }

    /**
     * 
     *
     * @return 
     */
    public int getAuxMemoryLimit() {
        return _auxMemoryLimit;
    }

    /**
     * 
     *
     * @return 
     */
    public int getRecursionLimit() {
        return _recursionLimit;
    }

    /**
     * 
     *
     * @return 
     */
    public int getTimeLimit() {
        return _timeLimit;
    }
}
