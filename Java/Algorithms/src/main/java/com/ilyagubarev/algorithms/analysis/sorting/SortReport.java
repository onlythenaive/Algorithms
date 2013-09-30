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

import com.ilyagubarev.algorithms.analysis.TestStatus;

/**
 * Sorting method test report.
 *
 * @see Serializable
 *
 * @version 1.02, 30 September 2013
 * @since 21 September 2013
 * @author Ilya Gubarev
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
    private final long _auxAllocs;
    private final long _auxAllocPeak;
    private final long _auxReads;
    private final long _auxWrites;
    private final long _recursionPeak;
    private final long _time;

    /**
     * Creates a new instance of SortReport.
     *
     * @param status test status.
     * @param statusInfo test text description.
     * @param task test task specification.
     * @param sorterInfo sorting method description.
     * @param comparisons item comparison operations.
     * @param hashings item hashing operations.
     * @param tests item test operations.
     * @param reads array read operations.
     * @param writes array write operations.
     * @param auxAllocs auxillary memory allocation operations.
     * @param auxAllocPeak auxillary memory allocation peak.
     * @param auxReads auxillary memory write operations.
     * @param auxWrites auxillary memory write operations.
     * @param recursionPeak recursive call peak.
     * @param time consumed time in milliseconds.
     *
     * @see SortTask
     * @see TestStatus
     */
    SortReport(TestStatus status, String statusInfo, SortTask task,
            String sorterInfo, long comparisons, long hashings, long tests,
            long reads, long writes, long auxAllocs, long auxAllocPeak,
            long auxReads, long auxWrites, long recursionPeak, long time) {
        _status = status;
        _statusInfo = statusInfo;
        _task = task;
        _sorterInfo = sorterInfo;
        _comparisons = comparisons;
        _hashings = hashings;
        _tests = tests;
        _reads = reads;
        _writes = writes;
        _auxAllocs = auxAllocs;
        _auxAllocPeak = auxAllocPeak;
        _auxReads = auxReads;
        _auxWrites = auxWrites;
        _recursionPeak = recursionPeak;
        _time = time;
    }

    /**
     * Gets test status.
     *
     * @return status.
     *
     * @see TestStatus
     */
    public TestStatus getStatus() {
        return _status;
    }

    /**
     * Gets test status short description.
     *
     * @return status description.
     */
    public String getStatusInfo() {
        return _statusInfo;
    }

    /**
     * Gets sorting test task specification.
     *
     * @return task specification.
     *
     * @see SortTask
     */
    public SortTask getTask() {
        return _task;
    }

    /**
     * Gets target sorting method short description.
     *
     * @return sorting method description.
     */
    public String getSorterInfo() {
        return _sorterInfo;
    }

    /**
     * Gets item comparison operations count.
     *
     * @return comparison operations.
     */
    public long getComparisons() {
        return _comparisons;
    }

    /**
     * Gets item hashing operations count.
     *
     * @return hashing operations.
     */
    public long getHashings() {
        return _hashings;
    }

    /**
     * Gets item test operations count.
     *
     * @return test operations.
     */
    public long getTests() {
        return _tests;
    }

    /**
     * Gets array read operations count.
     *
     * @return read operations.
     */
    public long getReads() {
        return _reads;
    }

    /**
     * Gets array write operations count.
     *
     * @return write operations.
     */
    public long getWrites() {
        return _writes;
    }

    /**
     * Gets auxillary memory allocations count.
     *
     * @return auxillary memory allocations.
     */
    public long getAuxAllocations() {
        return _auxAllocs;
    }

    /**
     * Gets auxillary memory allocation peak.
     *
     * @return auxillary memory allocation peak.
     */
    public long getAuxAllocationPeak() {
        return _auxAllocPeak;
    }

    /**
     * Gets auxillary memory read operations.
     *
     * @return auxillary memory read operations.
     */
    public long getAuxReads() {
        return _auxReads;
    }

    /**
     * Gets auxillary memory write operations.
     *
     * @return auxillary memory write operations.
     */
    public long getAuxWrites() {
        return _auxWrites;
    }

    /**
     * Gets recursive call peak.
     *
     * @return recursion peak.
     */
    public long getRecursionPeak() {
        return _recursionPeak;
    }

    /**
     * Gets consumed time in milliseconds.
     *
     * @return consumed time.
     */
    public long getTime() {
        return _time;
    }
}
