package com.github.sangholee.dev.effectivejavastudy.study07_item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(MyExceptionTestContainer.class)
public @interface MyExceptionTest2 {
    Class<? extends Throwable> value();
}
