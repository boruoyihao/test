package com.xiaomi.abstractfactory;

public interface AbstractFactory {
    Shape getShape(String name);
    Color getColor(String name);
}
