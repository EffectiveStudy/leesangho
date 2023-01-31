package com.github.sangholee.dev.effectivejavastudy.study06_item34;

import java.util.function.BiFunction;

public enum OperationLambda {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;

    private final BiFunction<Double, Double, Double> calculateLogic;

    OperationLambda(String symbol, BiFunction<Double, Double, Double> calculateLogic) {
        this.symbol = symbol;
        this.calculateLogic = calculateLogic;
    }

    public double apply(double x, double y) {
        return calculateLogic.apply(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
