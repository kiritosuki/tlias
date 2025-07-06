package com.dddn.pojo;

public class StudentDegreeData {
    private String name;
    private Integer value;

    public StudentDegreeData(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public StudentDegreeData() {
    }

    @Override
    public String toString() {
        return "StudentDegreeData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
