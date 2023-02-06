package com.github.sangholee.dev.effectivejavastudy.study07_item39;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {

    @MyExceptionTest2(IndexOutOfBoundsException.class)
    @MyExceptionTest2(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.add(5, null);
    }
}
