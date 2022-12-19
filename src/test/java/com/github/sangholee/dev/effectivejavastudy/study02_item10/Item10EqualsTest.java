package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item10EqualsTest {

    @Test
    @DisplayName("전형적인 equals 메소드 예시")
    void equals_test() {
        short areaCode = 10;
        short prefix = 10;
        short lineNum = 10;
        PhoneNumber phoneNumber1 = new PhoneNumber(areaCode, prefix, lineNum);
        PhoneNumber phoneNumber2 = new PhoneNumber(areaCode, prefix, lineNum);
        PhoneNumber phoneNumber3 = new PhoneNumber((short) 10, (short) 10, (short) 10);

        // 대칭성 확인
        assertEquals(phoneNumber1, phoneNumber2);
        assertEquals(phoneNumber2, phoneNumber1);

        // 추이성 확인
        assertEquals(phoneNumber2, phoneNumber3);
        assertEquals(phoneNumber1, phoneNumber3);

    }

    @Test
    @DisplayName("equals 약간의 예외")
    void float_double_equals() {
        // 필드 비교시에
        // float, double, 참조 타입 은 equals 메소드로 비교
        Float float1 = 1f;
        Float float2 = 1f;
        float1.equals(float2);
        // 오토 박싱이 일어 날수 있음

        // jls 15.21.1
        // https://docs.oracle.com/javase/specs/jls/se17/html/jls-15.html#jls-15.21.1

        Float.compare(float1, float2);
        Double.compare(1d, 1d);

        Arrays.equals(new int[]{1}, new int[]{1});
    }

    @Test
    @DisplayName("권장 방식 테스트")
    void autoValueTest() {
        // IDE generate
        IdePoint idePoint1 = new IdePoint(1,2);
        IdePoint idePoint2 = new IdePoint(1,2);
        assertEquals(idePoint1, idePoint2);

        // AutoValue
        AutoValuePoint autoValuePoint1 = AutoValuePoint.create(1, 2);
        AutoValuePoint autoValuePoint2 = AutoValuePoint.create(1, 2);
        autoValuePoint1.equals(autoValuePoint2);
        assertEquals(autoValuePoint1, autoValuePoint1);

        // https://github.com/google/auto/tree/main/value
        // https://github.com/google/auto/blob/main/value/userguide/index.md


        // Record
        // https://docs.oracle.com/en/java/javase/16/language/records.html
        RecordPoint recordPoint1 = new RecordPoint(1, 2);
        RecordPoint recordPoint2 = new RecordPoint(1, 2);

        recordPoint1.equals(recordPoint2);
        assertEquals(recordPoint1, recordPoint2);

        // https://docs.oracle.com/javase/specs/jls/se14/preview/specs/records-jls.html#jls-8.10
    }
}
