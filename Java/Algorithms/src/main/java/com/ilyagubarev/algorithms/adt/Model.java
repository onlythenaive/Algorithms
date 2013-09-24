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
package com.ilyagubarev.algorithms.adt;

import com.ilyagubarev.algorithms.adt.utils.Blocker;

/**
 * Abstract analysis model implementation.
 *
 * @version 1.01, 24 September 2013
 * @since 24 September 2013
 * @author Ilya Gubarev
 */
public abstract class Model {

    private Blocker _blocker;

    protected Model() {
        _blocker = new Blocker();
    }

    /**
     * Gets amount of memory allocated for the model (in abstract units).
     *
     * @return model memory allocation.
     */
    protected abstract int getMemoryAllocation();

    /**
     * Marks the model as desctructed.
     *
     * @return false if the model is already marked as destructed.
     */
    protected final boolean desctruct() {
        return _blocker.activate();
    }

    /**
     * Throws runtime exception if the model is already destructed.
     */
    protected final void throwExceptionIfDestructed() {
        if (_blocker.isActive()) {
            throw new IllegalStateException("model is destructed");
        }
    }
}
