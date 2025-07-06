package com.dddn.pojo;

public class EmpGenderMap {
    private String name;
    private Integer value;

    public EmpGenderMap() {
    }

    public EmpGenderMap(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "EmpGenderMap{" +
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
