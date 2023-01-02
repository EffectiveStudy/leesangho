package com.github.sangholee.dev.effectivejavastudy.study03_item17;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item17Test {

    @Test
    @DisplayName("불변 객체 생성 테스트")
    void immutable() {
        Complex complex1 = new Complex(0, 0);

        assertEquals(complex1, Complex.ZERO);
    }

    @Test
    @DisplayName("내부 데이터 공유가능")
    void share_member_variable() {
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger negate = bigInteger.negate();
    }

    @Test
    @DisplayName("불변 객체 단점 - 값이 다르면 반드시 독립된 객체 생성")
    void name() {
        BigInteger moby = BigInteger.valueOf(Long.MAX_VALUE);
        // 새로 생성함
        moby = moby.flipBit(0);

        // 새로 생성하지 않음
        BitSet mobySet = BitSet.valueOf(new long[]{Long.MAX_VALUE});
        mobySet.flip(0);
    }

    @Test
    @DisplayName("가변 동반 클래스")
    void stringBuilder() {
//      성능 떄문에 어쩔수 없다면 가변 동반 클래스 제공
//      MutableBigInteger, SignedMutableBigInteger 등의 가변 동반 클래스 => BigInteger 에서 사용 하고 클라이언트는 안써도 됨
        String string = "";
        StringBuilder builder = new StringBuilder();
    }

    @Test
    @DisplayName("정적 팩토리 메소드 제공")
    void static_factory_method() {
        ComplexStaticFactory complex = ComplexStaticFactory.valueOf(0, 0);

        // 캐싱 가능
        assertEquals(complex, ComplexStaticFactory.ZERO);
        assertSame(complex, ComplexStaticFactory.ZERO);
    }

    @Test
    @DisplayName("확장 제한 하기")
    void extends_test() {
        // 확장 불가능
//        class ComplexStaticFactoryExtends extends ComplexStaticFactory {
//
//        }

        // 가능
        class BigIntegerExtends extends BigInteger {

            public BigIntegerExtends(byte[] val) {
                super(val);
            }
        }

        // BigInteger 사용시 진짜 불변객체인지 확인이 필요 ( 방어적 사용이 필요 )

    }

    @Test
    @DisplayName("불변 객체 좋은 예시")
    void good_case() {
        // 가변 객체 이지만 원칙을 잘 지킴
        CountDownLatch countDownLatch = new CountDownLatch(10);

    }
}
