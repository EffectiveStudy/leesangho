package com.github.sangholee.dev.effectivejavastudy.study03_item16;

import java.util.Objects;

public class DimensionImmutable {

    private final int width;

    private final int height;

    public DimensionImmutable(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DimensionImmutable that = (DimensionImmutable) o;
        return width == that.width && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
