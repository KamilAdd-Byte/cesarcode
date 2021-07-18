package com.bazarek.bazarek.service;

import java.util.function.DoubleBinaryOperator;

/**
 * wyliczenie z polami obiektów funkcyjnych i unikatowym działaniu
 * @author Bloch s.215
 */
public enum Operation {
    PLUS("+", Double::sum),
    MINUS("-", (x,y) -> x - y),
    TIMES("*", (x,y) -> x * y),
    DIVIDE("/", (x,y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }
    public double apply (double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
