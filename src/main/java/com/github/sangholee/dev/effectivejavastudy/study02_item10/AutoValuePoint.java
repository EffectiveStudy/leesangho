package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AutoValuePoint {

    static AutoValuePoint create(int x, int y) {
        return new AutoValue_AutoValuePoint(x, y);
    }

    abstract int x();
    abstract int y();
}
