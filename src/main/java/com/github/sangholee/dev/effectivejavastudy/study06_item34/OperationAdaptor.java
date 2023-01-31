package com.github.sangholee.dev.effectivejavastudy.study06_item34;

public class OperationAdaptor {

    public static Operation inverse(Operation op) {
        return switch (op) {
            case PLUS -> Operation.MINUS;
            case MINUS -> Operation.PLUS;
            case TIMES -> Operation.DIVIDE;
            case DIVIDE -> Operation.TIMES;
            default -> throw new AssertionError("잘못된 연산");
        };
    }
}
