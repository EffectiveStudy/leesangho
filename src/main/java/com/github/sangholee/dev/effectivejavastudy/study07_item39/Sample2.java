package com.github.sangholee.dev.effectivejavastudy.study07_item39;

public class Sample2 {

    @MyExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    @MyExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    @MyExceptionTest(ArithmeticException.class)
    public static void m3() {
    }
}
