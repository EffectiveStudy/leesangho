package com.github.sangholee.dev.effectivejavastudy.study11_item57;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.Element;

public class Item57 {

    public static void main(String[] args) {
        caseWhile();
        caseFor();
    }

    private static void caseWhile() {
        List<Element> c = new ArrayList<>();
        List<Element> c2 = new ArrayList<>();
        Iterator<Element> i = c.iterator();
        while(i.hasNext()) {
            doSomeThing(i.next());
        }

        Iterator<Element> i2 = c2.iterator();
        while(i.hasNext()) { // 복붙으로 인한 오류
            doSomeThing(i2.next());
        }
    }

    private static void doSomeThing(Element next) {
        System.out.println(next);
    }

    private static void caseFor() {
        List<Element> c = new ArrayList<>();
        List<Element> c2 = new ArrayList<>();

        for(Iterator<Element> i = c.iterator(); i.hasNext();) {
            Element e = i.next();
        }

//        for(Iterator<Element> i2 = c2.iterator(); i.hasNext();) {
//            Element e2 = i2.next();
//        }
    }
}
