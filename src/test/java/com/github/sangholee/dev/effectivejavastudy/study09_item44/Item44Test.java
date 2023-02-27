package com.github.sangholee.dev.effectivejavastudy.study09_item44;

import static org.junit.jupiter.api.Assertions.*;

import io.micrometer.observation.Observation.CheckedRunnable;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item44Test {

    @DisplayName("캐시사이즈 100 map 테스트")
    @Test
    void cached_size_100_test() {
        CachedSize100LinkedHashMap<Integer, String> cachedMap = new CachedSize100LinkedHashMap<>();

        IntStream.range(0, 200)
                .forEach(value -> cachedMap.put(value, "value is " + value));

        assertEquals(cachedMap.get(100), "value is 100");
        assertNull(cachedMap.get(1));
    }

    @DisplayName("불필요한 함수형 인터페이스")
    @Test
    void unnecessary_function_interface() {
        LinkedHashMap<Integer, String> eldestMap =
                EldestLinkedHashMap.eldest((map, eldest) -> map.size() > 100);

        IntStream.range(0, 200)
                .forEach(value -> eldestMap.put(value, "value is " + value));

        assertEquals(eldestMap.get(100), "value is 100");
        assertNull(eldestMap.get(1));
    }

    @DisplayName("표준 함수형 인터페이스")
    @Test
    void standard_function_interface() {
        LinkedHashMap<Integer, String> eldestMap =
                EldestStandardLinkedHashMap.eldest((map, eldest) -> map.size() > 100);

        IntStream.range(0, 200)
                .forEach(value -> eldestMap.put(value, "value is " + value));

        assertEquals(eldestMap.get(100), "value is 100");
        assertNull(eldestMap.get(1));
    }

    @DisplayName("표준 함수형 인터페이스 종류")
    @Test
    void standard_function_interface_example() {

        UnaryOperator<String> unaryOperator = String::toLowerCase;
        assertEquals(unaryOperator.apply("UP_WORD"), "up_word");

        BinaryOperator<BigInteger> bigIntegerOperator= BigInteger::add;
        assertEquals(bigIntegerOperator.apply(BigInteger.ONE, BigInteger.ONE), BigInteger.TWO);

        Predicate<Collection<String>> predicate =  Collection::isEmpty;
        assertTrue(predicate.test(List.of()));

        Function<String[], List<String>> function = Arrays::asList;
        assertEquals(function.apply(new String[]{"1", "2"}), List.of("1", "2"));

        Supplier<Instant> supplier = Instant::now;
        assertEquals(supplier.get().getClass(), Instant.class);

        Consumer<String> consumer = System.out::println;
        consumer.accept("consumer test");

        ToIntFunction<long[]> toIntFunction = value -> Arrays.stream(value)
                .mapToInt(longValue -> (int) longValue)
                .sum();

        assertEquals(toIntFunction.applyAsInt(new long[]{1, 2, 3}), 6);
    }
}
