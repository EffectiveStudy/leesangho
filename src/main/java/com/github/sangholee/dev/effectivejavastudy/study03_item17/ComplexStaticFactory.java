package com.github.sangholee.dev.effectivejavastudy.study03_item17;

import java.math.BigInteger;

public class ComplexStaticFactory {

    public static final ComplexStaticFactory ZERO = new ComplexStaticFactory(0, 0);

    private final double re;
    private final double im;

    // final 클래스보다 이 방식이 조금 더 효율적
    private ComplexStaticFactory(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexStaticFactory valueOf(double re, double im) {
        // 캐싱 가능
        if (re == 0 && im == 0) {
            return ZERO;
        }
        return new ComplexStaticFactory(re, im);
    }


    // 방어적 복사 예시
    public static BigInteger safeInstance(BigInteger val) {
        return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
    }
}
