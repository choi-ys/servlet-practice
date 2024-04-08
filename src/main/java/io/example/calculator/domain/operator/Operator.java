package io.example.calculator.domain.operator;

public interface Operator {
    boolean isMatched(String operator);
    int operate(int firstOperand, int secondOperand);
}
