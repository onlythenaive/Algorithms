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
 * Linked list node.
 *
 * @see Serializable
 *
 * @version 1.02, 03 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class ListNode<E> implements Serializable {

    private E _item;
    private ListNode<E> _next;

    /**
     * Creates a new instance of ListNode.
     *
     * @param item a containing item.
     */
    public ListNode(E item) {
        _item = item;
    }

    /**
     * Gets a containing item.
     *
     * @return a contained item.
     */
    public E getItem() {
        return _item;
    }

    /**
     * Gets a reference to the next node.
     *
     * @return the next node.
     */
    public ListNode<E> getNext() {
        return _next;
    }

    /**
     * Sets a new containing item.
     *
     * @param item an item to be contained.
     */
    public void setItem(E item) {
        _item = item;
    }

    /**
     * Sets a reference to the next node.
     *
     * @param node the next node.
     */
    public void setNext(ListNode<E> node) {
        _next = node;
    }

    @Override
    public String toString() {
        return String.format("[list node: %s]", _item);
    }
}
