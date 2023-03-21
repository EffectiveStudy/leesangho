package com.github.sangholee.dev.effectivejavastudy.study12_item63;

public class JavaVersion {
    public static void main(String[] args) {
        String a = "a";
        String b = "1234555";
        System.out.println(a+b+"123455"+1);
        System.out.println("안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"안녕, "+"끝!");

//컴파일시 이렇게 된다. 1이나 문자열이 그냥 아예 한 문자열로 붙혀져서 처리된다.

        System.out.println(a + b + "1234551");
        System.out.println("안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 안녕, 끝!");
    }
}
