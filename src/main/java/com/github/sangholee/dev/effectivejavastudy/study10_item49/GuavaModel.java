package com.github.sangholee.dev.effectivejavastudy.study10_item49;

import com.google.common.base.Preconditions;

public class GuavaModel {

    private String name;

    private int age;

    public GuavaModel(String name, int age) {
        Preconditions.checkArgument(age >= 0 , "나이는 0보다 큽니다");
        this.name = name;
        this.age = age;
    }
}
