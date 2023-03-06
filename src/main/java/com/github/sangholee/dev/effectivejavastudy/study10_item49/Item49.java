package com.github.sangholee.dev.effectivejavastudy.study10_item49;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.math.BigInteger;
import java.util.Objects;

public class Item49 {

    private BigInteger bigInteger;

    public Item49(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    /**
     * (현재 값 mod m) 값을 반환한다. 이 메서드는
     * 항상 음이 아닌 BigInteger 를 반환한다는 점에서 remainder 메서드와 다르다.
     *
     * @param m 계수(양수여야 한다.)
     * @return 현재 값 mod m
     * @throws ArithmeticException m이 0보다 작거나 같은면 발생한다.
     */
    public BigInteger mod(BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("계수 (m)는 양수여야 합니다. " + m);
        }

        return bigInteger.mod(m);
    }

    private static class NullCheck {

        private String strategy;

        public NullCheck(String strategy) {
            this.strategy = Objects.requireNonNull(strategy, "전략");
        }
    }

    public static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
    }
}
