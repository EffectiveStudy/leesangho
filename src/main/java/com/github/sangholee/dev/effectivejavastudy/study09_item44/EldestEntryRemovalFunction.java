package com.github.sangholee.dev.effectivejavastudy.study09_item44;

import java.util.Map;

@FunctionalInterface
public interface EldestEntryRemovalFunction<K, V> {
    boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
}
