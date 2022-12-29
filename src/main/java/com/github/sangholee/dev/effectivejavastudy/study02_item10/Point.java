package com.github.sangholee.dev.effectivejavastudy.study02_item10;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    // LSP 위반
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }
//
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
