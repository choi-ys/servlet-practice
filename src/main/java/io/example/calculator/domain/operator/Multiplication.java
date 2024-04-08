package io.example.calculator.domain.operator;

public class Multiplication implements Operator {
    private static final String MULTIPLICATION_OPERATOR = "*";

    @Override
    public boolean isMatched(String operator) {
        return operator.equals(MULTIPLICATION_OPERATOR);
    }

    @Override
    public int operate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
