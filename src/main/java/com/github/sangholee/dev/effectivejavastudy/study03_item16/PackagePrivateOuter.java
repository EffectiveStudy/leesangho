package com.github.sangholee.dev.effectivejavastudy.study03_item16;

public class PackagePrivateOuter {

    void print() {
        System.out.println("프린트");
    }

    class Inner {
        public int x;
        public int y;

        public void outerPrint() {
            PackagePrivateOuter.this.print();
        }
    }

    static class InnerStatic {
        public int x;
        public int y;

        public void outerPrint() {
//            PackagePrivateOuter.this.print();
        }
    }
}
