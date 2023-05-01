package com.github.sangholee.dev.effectivejavastudy.study16_item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Item81 {

    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {
        String previousValue = map.putIfAbsent(s, s);
        return previousValue == null ? s : previousValue;
    }

    public static String internRefactor(String s) {
        // get 사용하는게 훨씬 효율적
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null) {
                return s;
            }
        }
        return result;
    }
}
