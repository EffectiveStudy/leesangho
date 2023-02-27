package com.github.sangholee.dev.effectivejavastudy.study09_item44;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class CachedSize100LinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > 100;
    }
}
