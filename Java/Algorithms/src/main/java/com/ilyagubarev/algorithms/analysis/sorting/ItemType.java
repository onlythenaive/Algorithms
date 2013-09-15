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
package com.ilyagubarev.algorithms.analysis.sorting;

/**
 * Item model supported types.
 *
 * @version 1.01, 14 September 2013
 * @since 14 September 2013
 * @author Ilya Gubarev
 */
public enum ItemType {

    /**
     * Double type.
     */
    DOUBLE("double type"),

    /**
     * Integer type.
     */
    INTEGER("integer type"),

    /**
     * String type.
     */
    STRING("string type");

    private final String _info;

    private ItemType(String info) {
        _info = info;
    }

    @Override
    public String toString() {
        return _info;
    }
}
