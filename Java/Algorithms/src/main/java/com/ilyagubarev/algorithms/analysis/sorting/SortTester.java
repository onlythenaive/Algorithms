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

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import com.ilyagubarev.algorithms.adt.arrays.ArrayModel;
import com.ilyagubarev.algorithms.adt.arrays.ArrayModelFactory;
import com.ilyagubarev.algorithms.adt.items.ItemModel;
import com.ilyagubarev.algorithms.adt.items.ItemModelFactory;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.utils.Counter;
import com.ilyagubarev.algorithms.adt.utils.Registry;
import com.ilyagubarev.algorithms.adt.utils.Stopwatch;
import com.ilyagubarev.algorithms.analysis.TestStatus;
import com.ilyagubarev.algorithms.sorting.SorterSandbox;
import com.ilyagubarev.algorithms.sorting.methods.Sorter;

/**
 * Sorting method tester.
 *
 * @version 1.02, 30 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class SortTester {

    /**
     * Performs series of sorting method tests.
     *
     * @param tasks test task specifications.
     * @param sorters sorting method implementations.
     * @return test reports.
     *
     * @see Sorter
     * @see SortReport
     * @see SortReportId
     * @see SortTask
     */
    public static Map<SortReportId, SortReport> run(Map<String, SortTask> tasks,
            Map<String, Sorter> sorters) {
        Map<SortReportId, SortReport> result;
        result = new HashMap<SortReportId, SortReport>();
        for (String taskId : tasks.keySet()) {
            final SortTask task = tasks.get(taskId);
            int itemsCount = task.getItemsCount();
            Comparable[] sample = createSample(itemsCount);
            Registry.OnRegisterHandler auxMemoryHandler = createRegistryHandler(task.getAuxMemoryLimit(), "auxillary memory limit exceeded");
            Registry.OnRegisterHandler recursionHandler = createRegistryHandler(task.getRecursionLimit(), "recursion depth limit exceeded");
            Stopwatch.OnCheckHandler timeHandler = createStopwatchHandler(task.getTimeLimit(), "time limit exceeded");
            for (String sorterId : sorters.keySet()) {
                Sorter sorter = sorters.get(sorterId);
                Counter comparisons = new Counter();
                Counter hashings = new Counter();
                Counter tests = new Counter();
                ItemModelFactory itemFactory = new ItemModelFactory(
                        new Registry(0), comparisons, hashings, tests);
                Counter reads = new Counter();
                Counter writes = new Counter();
                ArrayModelFactory factory = new ArrayModelFactory(
                        new Registry(0), reads, writes);
                ArrayModel<ItemModel> target = factory.create(sample.length);
                for (int i = 0; i < sample.length; i++) {
                    target.write(i, itemFactory.create(sample[i]));
                }
                Registry auxAllocs = new Registry(0, auxMemoryHandler);
                Counter auxReads = new Counter();
                Counter auxWrites = new Counter();
                ArrayModelFactory arrayFactory = new ArrayModelFactory(
                        auxAllocs, reads, writes);
                NodeModelFactory nodeFactory = new NodeModelFactory(auxAllocs,
                        reads, writes, auxReads, auxWrites);
                Registry recursions = new Registry(0, recursionHandler);
                Stopwatch stopwatch = new Stopwatch(timeHandler);                
                Exception exception = null;
                try {
                    SorterSandbox.run(sorter, target, null, arrayFactory,
                            nodeFactory, recursions, stopwatch);
                    ItemModel item = target.read(0);
                    ItemModel nextItem;
                    for (int i = 1; i < target.getSize(); i++) {
                        nextItem = target.read(i);
                        if (nextItem.compareTo(item) < 0) {
                            exception = new Exception("target array is not sorted");
                            break;
                        }
                        item = nextItem;
                    }
                } catch (Exception e) {
                    exception = e;
                }
                SortReport report;
                SortReportId id = new SortReportId(sorterId, taskId);
                String sorterInfo = sorter.getInfo();
                if (exception != null) {
                    String statusInfo = exception.getMessage();
                    report = new SortReport(TestStatus.FAILED, statusInfo, task,
                            sorterInfo, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                } else {
                    report = new SortReport(TestStatus.PASSED, "target array is sorted", task,
                            sorterInfo, comparisons.getValue(),
                            hashings.getValue(), tests.getValue(),
                            reads.getValue() - sample.length, writes.getValue() - sample.length,
                            auxAllocs.getValuesCount(),
                            (long) auxAllocs.getMax(),
                            auxReads.getValue(), auxWrites.getValue(),
                            (long) recursions.getMax(),
                            stopwatch.getElapsedTime());
                }
                result.put(id, report);
            }
        }
        return result;
    }

    private static Registry.OnRegisterHandler createRegistryHandler(
            Integer limit, final String message) {
        Registry.OnRegisterHandler result = null;
        if (limit != null) {
            final int value = limit;
            result = new Registry.OnRegisterHandler() {
                @Override
                public void execute(double value, long count, double total,
                        double max, double min, double averageValue,
                        double maxValue, double minValue) {
                    if (max > value) {
                        throw new RuntimeException(message);
                    } 
                }
            };
        }
        return result;
    }

    private static Stopwatch.OnCheckHandler createStopwatchHandler(
            Integer limit, final String message) {
        Stopwatch.OnCheckHandler result = null;
        if (limit != null) {
            final int value = limit;
            result = new Stopwatch.OnCheckHandler() {
                @Override
                public void execute(boolean started, long elapsedTime) {
                    if (elapsedTime > value) {
                        throw new RuntimeException(message);
                    } 
                }
            };
        }
        return result;
    }

    private static Comparable[] createSample(int size) {
        Comparable[] result = new Comparable[size];
        Random random = new Random();
        for (int i = 0; i < size; ++i) {
            result[i] = random.nextInt();
        }
        return result;
    }

    private SortTester() {

    }
}
