package com.github.sangholee.dev.effectivejavastudy.study10_item49;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item49Test {

    @DisplayName("@NonNull 테스트")
    @Test
    void nonnull_test() {
        final Item49 item49 = new Item49(BigInteger.ONE);
        item49.mod(null);
    }

    @DisplayName("assert 로 체크")
    @Test
    void assert_test() {
        Item49.sort(null, 1, 2);
        Item49.sort(new long[]{1, 2}, 1, 10);
    }

    @Test
    void guava_test() {
        new GuavaModel("이름", -1);
    }
}
