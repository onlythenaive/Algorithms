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
 * Simple list node.
 *
 * @see Serializable
 *
 * @version 1.01, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
interface ListNode<E> extends Serializable {

    /**
     * Gets a contained item.
     *
     * @return contained item.
     */
    E getItem();

    /**
     * Gets a reference to the next node in a list.
     *
     * @return next node.
     */
    ListNode<E> getNext();

    /**
     * Gets a reference to the previous node in a list. If a concrete
     * implementation does not support backward linkage null will be returned.
     *
     * @return previous node.
     */
    ListNode<E> getPrevious();

    /**
     * Sets a new contatined item.
     *
     * @param item contained item.
     */
    void setItem(E item);

    /**
     * Sets a reference to the next node in a list.
     *
     * @param node next node.
     */
    void setNext(ListNode<E> node);

    /**
     * Sets a reference to the previous node in a list. If a concrete
     * implementation does not support backward linkage node will be ignored.
     *
     * @param node previous node.
     */
    void setPrevious(ListNode<E> node);
}
