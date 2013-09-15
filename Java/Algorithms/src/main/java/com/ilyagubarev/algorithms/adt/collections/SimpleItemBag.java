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

import java.util.Iterator;

import com.ilyagubarev.algorithms.adt.Item;
import com.ilyagubarev.algorithms.adt.ItemNodeFactory;

/**
 * Simple ItemBag implementation based on ItemStack.
 *
 * @see ItemBag
 *
 * @version 1.01, 15 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class SimpleItemBag implements ItemBag {

    private final ItemStack _stack;

    /**
     * Creates a new instance of SimpleItemBag.
     *
     * @param factory item nodes provider.
     *
     * @see ItemNodeFactory
     */
    public SimpleItemBag(ItemNodeFactory factory) {
        _stack = new SimpleItemStack(factory);
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
    public void add(Item item) {
        _stack.push(item);
    }

    @Override
    public Iterator<Item> iterator() {
        return _stack.iterator();
    }
}
