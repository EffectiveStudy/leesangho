package com.github.sangholee.dev.effectivejavastudy.study05_item28;

import java.lang.constant.Constable;

public class GenericTypeErasure {

    /**
     * Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
     * Insert type casts if necessary to preserve type safety.
     * Generate bridge methods to preserve polymorphism in extended generic types.
     *
     * https://docs.oracle.com/javase/tutorial/java/generics/erasure.html
     */

    public static <E> boolean containsElement(E[] elements, E element) {
        for (E e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static <E extends Integer> boolean containsElement(E[] elements, E element) {
        for (E e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static <E extends Number & Cloneable & Comparable<E>> boolean containsElement(E[] elements, E element) {
        for (E e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static <E extends Comparable<Long> & Constable> boolean containsElement(E[] elements, E element) {
        for (E e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }

        return false;
    }

}
