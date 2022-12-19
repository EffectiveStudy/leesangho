package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import java.awt.Color;
import java.util.Objects;

public class ColorPointViolate extends Point {

    private final Color color;

    public ColorPointViolate(int x, int y, Color color) {
        super(x, y);
        this.color = Objects.requireNonNull(color);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPointViolate)) {
            return false;
        }

        return super.equals(o) && ((ColorPointViolate) o).color == color;
    }

    // Point 인 경우 색상 무시하도록
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point)) {
//            return false;
//        }
//
//        if (!(o instanceof ColorPointViolate)) {
//            return o.equals(this);
//        }
//
//        return super.equals(o) && ((ColorPointViolate) o).color == color;
//    }
}
