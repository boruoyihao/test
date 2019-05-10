package com.model;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import com.google.common.base.Objects;

@ThriftStruct
public class Student {
    
    private String name;
    private String sex;
    @ThriftField(1)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @ThriftField(2)
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("sex",sex).add("name",name).toString();
    }
}
