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

import com.ilyagubarev.algorithms.adt.Item;

/**
 * FIFO policy collection common interface.
 *
 * @see ItemCollection
 *
 * @version 1.02, 13 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public interface ItemQueue extends ItemCollection {

    /**
     * Gets the oldest item in the queue.
     *
     * @return the oldest item.
     * @throws IllegalStateException if the queue is empty.
     *
     * @see Item
     */
    Item dequeue();

    /**
     * Adds a new item to the queue.
     *
     * @param item an item to be enqueued.
     *
     * @see Item
     */
    void enqueue(Item item);

    /**
     * Gets the oldest item and removes from the queue.
     *
     * @return the oldest item.
     * @throws IllegalStateException if the queue is empty.
     *
     * @see Item
     */
    Item poll();
}
