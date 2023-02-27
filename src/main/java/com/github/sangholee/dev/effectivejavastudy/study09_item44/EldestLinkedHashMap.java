package com.github.sangholee.dev.effectivejavastudy.study09_item44;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;

public class EldestLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final EldestEntryRemovalFunction<K, V> function;

    public EldestLinkedHashMap(EldestEntryRemovalFunction<K, V> function) {
        this.function = function;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return function.remove(this, eldest);
    }

    public static <K, V> LinkedHashMap<K, V> eldest(EldestEntryRemovalFunction<K, V> function) {
        return new EldestLinkedHashMap<>(function);
    }
}
