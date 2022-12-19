package com.github.sangholee.dev.effectivejavastudy.study02_item10;

public class Item10 {


    public boolean executeEqualsPrivateClass() {
        PrivateClass privateClass1 = new PrivateClass();
        PrivateClass privateClass2 = new PrivateClass();
        return privateClass1.equals(privateClass2);
    }

    private class PrivateClass {

        @Override
        public boolean equals(Object obj) {
            throw new AssertionError();
        }
    }
}
