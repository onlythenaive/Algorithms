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
package com.ilyagubarev.algorithms.adt.collections;

import com.ilyagubarev.algorithms.adt.tools.Counter;

/**
 *
 * @author gubarev
 */
public class AuxMemory {

    private final String _id;
    private final Counter _allocations;
    private final Counter _reads;
    private final Counter _writes;
    private final Counter _tests;

    private int _maxAllocation;
    private int _totalAllocation;
    private Object[] _pool;

    /**
     * 
     *
     * @param id 
     */
    public AuxMemory(String id) {
        if (id == null) {
            throw new NullPointerException("identifier is null");
        }
        _id = id;
        _allocations = new Counter();
        _reads = new Counter();
        _writes = new Counter();
        _tests = new Counter();        
    }

    public void allocate(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("allocation size is negative");
        }
        _allocations.increment();
        if (_maxAllocation < size) {
            _maxAllocation = size;
        }
        _totalAllocation = _totalAllocation + size;
        _pool = new Object[size];
    }

    public int getSize() {
        throwExceptionIfNotAllocated();
        return _pool.length;
    }

    public long getAllocationsCount() {
        return _allocations.getValue();
    }

    public long getMaximumAllocation() {
        return _maxAllocation;
    }

    public long getTotalAllocation() {
        return _totalAllocation;
    }

    public long getReadsCount() {
        return _reads.getValue();
    }

    public long getWritesCount() {
        return _writes.getValue();
    }

    public long getTestsCount() {
        return _tests.getValue();
    }

    public boolean isAllocated() {
        return _pool == null;
    }

    public boolean less(int subject, int sample) {
        _tests.increment();
        return ((Comparable) read(subject)).compareTo(read(sample)) < 0;
    }

    public <T> T read(int index) {
        throwExceptionIfNotAllocated();
        _reads.increment();
        return (T) _pool[index];
    }

    public void write(int index, Object data) {
        throwExceptionIfNotAllocated();
        _writes.increment();
        _pool[index] = data;
    }

    private void throwExceptionIfNotAllocated() {
        if (_pool == null) {
            throw new IllegalStateException("memory is not allocated");
        }
    }
}
