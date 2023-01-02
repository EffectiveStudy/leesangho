package com.github.sangholee.dev.effectivejavastudy.study03_item16;

public class ComponentMutable {

    private DimensionMutable dimension;

    public ComponentMutable(DimensionMutable dimension) {
        this.dimension = dimension;
    }

    public DimensionMutable getSize() {
        return dimension;
    }
}
