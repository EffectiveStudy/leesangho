package com.github.sangholee.dev.effectivejavastudy.study09_item44;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;

public class EldestStandardLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final BiPredicate<Map<K, V>, Entry<K, V>> predicate;
    public EldestStandardLinkedHashMap(BiPredicate<Map<K, V>, Entry<K, V>> predicate) {
        this.predicate = predicate;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return predicate.test(this, eldest);
    }

    public static <K, V> LinkedHashMap<K, V> eldest(BiPredicate<Map<K, V>, Entry<K, V>> predicate) {
        return new EldestStandardLinkedHashMap<>(predicate);
    }
}
