package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item10NotOverridingCaseTest {

    @Test
    @DisplayName("각 인스턴스가 본질적으로 고유한 경우")
    void instance_unique() {
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        
        // Thread 클래스는 equals 메소드 재정의를 하지 않음
        // Thread 는 값이 아닌 동작하는 개체를 표현하는 클래스
        thread1.equals(thread2);

    }

    @Test
    @DisplayName("인스턴스의 논리적 동치성을 검사할 일이 없는 경우")
    void not_need_logical_equality() {
        Pattern pattern = Pattern.compile("");
        Pattern pattern2 = Pattern.compile("");

        // Pattern 클래스는 equals 메소드 재정의를 하지 않음
        // 설계자가 논리적인 동치성 검사를 원하지 않았거나 필요하지 않다고 판단 할 수 있음
        pattern.equals(pattern2);
    }

    @Test
    @DisplayName("상위 클래스에서 재정의한 equals 가 하위 클래스에도 딱 맞는 경우")
    void superclass_equals() {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        // HashSet 은 AbstractSet 의 equals 메소드 재정의를 그대로 사용
        set1.equals(set2);
    }

    @Test
    @DisplayName("클래스가 private 이거나 package-private 인 경우")
    void private_package_private() {
        // equals 를 호출 할 일이 없음
        Item10 item10 = new Item10();
        item10.executeEqualsPrivateClass();

        PackagePrivate packagePrivate1 = new PackagePrivate();
        PackagePrivate packagePrivate2 = new PackagePrivate();

        packagePrivate1.equals(packagePrivate2);

        // TMI
        // private-package(default) 접근제한자 클래스는 실무에서는 안쓰는 경우가 많습니다.
        // 잘 만들어진 패키지 구조에서 정말 가치가 생기겠지만 팀에서 패키지 구조 제한이 없는 경우도 있으며
        // 궁극적으로 소프트웨어는 자주 변하여 현재의 패키지 구조가 변경될때 발목을 잡을 수 있어서 입니다.
        //
        // 참고 https://hyeon9mak.github.io/Java-dont-use-package-private
    }

    @Test
    @DisplayName("값 클래스 라도 같은 인스턴스가 둘이상 만들어짐을 보장하는 경우")
    void enum_equals() {
        // Enum 은 같은 인스턴스가 2개이상 만들어지지 않음
        Item10Enum.LEE_SANGHO.equals(Item10Enum.LEE_SANGHO);

        // => item3 열거 타입으로 싱글톤임을 보장해라
    }

}
