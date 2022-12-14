package com.github.sangholee.dev.effectivejavastudy.study04_item20;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Map.Entry)) {
            return false;
        }

        Map.Entry<?, ? > e = (Entry<?, ?>) o;
        return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }
}
