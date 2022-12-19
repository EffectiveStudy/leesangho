package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Item10RuleTest {

    @Test
    @DisplayName("반사성을 위반 하는 경우")
    void reflexivity() {
        ReflexivityViolate reflexivityViolate1 = new ReflexivityViolate("이름1", "주소1");
        ReflexivityViolate reflexivityViolate2 = new ReflexivityViolate("이름1", "주소1");

        assertNotEquals(reflexivityViolate1, reflexivityViolate2);

        List<ReflexivityViolate> reflexivityViolateList = List.of(reflexivityViolate1);
        assertFalse(reflexivityViolateList.contains(reflexivityViolate2));

        // equals 메소드를 재정의 하여 사용한다면
        // 사실상 일부러 위반하는 경우가 아니면 힘듬
    }

    @Test
    @DisplayName("대칭성을 위반 하는 경우")
    void symmetry_violate() {
        String s = "polish";
        CaseInsensitiveStringViolate caseInsensitiveString_POLISH = new CaseInsensitiveStringViolate("POLISH");
        CaseInsensitiveStringViolate caseInsensitiveString_polish = new CaseInsensitiveStringViolate("polish");

        assertEquals(caseInsensitiveString_POLISH, caseInsensitiveString_polish);

        // 일반 문자열과 비교 가능하도록 equals 를 작성하였음
        assertEquals(caseInsensitiveString_POLISH, s);

        // 반대의 경우 에러가 발생 => 대칭성 위반
        assertEquals(s, caseInsensitiveString_POLISH);

        // 콜렉션에 넣는 경우
        List<CaseInsensitiveStringViolate> caseInsensitiveStringList = List.of(
                caseInsensitiveString_POLISH, caseInsensitiveString_polish);

        assertFalse(caseInsensitiveStringList.contains(s));

        // OpenJDK 에서는 false 반환하지만 equals 규약을 어기면 JDK 버전이 바뀌거나 다른 JDK 에서 어떻게 반응 할지 모름
        // 애초에 CaseInsensitiveString 와 String 을 equals 로 연동하려고 하지 말자
    }

    @Test
    @DisplayName("대칭성을 지키는 경우")
    void symmetry() {
        String s = "polish";
        CaseInsensitiveString caseInsensitiveString_POLISH = new CaseInsensitiveString("POLISH");
        CaseInsensitiveString caseInsensitiveString_polish = new CaseInsensitiveString(s);

        assertEquals(caseInsensitiveString_POLISH, caseInsensitiveString_polish);

        assertNotEquals(caseInsensitiveString_POLISH, s);

        assertNotEquals(s, caseInsensitiveString_POLISH);
    }

    @Test
    @DisplayName("추이성을 위반하는 경우")
    void transitivity_violate() {
        Point point = new Point(1, 2);
        ColorPointViolate colorPoint1 = new ColorPointViolate(1, 2, Color.RED);

        assertEquals(point, colorPoint1);

        // ColorPointViolate 에 equals 메소드에서는 타입이 다르기 떄문에 false 반환
        assertEquals(colorPoint1, point);

//        // Point 인 경우 색상 무시하도록 수정하면
//        // 대칭성은 지켜지지만 추이성이 깨짐
//        ColorPointViolate colorPoint2 = new ColorPointViolate(1, 2, Color.BLUE);
//        assertEquals(point, colorPoint2);
//
//        // colorPoint1 == point, point == colorPoint2 => ?? colorPoint1 != colorPoint2
//        assertEquals(colorPoint1, colorPoint2);
//        // 근본적으로 객체지향 언어의 동치관계에서 한계
//        // 구체 클래스를 확장하여 새로운 값을 추가하면서 equals 규약을 만족 시킬수 없음
//        // 추상클래스로 구현하는 방법이 있음
    }

    @Test
    @DisplayName("추이성을 위반하는 경우 - 리스코프 치환원칙 위배")
    void transitivity_violate_lsp() {
        Point point = new Point(1, 0);
        Set<Point> unitCircle = Set.of(new Point(1, 0), new Point(0, 1),
                new Point(-1, 0), new Point(0, -1));

        assertTrue(unitCircle.contains(point));

        CounterPoint counterPoint = new CounterPoint(1, 0);
        assertTrue(unitCircle.contains(counterPoint));
    }

    @Test
    @DisplayName("추이성을 지키면서 값 추가 경우")
    void transitivity() {
        Point point = new Point(1, 0);
        ColorPoint colorPoint1 = new ColorPoint(1, 2, Color.RED);

        assertNotEquals(colorPoint1, point);
        assertNotEquals(point, colorPoint1);

        ColorPoint colorPoint2 = new ColorPoint(1, 2, Color.BLUE);
        assertNotEquals(colorPoint1, colorPoint2);
        assertNotEquals(colorPoint2, colorPoint1);

        ColorPoint colorPoint3 = new ColorPoint(1, 2, Color.RED);
        assertEquals(colorPoint1, colorPoint3);
        assertEquals(colorPoint3, colorPoint1);
    }

    @Test
    @DisplayName("Timestamp 주의")
    void transitivity_timestamp() {
        Timestamp timestamp = new Timestamp(10000L);
        timestamp.equals(new Date());

        // Timestamp 이렇게 설계한것은 실수
        // docs 에 Date 에 대칭이 아니라고 나옴
        // As a result, the Timestamp.equals(Object) method is not symmetric with respect to the java.util.Date.equals(Object) method
        // https://docs.oracle.com/javase/7/docs/api/java/sql/Timestamp.html
    }

    @Test
    @DisplayName("일관성을 위반하는 경우")
    void consistency() throws MalformedURLException {
        // equals 의 판단에서 신뢰할 수 없는 자원이이 끼어들면 안됨
        URL url1 = new URL("https://naver.com");
        URL url2 = new URL("https://naver.com");
        url1.equals(url2);

        // URL 에 매핑된 호스트의 IP 주소를 이용하여 비교
        // 같다고 보장 할 수 없음
    }

    @Test
    @DisplayName("null 아님을 위반하는 경우")
    void notNull() {
        NullCheck nullCheck = new NullCheck();

        assertFalse(nullCheck.equals(null));
    }
}
