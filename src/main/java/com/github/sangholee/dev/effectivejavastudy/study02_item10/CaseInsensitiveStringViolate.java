package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import java.util.Objects;

public class CaseInsensitiveStringViolate {

    private final String s;

    public CaseInsensitiveStringViolate(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveStringViolate) {
            return s.equalsIgnoreCase(((CaseInsensitiveStringViolate) o).s);
        }

        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }

        return false;
    }
}
