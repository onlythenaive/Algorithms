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

import java.io.Serializable;

/**
 * Simple FIFO policy collection.
 *
 * @see Serializable
 *
 * @version 1.01, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleStack<E> implements Serializable {

    /**
     * Creates a new instance of Stack.
     */
    public SimpleStack() {

    }

    public E peek() {
        throw new UnsupportedOperationException();
    }

    public E pop() {
        throw new UnsupportedOperationException();
    }

    public void push(E item) {
        throw new UnsupportedOperationException();
    }
}