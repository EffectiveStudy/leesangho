package com.github.sangholee.dev.effectivejavastudy.study07_item39;

public class Sample {

    @MyTest
    public static void m1() {
    }

    public static void m2() {
    }


    @MyTest
    public static void m3() {
        throw new RuntimeException("실패");
    }

    public static void m4() {
    }

    @MyTest
    public void m5() {
    }

    public static void m6() {
    }


    @MyTest
    public static void m7() {
        throw new RuntimeException("실패");
    }


    public static void m8() {
    }
}
