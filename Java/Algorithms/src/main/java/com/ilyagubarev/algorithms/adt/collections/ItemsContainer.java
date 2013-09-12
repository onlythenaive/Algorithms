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

import java.io.Serializable;

/**
 * Items container common interface.
 *
 * @see Iterable
 * @see Serializable
 *
 * @version 1.01, 03 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public interface ItemsContainer<E> extends Iterable<E>, Serializable {

    /**
     * Gets current size of the container.
     *
     * @return current size.
     */
    int getSize();

    /**
     * Checks if the container is empty.
     *
     * @return true if the container is empty.
     */
    boolean isEmpty();    
}
