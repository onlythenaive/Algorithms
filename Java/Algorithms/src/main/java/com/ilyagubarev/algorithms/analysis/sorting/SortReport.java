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
 * 
 *
 * @author gubarev
 */
public final class SortReport implements Serializable {

    private final TestStatus _status;
    private final String _statusInfo;
    private final SortTask _task;
    private final String _sorterInfo;
    private final long _comparisons;
    private final long _hashings;
    private final long _tests;
    private final long _reads;
    private final long _writes;
    private final long _auxAllocations;
    private final long _auxAllocationPeak;
    private final long _auxAllocationTotal;
    private final long _auxReads;
    private final long _auxWrites;
    private final long _recursionPeak;
    private final long _time;

    private SortReport() {
        
    }
}
