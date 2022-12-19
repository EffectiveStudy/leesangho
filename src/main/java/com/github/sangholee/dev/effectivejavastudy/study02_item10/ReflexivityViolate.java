package com.github.sangholee.dev.effectivejavastudy.study02_item10;

import java.util.Objects;

public class ReflexivityViolate {

    private String name;

    private String address;

    public ReflexivityViolate(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReflexivityViolate that = (ReflexivityViolate) o;
        return Objects.equals(address, that.name) && Objects.equals(name,
                that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
