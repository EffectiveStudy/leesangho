package com.github.sangholee.dev.effectivejavastudy.study06_item34;

public class ConstructorOrder {

    private static final int NUM = bindNum();

    private static int bindNum() {
        return 1;
    }

    private int number;

    public ConstructorOrder() {
        this.number = 2;
    }
}
