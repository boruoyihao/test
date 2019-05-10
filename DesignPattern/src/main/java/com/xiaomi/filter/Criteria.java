package com.xiaomi.filter;

import java.util.List;

public interface Criteria {
    List<Student> filter(List<Student>studentList);
}
