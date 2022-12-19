package com.github.sangholee.dev.effectivejavastudy.study02_item10;

public class NullCheck {

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return super.equals(o);
    }

//    // 형체크로 null 탐지 - 묵시적 null 검사
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof NullCheck)) {
//            return false;
//        }
//        return super.equals(o);
//    }
}
