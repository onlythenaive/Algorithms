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
package com.ilyagubarev.algorithms.adt.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.ilyagubarev.algorithms.adt.collections.StackModel;
import com.ilyagubarev.algorithms.adt.collections.stacks.SimpleStackModel;
import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;

/**
 * Iterator over binary tree node models.
 *
 * @see BinaryNodeModel
 * @see Iterator
 *
 * @version 1.04, 20 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class BinaryNodeModelIterator<E> implements Iterator<E> {

    private final StackModel<BinaryNodeModel<E>> _passed;

    private BinaryNodeModel<E> _next;

    /**
     * Creates a new instance of BinaryNodeModelIterator.
     *
     * @param root a root node.
     * @param factory a node model factory.
     *
     * @see BinaryNodeModel
     * @see NodeModelFactory
     */
    public BinaryNodeModelIterator(BinaryNodeModel<E> root,
            NodeModelFactory factory) {
        _passed = new SimpleStackModel<BinaryNodeModel<E>>(factory);
        passToLeft(root);
    }

    @Override
    public boolean hasNext() {
        return _next != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException("iterator has no next element");
        }
        E result = _next.getItem();
        BinaryNodeModel<E> node = _next.getRightChild();
        if (node != null) {
            passToLeft(node);            
        } else {
            while (!(_passed.isEmpty() || _next == _passed.pop())) {
                _next = _next.getParent();
            }
        }
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("removal is not supported");
    }

    private void passToLeft(BinaryNodeModel<E> node) {
        while (node != null) {
            _passed.push(node);
            node = node.getLeftChild();
        }
        _next = _passed.pop();
    }
}
