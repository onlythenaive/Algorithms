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
package com.ilyagubarev.algorithms.utils;

import java.io.IOException;
import java.io.Reader;
import java.util.Set;
import java.util.HashSet;

/**
 * Character input stream tokenizer.
 *
 * @version 1.01, 11 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class SourceTokenizer {

    private final Reader _source;
    private final Set<Character> _delimiters;

    private boolean _depleted;

    /**
     * Creates a new instance of SourceTokenizer.
     *
     * @param source a character input stream.
     * @param delimiters character sequence delimiters.
     * @return a new instance of SourceTokenizer.
     */
    public static SourceTokenizer create(Reader source, char ... delimiters) {
        Set<Character> delimiterSet = new HashSet<Character>();
        for (char d : delimiters) {
            delimiterSet.add(d);
        }
        return new SourceTokenizer(source, delimiterSet);
    }

    private SourceTokenizer(Reader source, Set<Character> delimiters) {
        _source = source;
        _delimiters = delimiters;
    }

    /**
     * Reads the source until it is depleted or any delimiter is found.
     *
     * @return a string token read from the source.
     * @throws IOException if error occured while reading the source.
     */
    public String getNext() throws IOException {
        StringBuilder result = new StringBuilder();
        while (!_depleted) {
            int read = _source.read();
            if (read < 0) {
                _depleted = true;
                break;
            }
            char symbol = (char) read;
            if (_delimiters.contains(symbol)) {
                if (result.length() == 0) {
                    continue;
                }
                break;
            }
            result.append(symbol);
        }
        return result.toString();
    }

    /**
     * Checks if the source contains no more characters to read.
     *
     * @return true if the source contains no more characters.
     */
    public boolean isDepleted() {
        return _depleted;
    }
}
