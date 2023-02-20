package com.github.sangholee.dev.effectivejavastudy.study08_item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item42Test {

    @DisplayName("익명 클래스 예시")
    @Test
    void anonymous_class() {
        List<String> words = List.of("flat", "plate", "corner", "officer", "medicine");
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
    }

    @DisplayName("람다식을 사용")
    @Test
    void lambda() {
        List<String> words = Arrays.asList("flat", "plate", "corner", "officer", "medicine");
        Collections.sort(words,
                (o1, o2) -> Integer.compare(o1.length(), o2.length()));
    }

    @DisplayName("비교자 생성 메소드")
    @Test
    void comparor_construct_method() {
        List<String> words = Arrays.asList("flat", "plate", "corner", "officer", "medicine");
        Collections.sort(words, Comparator.comparingInt(String::length));
    }

    @DisplayName("List 인터페이스 sort")
    @Test
    void list_sort() {
        List<String> words = Arrays.asList("flat", "plate", "corner", "officer", "medicine");
        words.sort(Comparator.comparingInt(String::length));
    }

}
