package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class College {
    private Student student;

    @Autowired
    public College(Student student) {
        this.student = student;
    }

    public void testStudent() {
        student.study();
    }
}
