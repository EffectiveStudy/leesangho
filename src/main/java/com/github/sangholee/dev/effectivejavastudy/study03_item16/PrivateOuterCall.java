package com.github.sangholee.dev.effectivejavastudy.study03_item16;

public class PrivateOuterCall {

    public void call() {
        PrivateOuter privateOuter = new PrivateOuter(10, 20);
        privateOuter.getMultiply();
        // 내부 변수 접근 안됨 아무 문제가 없음
    }

    public void capsuleCall() {
        PrivateCapsuleOuter privateCapsuleOuter = new PrivateCapsuleOuter(10, 20);
        privateCapsuleOuter.getMultiply();
    }

}
