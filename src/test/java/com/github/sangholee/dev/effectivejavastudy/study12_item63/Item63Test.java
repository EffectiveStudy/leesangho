package com.github.sangholee.dev.effectivejavastudy.study12_item63;

import com.github.sangholee.dev.effectivejavastudy.base.TimingExtension;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(TimingExtension.class)
class Item63Test {

    private static final long LOOP_COUNT = 10_000;
    private static final String CONCAT_STRING = "9W1iZeEjw2pGg5SySjMBOwq3pZsw6G08XirWyMe4bFzigZ3Q4MuCXy91cch4C7dY5fesiF15owZ5Qj42";

    @DisplayName("문자열 연결을 잘못 사용 한 예")
    @ValueSource(longs = LOOP_COUNT)
    @ParameterizedTest
    void bad_example(long itemNumber) {
        String result = "";
        for (int i = 0; i < itemNumber; i++) {
            result += CONCAT_STRING;
        }
        System.out.println(result);
    }

    @DisplayName("StringBuilder 로 성능 개선")
    @ValueSource(longs = LOOP_COUNT)
    @ParameterizedTest
    void good_example(long itemNumber) {
        StringBuilder builder =  new StringBuilder((int) (itemNumber * CONCAT_STRING.length()));
        for (int i = 0; i < itemNumber; i++) {
            builder.append(CONCAT_STRING);
        }
        System.out.println(builder.toString());
    }

    @DisplayName("StringBuffer 로 테스트")
    @ValueSource(longs = LOOP_COUNT)
    @ParameterizedTest
    void stringBuffer(long itemNumber) {
        StringBuffer buffer = new StringBuffer((int) (itemNumber * CONCAT_STRING.length()));
        for (int i = 0; i < itemNumber; i++) {
            buffer.append(CONCAT_STRING);
        }
        System.out.println(buffer.toString());
    }

    @DisplayName("stream 을 사용")
    @ValueSource(longs = LOOP_COUNT)
    @ParameterizedTest
    void stream(long itemNumber) {
        String joinString = IntStream.rangeClosed(0, (int) itemNumber)
                .mapToObj(i -> CONCAT_STRING)
                .collect(Collectors.joining());
        System.out.println(joinString);
    }

    @DisplayName("StringJoiner 를 사용")
    @ValueSource(longs = LOOP_COUNT)
    @ParameterizedTest
    void stringJoiner(long itemNumber) {
        StringJoiner stringJoiner = new StringJoiner("");
        for (int i = 0; i < itemNumber; i++) {
            stringJoiner.add(CONCAT_STRING);
        }

        String joinString = stringJoiner.toString();
        System.out.println(joinString);
    }

    @DisplayName("String.join 을 사용")
    @ValueSource(longs = LOOP_COUNT)
    @ParameterizedTest
    void string_join(long itemNumber) {
        String[] strings = new String[(int) itemNumber];
        for (int i = 0; i < itemNumber; i++) {
            strings[i] = CONCAT_STRING;
        }

        String joinString = String.join("", strings);
        System.out.println(joinString);
    }

    @DisplayName("String.concat 을 사용")
    @ValueSource(longs = LOOP_COUNT)
    @ParameterizedTest
    void string_concat(long itemNumber) {
        String result = "";
        for (int i = 0; i < itemNumber; i++) {
            result = result.concat(CONCAT_STRING);
        }
        System.out.println(result);
    }
}
