package com.github.sangholee.dev.effectivejavastudy.study07_item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RuntTests2 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        final Class<?> testClass = Class.forName(args[0]);

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyExceptionTest.class)) {
                tests ++;
                try {
                    method.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", method);
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    Class<? extends Throwable> excType = method.getAnnotation(MyExceptionTest.class).value();

                    if (excType.isInstance(throwable)) {
                        passed ++;
                    } else {
                        System.out.printf("테스트 %s 실패: 기대한 예외 %s, 발생한 예외 %s%n", method, excType, throwable);
                    }

                } catch (Exception e) {
                    System.out.println("잘못 사용한 @MyExceptionTest: "+ method);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
