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

import java.util.Map;

import com.ilyagubarev.algorithms.sorting.methods.Sorter;

/**
 *
 * @author gubarev
 */
public final class SortTester {

    /**
     * 
     *
     * @param tasks
     * @param sorters
     * @return 
     *
     * @see Sorter
     * @see SortReport
     * @see SortReportId
     * @see SortTask
     */
    public static Map<SortReportId, SortReport> run(Map<String, SortTask> tasks,
            Map<String, Sorter> sorters) {
        throw new UnsupportedOperationException();
    }

    private SortTester() {

    }
}
