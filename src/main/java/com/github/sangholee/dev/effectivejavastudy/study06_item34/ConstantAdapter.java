package com.github.sangholee.dev.effectivejavastudy.study06_item34;

public class ConstantAdapter {

    public static void printApple(int constant) {
        switch (constant) {
            case Constant.APPLE_PIPPIN, Constant.APPLE_FUJI,
                    Constant.APPLE_GRANNY_SMITH -> System.out.println(constant);
            default -> throw new AssertionError("에러 발생");
        }
    }

    public static void printApple(Apple constant) {
        System.out.println(constant);
    }
}
