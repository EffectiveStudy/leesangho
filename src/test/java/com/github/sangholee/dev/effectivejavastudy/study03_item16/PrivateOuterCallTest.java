package com.github.sangholee.dev.effectivejavastudy.study03_item16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrivateOuterCallTest {

    @Test
    @DisplayName("inner class static 으로 쓰는게 좋은 이유")
    void nested_class_static() {
        PrivateOuter privateOuter = new PrivateOuter(10, 20);
        privateOuter.getMultiply();

        PrivateCapsuleOuter privateCapsuleOuter = new PrivateCapsuleOuter(10, 20);
        privateCapsuleOuter.getMultiply();

        PackagePrivateOuter.Inner inner = new PackagePrivateOuter().new Inner();
        inner.outerPrint();
        PackagePrivateOuter.InnerStatic innerStatic = new PackagePrivateOuter.InnerStatic();
        innerStatic.outerPrint();

        // static 이 아니면 외부 참조 Outer class 인스턴스를 참조합니다.
        // 외부 참조시 문제점
        // 1. 참조값이 필요하여 성능적으로 안좋음
        // 2. 외부 인스턴스 참조로 인한 gc 대상이 안되어 메모리 누수 발생 가능

        // 결론 inner class 는 static 을 붙입시다.

        // 참고 https://siyoon210.tistory.com/141
    }
}
