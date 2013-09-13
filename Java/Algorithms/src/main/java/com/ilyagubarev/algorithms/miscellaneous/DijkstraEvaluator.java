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
import java.util.Stack;

import com.ilyagubarev.algorithms.utils.SourceTokenizer;

/**
 * Simple arithmetic expression evaluator.
 * Based on E. Dijkstra "double stack" algorithm. The expression must be
 * fully braced and each bracet, operand or operator must be spaced from
 * another, for example: "( ( 1 + 2.5 ) / 4 )". Only four basic
 * operators ("+", "-", "*", "/") are allowed. 
 *
 * @version 1.03, 13 September 2013
 * @since September 2013
 * @author Ilya Gubarev.
 */
public final class DijkstraEvaluator {

    /**
     * Evaluates the result of a source expression.
     *
     * @param expression a source expression.
     * @return expression evaluation result.
     * @throws IOException if error occured while reading the expression.
     * @throws RuntimeException if the expression is malformed.
     */
    public static double eval(Reader expression) throws IOException {
        Stack<Double> operands = new Stack<Double>();
        Stack<String> operators = new Stack<String>();
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
                    throw new RuntimeException("unsupported operator");
                }
                operands.push(result);
            } else if ((token.equals("+")) || (token.equals("-"))
                    || (token.equals("*")) || (token.equals("/"))) {
                operators.push(token);
            } else if (!token.equals("(")) {
                operands.push(Double.valueOf(token));
            }
        }
        if (!operators.isEmpty() || (operands.size() > 1)) {
            throw new RuntimeException("expression evaluating error");
        }
        return operands.pop();
    }

    private DijkstraEvaluator() {

    }
}
