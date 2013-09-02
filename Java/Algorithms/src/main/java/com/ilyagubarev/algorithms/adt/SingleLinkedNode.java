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

/**
 * Single linked implementation of a list node.
 *
 * @see ListNode
 *
 * @version 1.01, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class SingleLinkedNode<E> implements ListNode<E> {

    private E _item;
    private ListNode<E> _next;

    /**
     * Creates a new instance of SingleLinkedNode.
     *
     * @param item contained item.
     */
    public SingleLinkedNode(E item) {
        _item = item;
    }

    @Override
    public E getItem() {
        return _item;
    }

    @Override
    public ListNode<E> getNext() {
        return _next;
    }

    @Override
    public ListNode<E> getPrevious() {
        return null;
    }

    @Override
    public void setItem(E item) {
        _item = item;
    }

    @Override
    public void setNext(ListNode<E> node) {
        _next = node;
    }

    @Override
    public void setPrevious(ListNode<E> node) {

    }
}
