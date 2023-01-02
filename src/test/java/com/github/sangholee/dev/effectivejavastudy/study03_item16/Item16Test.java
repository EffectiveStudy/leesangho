package com.github.sangholee.dev.effectivejavastudy.study03_item16;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item16Test {

    @Test
    @DisplayName("나쁜 예제 - public 클래스에 public 접근자 멤버 변수")
    void bad_case() {
        Point point = new Point();
        point.x = 10;
        point.getX();
        point.y = 10;
        point.getY();

        Dimension dimension = new Dimension();
        dimension.width = 10;
        dimension.getWidth();
        dimension.height = 10;
        dimension.getHeight();
        dimension.getSize();

        // item 67 ( 최적화는 신중히 하라 )
        // 성능적 이슈가 있음 ( 방어적 복사 기법 때문 )
        Component component = new Canvas();
        component.setSize(dimension);
        assertEquals(dimension, component.getSize());

        component.getSize().width = 12;
        component.getSize().height = 12;
        // 방어적 복사 => component 값이 유지됨
        assertNotSame(dimension, component.getSize());
        assertEquals(new Dimension(12, 12), component.getSize());
    }

    @Test
    @DisplayName("만약 방어적 복사가 아니라면??")
    void getSize_notDefensive_copy() {
        DimensionMutable dimension = new DimensionMutable();
        dimension.width = 10;
        dimension.height = 10;
        ComponentMutable component = new ComponentMutable(dimension);

        DimensionMutable expected = new DimensionMutable();
        expected.width = 10;
        expected.height = 10;

        assertSame(dimension, component.getSize());
        assertEquals(component.getSize(), expected);

        // 필드 값을 수정
        component.getSize().width = 12;
        component.getSize().height = 12;
        DimensionMutable changeDimension = new DimensionMutable();
        changeDimension.width = 12;
        changeDimension.height = 12;

        // component 크기가 변함
        assertEquals(changeDimension, component.getSize());
        assertSame(dimension, component.getSize());

        // 필드 값이 변하여 기대값과 다름
        assertEquals(component.getSize(), expected);
    }

    @Test
    @DisplayName("만약 Dimension 이 불변 이였다면?")
    void dimension_immutable() {
        DimensionImmutable dimension = new DimensionImmutable(10, 10);
        ComponentImmutable component = new ComponentImmutable(dimension);

        assertEquals(dimension, component.getSize());
        assertEquals(new DimensionImmutable(10, 10), component.getSize());

        // 변경 할 수 API 를 제공 하지 않으면 변경이 불가능
        // 따라서 불변객체를 제공하여도 괜찮음
        // component 사이즈가 변경될 일이 없음

        DimensionRecord dimensionRecord = new DimensionRecord(10, 10);
        ComponentRecord componentRecord = new ComponentRecord(dimensionRecord);
        assertEquals(dimensionRecord, componentRecord.getSize());
        assertEquals(new DimensionRecord(10, 10), componentRecord.getSize());
    }

    @Test
    @DisplayName("불변 필드를 직접 노출")
    void final_field() {
        Time time = new Time(20, 10);

        assertEquals(time.hour, 20);
        assertEquals(time.minute, 10);

//        time.hour = 25;
//        표현방식을 바꿀수 없고 부수작업 불가
//        제가 생각하는 예시
//        만약 시간값을 조회할때 마다 로그를 남기고 싶다면
//        필드를 제공하는것으로는 힘듬

//        time.getHour();
    }

    @Test
    @DisplayName("좋은 예제")
    void good_case() {
        // 불변 객체는 항상 해당됨
        String test = "String";

        BigInteger bigInteger = BigInteger.ONE;

        // 제가 찾은 예제라서 적절하지 않을 수도 있습니다.
//        DefaultLoaderDelegate ClassFile
        // JShell => JDK 9 이상 지원
        // 코드를 미리 검증해보는 프로토타이핑 도구
    }
}
