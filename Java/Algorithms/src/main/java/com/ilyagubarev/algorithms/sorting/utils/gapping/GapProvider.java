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
package com.ilyagubarev.algorithms.sorting.utils.gapping;

import java.util.List;

/**
 * Gap value provider for D. Shell method sorting algorithm.
 *
 * @version 1.01, 12 September 2013
 * @since 12 September 2013
 * @author Ilya Gubarev
 */
public abstract class GapProvider {

    private int _current;
    private boolean _inited;
    private List<Integer> _sequence;

    protected GapProvider() {

    }

    /**
     * Gets the next gap value.
     *
     * @return gap value.
     */
    public final int getNext() {
        if (!_inited) {
            throw new IllegalStateException("provider is not inited");
        }
        if (_current == _sequence.size()) {
            throw new IllegalStateException("out of gaps");
        }
        return _sequence.get(_current++);
    }

    /**
     * Resets the provider.
     *
     * @param n total amount of items to be sorted.
     * @throws IllegalArgumentException if total amount is not positive.
     * @throws IllegalStateException if no gaps are generated.
     */
    public final void reset(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("total amount is not positive");
        }
        List<Integer> sequence = getSequence(n);
        if (sequence.size() < 1) {
            throw new IllegalStateException("no gaps are generated");
        }
        _sequence = sequence;
        _current = 0;
        _inited = true;
    }

    /**
     * Gets a list of values to be used as gaps (f.e. "N/2", "N/4", ..., "1").
     *
     * @param n total amount of items to be sorted.
     * @return a sequence of gap values.
     */
    protected abstract List<Integer> getSequence(int n);
}
