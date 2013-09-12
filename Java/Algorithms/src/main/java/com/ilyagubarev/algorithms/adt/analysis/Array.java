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
package com.ilyagubarev.algorithms.adt.analysis;

import com.ilyagubarev.algorithms.adt.tools.Counter;

/**
 * Comparable items array model for sorting methods analysis.
 *
 * @version 1.02, 12 September 2013
 * @since 12 September 2013
 * @author Ilya Gubarev
 */
public class Array {

    private final String _id;
    private final Comparable[] _source;
    private final Counter _reads;
    private final Counter _writes;
    private final Counter _tests;

    /**
     * Creates a new instance of Array from the source array.
     *
     * @param id an identifier.
     * @param source a source array.
     */
    public Array(String id, Comparable[] source) {
        if (id == null) {
            throw new NullPointerException("identifier is null");
        }
        if (source == null) {
            throw new NullPointerException("source array is null");
        }
        _id = id;
        _source = source;
        _reads = new Counter();
        _writes = new Counter();
        _tests = new Counter();
    }

    /**
     * Gets array model identifier.
     *
     * @return identifier.
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets total amount of items in the array model.
     *
     * @return total amount of items.
     */
    public int getSize() {
        return _source.length;
    }

    /**
     * Gets total amount of read operations on the array model.
     *
     * @return total amount of read operations.
     */
    public long getReadsCount() {
        return _reads.getValue();
    }

    /**
     * Gets total amount of write operations on the array model.
     *
     * @return total amount of write operations.
     */
    public long getWritesCount() {
        return _writes.getValue();
    }

    /**
     * Gets total amount of comparisons operations on the array model.
     *
     * @return total amount of write operations.
     */
    public long getTestsCount() {
        return _tests.getValue();
    }

    /**
     * 
     *
     * @return 
     */
    public boolean isSorted() {
        if (_source.length == 1) {
            return true;
        }
        for (int i = 0; i < _source.length - 1; ++i) {
            if (_source[i].compareTo(_source[i + 1]) > 0) {
                return false;
            }
        }
        return false;
    }

    /**
     * 
     *
     * @param index
     * @param auxillary
     * @param auxIndex 
     */
    public void get(int index, AuxMemory auxillary, int auxIndex) {
        write(index, (Comparable) auxillary.read(auxIndex));
    }

    /**
     * 
     *
     * @param index
     * @param auxillary
     * @param auxIndex 
     */
    public void set(int index, AuxMemory auxillary, int auxIndex) {
        auxillary.write(auxIndex, read(index));
    }

    /**
     * Exchanges two items of specified indeces with each other.
     *
     * @param first an index of the first item.
     * @param second an index of the second item.
     * @throws RuntimeException if specified indeces are illegal.
     */
    public void swap(int first, int second) {
        Comparable buffer = read(first);
        write(first, read(second));
        write(second, buffer);
    }

    /**
     * Checks if the subject is less than the sample.
     *
     * @param subject an index of the subject.
     * @param sample an index of the sample.
     * @return true, if the subject is less than the sample.
     * @throws RuntimeException if specified indeces are illegal.
     */
    public boolean less(int subject, int sample) {
        _tests.increment();
        return read(subject).compareTo(read(sample)) < 0;
    }

    /**
     * Checks if the subject is less than the sample in an auxillary memory.
     *
     * @param subject an index of the subject.
     * @param auxillary an auxillary memory.
     * @param auxSample an index of the sample in an auxillary memory.
     * @return true, if the subject is less than the sample.
     * @throws RuntimeException if specified indeces are illegal.
     */
    public boolean less(int subject, AuxMemory auxillary, int auxSample) {
        _tests.increment();
        return read(subject).compareTo(auxillary.read(auxSample)) < 0;
    }

    @Override
    public String toString() {
        StringBuilder contents = new StringBuilder();
        contents.append("{");
        for (int i = 0; i < _source.length - 1; ++i) {
            contents.append(_source[i].toString());
            contents.append("; ");
        }
        contents.append("}");
        return String.format("[array (%s): %s]", _id, contents);
    }

    private Comparable read(int index) {
        _reads.increment();
        return _source[index];
    }

    private void write(int index, Comparable item) {
        _writes.increment();
        _source[index] = item;
    }
}
