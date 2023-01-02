package com.github.sangholee.dev.effectivejavastudy.study03_item16;

public class PrivateCapsuleOuter {

    private PrivateInner inner;

    public PrivateCapsuleOuter(int x, int y) {
        this.inner = new PrivateInner(x, y);
    }

    public int getMultiply() {
        return inner.getX() * inner.getY();
//        애초에 내부접근 가능하기 때문에 접근자로 캡슐화 하여도 접근이가능
//        단순 필드 접근제어를 위한 캡슐화는 의미가 없고 가독성만 안좋아짐
//        return inner.x * inner.y;
    }

    private static class PrivateInner {
        private int x;

        private int y;

        public PrivateInner(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public PrivateInner getInner() {
        return inner;
    }
}
