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
package com.ilyagubarev.algorithms.adt.collections.stacks;

import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.collections.StackModel;
import com.ilyagubarev.algorithms.adt.nodes.ListNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.iterators.ListNodeIterator;

/**
 * Simple StackModel implementation based on list node models.
 *
 * @see StackModel
 *
 * @version 1.05, 19 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleStackModel<T> implements StackModel<T> {

    private final NodeModelFactory _factory;

    private int _size;
    private ListNodeModel<T> _top;

    /**
     * Creates a new instance of SimpleStackModel.
     *
     * @param factory node model provider.
     *
     * @see NodeModelFactory
     */
    public SimpleStackModel(NodeModelFactory factory) {
        if (factory == null) {
            throw new NullPointerException("item nodes provider is null");
        }
        _factory = factory;
    }

    @Override
    public int getSize() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListNodeIterator<T>(_top);
    }

    @Override
    public T peek() {
        throwExceptionIfEmpty();
        return _top.getItem();
    }

    @Override
    public T pop() {
        throwExceptionIfEmpty();
        ListNodeModel<T> buffer = _top;
        _top = _top.getNext();
        --_size;
        return buffer.getItem();
    }

    @Override
    public void push(T item) {
        ListNodeModel<T> buffer = _top;
        _top = _factory.createListNode(item);
        _top.setNext(buffer);
        ++_size;
    }

    private void throwExceptionIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }
}
