package com.github.sangholee.dev.effectivejavastudy.study04_item20;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item20Test {


    @Test
    @DisplayName("기존 클래스에 손쉽게 새로운 인터페이스 구현 가능")
    void character_1() {
        Song song = new Song();
    }

    @Test
    @DisplayName("믹스인 정의 탁월")
    void character_2() {
        SingerSongWriter iu = new IU();
    }

    @Test
    @DisplayName("@implSpec 자바독 활용")
    void character_3() {
        Singer iu = new IU();
    }

    @Test
    @DisplayName("골격 클래스 제공")
    void character_4() {
        ArrayList list = new ArrayList();

    }

    @Test
    @DisplayName("단순 구현")
    void character_5() {
        Map.Entry entry = new SimpleEntry("", "");
    }
}
