package com.github.sangholee.dev.effectivejavastudy.study06_item34;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item34Test {

    @Test
    @DisplayName("열거타입과 정수열거 패턴의 차이 - 1 비교")
    void int_constant_deference1() {

        // Constant.APPLE_PIPPIN == Constant.APPLE_PIPPIN
        assertSame(Constant.APPLE_PIPPIN, Constant.APPLE_PIPPIN);

        // Apple.PIPPIN == Apple.PIPPIN
        assertSame(Apple.PIPPIN, Apple.PIPPIN);

        // Constant.APPLE_PIPPIN != Constant.APPLE_GRANNY_SMITH
        assertNotSame(Constant.APPLE_PIPPIN, Constant.APPLE_GRANNY_SMITH);

        // Apple.PIPPIN != Apple.FUJI
        assertNotSame(Apple.PIPPIN, Apple.FUJI);

        // Constant.APPLE_PIPPIN == Constant.ORANGE_TEMPLATE ??
        // 비교가 가능하며 심지어 같음
        assertSame(Constant.APPLE_PIPPIN, Constant.ORANGE_TEMPLATE);
        final boolean isSame = Constant.APPLE_PIPPIN == Constant.ORANGE_TEMPLATE;
        assertTrue(isSame);

        // Apple.PIPPIN != Orange.TEMPLE
        // 비교하여도 당연히 값이 다름
        assertNotSame(Apple.PIPPIN, Orange.TEMPLE);

        // 애초에 컴파일 오류
//        boolean isCompareAppleAndOrangeByEnum = Apple.PIPPIN == Orange.TEMPLE;
    }

    @Test
    @DisplayName("열거타입과 정수열거 패턴의 차이 - 2 클라이언트 코드 변경")
    void int_constant_deference2() {

        // 컴파일 하면 값이 그대로 들어감
        ClientCode clientCode = new ClientCode();

        // 값 변경시 컴파일이 필요해짐
    }

    @Test
    @DisplayName("열거타입과 정수열거 패턴의 차이 - 3 타입 안정성")
    void int_constant_deference3() {

        assertDoesNotThrow(() -> ConstantAdapter.printApple(Constant.APPLE_FUJI));
        assertDoesNotThrow(() -> ConstantAdapter.printApple(Apple.PIPPIN));

        // 안전한 타입을 전달 받지 못할 가능성 존재
        assertDoesNotThrow(() -> ConstantAdapter.printApple(Constant.ORANGE_TEMPLATE));
        assertThrows(AssertionError.class, () -> ConstantAdapter.printApple(100));

        // 애초에 컴파일 오류로 넣을수가 없음
        // not null 이라면 언제나 안정적으로 타입이 전달됨
//        assertThrows(AssertionError.class ,() -> ConstantAdapter.printApple(Apple.100));
    }

    @Test
    @DisplayName("열거타입으로 상수와 데이터를 연결하고 싶을때")
    void enum_data_method() {
        // 지구 무게가 185 kgf(?) 의 질량
        double mass = 185.0 / Planet.EARTH.surfaceGravity();

        // 전체 행성에서 무게를 출력하고 싶다면
        Arrays.stream(Planet.values())
                .forEach(planet -> System.out.printf("%s 에서의 무게는 %f 이다%n", planet,
                        planet.surfaceWeight(mass)));

        // 만약 명왕성이 추가 된다면???
        // 클라이언트 코드가 변하는가??
    }

    @Test
    @DisplayName("열거타입으로 상수별 메소드 구현")
    void enum_method_implements() {

        double x = 2.00000;
        double y = 4.00000;

        // 사칙 연산 결과 를 출력
        System.out.println("-------------추상메소드-------------");
        Arrays.stream(Operation.values())
                .forEach(operation -> System.out.printf("%f %s %f = %f%n", x, operation, y,
                        operation.apply(x, y)));

        // 문자열을 열거타입으로 변환화는 메소드를 제공 가능
        Double timesResult = Operation.fromString("*")
                .map(operation -> operation.apply(x, y))
                .orElseThrow();

        assertEquals(timesResult, Operation.TIMES.apply(x, y));

        // 함수형 인터페이스를 이용하면 더 간단
        System.out.println("-------------함수형 인터페이스-------------");
        Arrays.stream(OperationLambda.values())
                .forEach(operation -> System.out.printf("%f %s %f = %f%n", x, operation, y,
                        operation.apply(x, y)));
        ConstructorOrder constructorOrder = new ConstructorOrder();
    }

    @Test
    @DisplayName("열거타입으로 전략적 열거 타입 패턴")
    void enum_strategic_pattern() {

        // 요일별 일당 출력
        System.out.println("-------------switch-------------");
        Arrays.stream(PayrollDaySwitch.values())
                .forEach(day -> System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1)));

        System.out.println("-------------전략 패턴-------------");
        Arrays.stream(PayrollDay.values())
                .forEach(day -> System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1)));

        // switch 가 효율적인 경우
        Operation divideInverse = OperationAdaptor.inverse(Operation.DIVIDE);
    }
}
