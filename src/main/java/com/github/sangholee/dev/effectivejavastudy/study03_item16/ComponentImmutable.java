package com.github.sangholee.dev.effectivejavastudy.study03_item16;

public class ComponentImmutable {

    private final DimensionImmutable dimension;

    public ComponentImmutable(DimensionImmutable dimension) {
        this.dimension = dimension;
    }

    public DimensionImmutable getSize() {
        return dimension;
    }
}
