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
package com.ilyagubarev.algorithms.adt.impl;

import java.io.Serializable;

/**
 * Single linked node.
 *
 * @see Serializable
 *
 * @version 1.02, 02 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
final class SingleLinkedNode<E> implements Serializable {

    private E _item;
    private SingleLinkedNode<E> _next;

    /**
     * Creates a new instance of SingleLinkedNode.
     *
     * @param item a contained item.
     */
    public SingleLinkedNode(E item) {
        _item = item;
    }

    /**
     * Gets a contained item.
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
    public SingleLinkedNode<E> getNext() {
        return _next;
    }

    /**
     * Sets a new contatined item.
     *
     * @param item a item to be contained.
     */
    public void setItem(E item) {
        _item = item;
    }

    /**
     * Sets a reference to the next node.
     *
     * @param node a node.
     */
    public void setNext(SingleLinkedNode<E> node) {
        _next = node;
    }
}
