package com.github.sangholee.dev.effectivejavastudy.study03_item16;

public class PrivateOuter {

    private PrivateInner inner;

    public PrivateOuter(int x, int y) {
        PrivateInner privateInner = new PrivateInner();
        privateInner.x = x;
        privateInner.y = y;
        this.inner = privateInner;
    }

    public int getMultiply() {
        return inner.x * inner.y;
    }

    private class PrivateInner {
        public int x;
        public int y;

        public void print() {
            System.out.println("프린트");
        }
    }

    public PrivateInner getInner() {
        return inner;
    }
}
