package com.github.sangholee.dev.effectivejavastudy.study05_item28;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

class Item28Test {

    @Test
    @DisplayName("런타입시 실패")
    void runtime_exception() {
        Object[] objectArray = new Long[1];
        objectArray[0] = "타입이 달라 넣을 수 없다.";
    }

    @Test
    @DisplayName("컴파일 실패")
    void list_is_not_compile() {
        // 애초에 안됨 컴파일 에러
//        List<Object> ol = new ArrayList<Long>();
//        ol.add("타입이 달라 넣을 수 없다.");
    }

    @Test
    @DisplayName("제네릭 배열 생성이 가능 한 경우")
    void if_generic_array() {
//        List<String>[] stringLists = new ArrayList<String>()[1];
//        List<Integer> integerList = List.of(42);
//        Object[] objects = stringLists;
//        objects[0] = integerList;
//        String s = stringLists[0].get(0);

        // 제네릭을 사용했지만 타입이 맞지 않음
    }

    @Test
    @DisplayName("제네릭의 실체화 불가")
    <T> void generic_reify(T generic) {
        // 불가능
//        T test = new T();
//        T[] testArray = new T[];
//        Class<T> tClass = T.class;

        // 배열은 실체화가 가능
        int[] intArray = new int[]{4};
        Integer[] integerArray = new Integer[]{4};
        Class<?> intArrayClass = int[].class;
        Class<?> integerArrayClass = Integer[].class;
    }

    @Test
    @DisplayName("제네릭 타입 소거")
    void generic_erasure() {
        Integer[] ints = new Integer[]{1, 2, 3};
        boolean containsElement = GenericTypeErasure.containsElement(ints, 1);
        assertTrue(containsElement);

        // 컴파일 시점에만 체크를 하며
        // 런타임시에는 타입 검사를 하지 않음

    }


}
