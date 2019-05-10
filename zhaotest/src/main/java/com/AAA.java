package com;

/**
 * Created by zhaolizhen on 17-8-4.
 */
public class AAA {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AAA)) return false;

        AAA aaa = (AAA) o;

        return !(getName() != null ? !getName().equals(aaa.getName()) : aaa.getName() != null);

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
