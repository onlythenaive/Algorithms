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
package com.ilyagubarev.algorithms.adt.collections.bags;

import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.ItemModel;
import com.ilyagubarev.algorithms.adt.collections.BagModel;
import com.ilyagubarev.algorithms.adt.collections.StackModel;
import com.ilyagubarev.algorithms.adt.collections.stacks.SimpleStackModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;

/**
 * Simple BagModel implementation based on StackModel.
 *
 * @see BagModel
 *
 * @version 1.02, 19 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleBagModel<E> implements BagModel<E> {

    private final StackModel<E> _stack;

    /**
     * Creates a new instance of SimpleBagModel.
     *
     * @param factory node model provider.
     *
     * @see NodeModelFactory
     */
    public SimpleBagModel(NodeModelFactory factory) {
        _stack = new SimpleStackModel<E>(factory);
    }

    @Override
    public int getSize() {
        return _stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return _stack.isEmpty();
    }

    @Override
    public void add(E item) {
        _stack.push(item);
    }

    @Override
    public Iterator<E> iterator() {
        return _stack.iterator();
    }
}
