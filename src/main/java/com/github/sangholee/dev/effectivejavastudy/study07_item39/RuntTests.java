package com.github.sangholee.dev.effectivejavastudy.study07_item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RuntTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        final Class<?> testClass = Class.forName(args[0]);

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyTest.class)) {
                tests ++;
                try {
                    method.invoke(null);
                    passed ++;
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    System.out.println(method + " 실패: " + throwable);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @MyTest: "+ method);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
