package com.github.sangholee.dev.effectivejavastudy.study01_item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Item6Test {

    @Test
    @DisplayName("불필요한 객체 생성하는 경우")
    void example_01() {
        String test = new String("테스트 입니다.");
        String test2 = new String("테스트 입니다.");

        assertEquals(test, test2);
        assertSame(test, test2);
    }

    @Test
    @DisplayName("불필요한 객체 생성한지 않는 경우")
    void example_01_refactor() {
        String test = "테스트 입니다.";
        String test2 = "테스트 입니다.";

        assertEquals(test, test2);
        assertSame(test, test2);

        // 리터럴을 이용하여 생성하면 String pool 에서 생성 됨
    }

    @Test
    @DisplayName("객체 생성을 정적 팩토리 메소드로 제공")
    void example_02() {
        final Boolean valueOfTrue1 = Boolean.valueOf("true");
        final Boolean valueOfTrue2 = Boolean.valueOf("True");

        assertEquals(valueOfTrue1, valueOfTrue2);
        assertSame(valueOfTrue1, valueOfTrue2);

        // 객체생성을 막음
//         new Boolean(true);
    }

    @Test
    @DisplayName("재사용 하지 않는 경우")
    void example_03() {
        final String number17 = "XVII";
        final boolean isRomanNumeral = RomanNumerals.isRomanNumeral(number17);

        assertTrue(isRomanNumeral);

//        for (int i = 0; i < 1_000_000; i++) {
//            RomanNumerals.isRomanNumeral(number17);
//        }
    }

    @Test
    @DisplayName("값비싼 객체를 재사용 하는 경우")
    void example_03_refactor() {
        final String number17 = "XVII";
        final boolean isRomanNumeral = RomanNumeralsRefactor.isRomanNumeral(number17);

        assertTrue(isRomanNumeral);

//        for (int i = 0; i < 1_000_000; i++) {
//            RomanNumeralsRefactor.isRomanNumeral(number17);
//        }
    }

    @Test
    @DisplayName("오토 박싱 하는 경우")
    void example_04() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE ; i++) {
            sum += (Long) i;
        }
    }

    @Test
    @DisplayName("오토 박싱이 없는 경우")
    void example_04_refactor() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE ; i++) {
            sum += i;
        }
    }
}
