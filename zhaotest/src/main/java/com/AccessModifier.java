package com;

public class AccessModifier {
    private int a;
    int b;
    protected double c;
    public char d;

    public void setA(int a1) {
        a = a1;
    }
}

class AccessModifierTest {
    public static void main(String args[]) {
        AccessModifier obj = new AccessModifier();
        obj.setA(1);
        obj.b = 2;
        obj.c = 1.5;
        obj.d = '#';
        System.out.println(obj.b);
    }
}