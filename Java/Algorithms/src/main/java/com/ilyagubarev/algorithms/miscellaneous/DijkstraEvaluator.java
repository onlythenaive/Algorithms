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
package com.ilyagubarev.algorithms.miscellaneous;

import java.io.IOException;
import java.io.Reader;

import com.ilyagubarev.algorithms.adt.ItemsStack;
import com.ilyagubarev.algorithms.adt.SimpleLinkedStack;
import com.ilyagubarev.algorithms.utils.SourceTokenizer;

/**
 *
 * @author Ilya Gubarev.
 */
public class DijkstraEvaluator {

    /**
     * Creates a new instance of DijkstraEvaluator.
     */
    public DijkstraEvaluator() {
        
    }

    public double eval(Reader expression) throws IOException {
        ItemsStack<Double> operands = new SimpleLinkedStack<Double>();
        ItemsStack<String> operators = new SimpleLinkedStack<String>();
        SourceTokenizer tokenizer = SourceTokenizer.create(expression, ' ');
        while (!tokenizer.isDepleted()) {
            String token = tokenizer.getNext();
            if (token.equals(")")) {
                double result;
                String operator = operators.pop();
                double op2 = operands.pop();
                double op1 = operands.pop();
                if (operator.equals("+")) {
                    result = op1 + op2;
                } else if (operator.equals("-")) {
                    result = op1 - op2;
                } else if (operator.equals("*")) {
                    result = op1 * op2;
                } else if (operator.equals("/")) {
                    result = op1 / op2;
                } else {
                    throw new UnsupportedOperationException("unsupported operator");
                }
                operands.push(result);
            } else if (isOperator(token)) {
                operators.push(token);
            } else if (token.equals("(")) {
                
            } else {
                operands.push(Double.valueOf(token));
            }
        }
        if (!operators.isEmpty() || (operands.getSize() > 1)) {
            throw new RuntimeException("expression evaluating error");
        }
        return operands.pop();
    }

    private boolean isOperator(String token) {
        return (token.equals("+")) || (token.equals("-")) || (token.equals("/")) || (token.equals("*"));
    }
}
