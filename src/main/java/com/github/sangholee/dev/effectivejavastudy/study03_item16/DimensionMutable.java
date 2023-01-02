package com.github.sangholee.dev.effectivejavastudy.study03_item16;

import java.util.Objects;

public class DimensionMutable {

    public int width;

    public int height;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DimensionMutable that = (DimensionMutable) o;
        return width == that.width && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
