package com.example.spring.jdbctest.com.example.spring.Model;

public class Student {
    private int id;
    private String name;
    private String age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
