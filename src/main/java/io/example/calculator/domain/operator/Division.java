package io.example.calculator.domain.operator;

import io.example.calculator.domain.Divisor;

public class Division implements Operator {
    private static final String DIVISION_OPERATOR = "/";

    @Override
    public boolean isMatched(String operator) {
        return operator.equals(DIVISION_OPERATOR);
    }

    @Override
    public int operate(int firstOperand, int secondOperand) {
        Divisor divisor = Divisor.from(secondOperand);
        return firstOperand / divisor.toInt();
    }
}
