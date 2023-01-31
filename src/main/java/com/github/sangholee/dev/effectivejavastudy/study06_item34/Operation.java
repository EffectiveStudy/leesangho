package com.github.sangholee.dev.effectivejavastudy.study06_item34;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum Operation {

    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    // 자신의 인스턴스를 생성자에서 등록 할 수 없고
    // 열거타입 생성후 정적 필드가 초기화될 때 열거타입 인스턴스 맵이 등록 됨
    private static final Map<String, Operation> stringToEnum = bindEnumMap();

    private static Map<String, Operation> bindEnumMap() {
        return Stream.of(values()).collect(
                toMap(Object::toString, e -> e));
    }

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static Optional<Operation> fromSymbolString(String symbol) {
        return Arrays.stream(values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst();
    }



    @Override
    public String toString() {
        return symbol;
    }

}
