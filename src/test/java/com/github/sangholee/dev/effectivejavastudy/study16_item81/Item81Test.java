package com.github.sangholee.dev.effectivejavastudy.study16_item81;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Item81Test {

    @Test
    void intern() {
        final String test = "test";
        System.out.println("intern: " + Item81.intern(test));
    }

    @Test
    void internRefactor() {
        final String test = "test";
        System.out.println("internRefactor: " + Item81.internRefactor(test));
    }

    @Test
    void synchronizedMap() {
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    }
}
