package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import java.util.Objects;

public class IdePoint {

    private final int x;
    private final int y;

    public IdePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdePoint idePoint = (IdePoint) o;
        return x == idePoint.x && y == idePoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
