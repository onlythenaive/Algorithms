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

import java.io.Serializable;

/**
 *
 * @author gubarev
 */
public final class SortReport implements Serializable {

    static SortReport create(SortReportId id, SortTask task) {
        throw new UnsupportedOperationException();
    }

    private final SortReportId _id;
    private final SortTask _task;

    private SortReport(SortReportId id, SortTask task) {
        _id = id;
        _task = task;
    }
}
