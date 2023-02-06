package com.github.sangholee.dev.effectivejavastudy.study07_item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RuntTests3 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        final Class<?> testClass = Class.forName(args[0]);

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyExceptionTest2.class)
                    || method.isAnnotationPresent(MyExceptionTestContainer.class) ) {
                tests ++;
                try {
                    method.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", method);
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    int oldPassed = passed;
                    MyExceptionTest2[] excTests = method.getAnnotationsByType(MyExceptionTest2.class);

                    for (MyExceptionTest2 excTest : excTests) {
                        if (excTest.value().isInstance(throwable)) {
                            passed ++;
                            break;
                        }
                    }

                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패: %s %n", method, throwable);
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @MyExceptionTest2: "+ method);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
