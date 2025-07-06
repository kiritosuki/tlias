package com.dddn.pojo;

public class StudentCountMap {
    private String clazzName;
    private Integer studentNum;

    public StudentCountMap(String clazzName, Integer studentNum) {
        this.clazzName = clazzName;
        this.studentNum = studentNum;
    }

    public StudentCountMap() {
    }

    @Override
    public String toString() {
        return "StudentCountMap{" +
                "clazzName='" + clazzName + '\'' +
                ", studentNum=" + studentNum +
                '}';
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }
}
