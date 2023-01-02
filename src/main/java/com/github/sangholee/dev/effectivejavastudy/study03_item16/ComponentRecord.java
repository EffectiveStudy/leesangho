package com.github.sangholee.dev.effectivejavastudy.study03_item16;

public class ComponentRecord {

    private final DimensionRecord dimension;

    public ComponentRecord(DimensionRecord dimension) {
        this.dimension = dimension;
    }

    public DimensionRecord getSize() {
        return dimension;
    }
}
