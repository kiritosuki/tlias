package com.dddn.pojo;

import java.util.List;

public class StudentCountData {
    private List<String> clazzList;
    private List<Integer> dataList;

    public StudentCountData(List<String> clazzList, List<Integer> dataList) {
        this.clazzList = clazzList;
        this.dataList = dataList;
    }

    public StudentCountData() {
    }

    @Override
    public String toString() {
        return "StudentCountData{" +
                "clazzList=" + clazzList +
                ", dataList=" + dataList +
                '}';
    }

    public List<String> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<String> clazzList) {
        this.clazzList = clazzList;
    }

    public List<Integer> getDataList() {
        return dataList;
    }

    public void setDataList(List<Integer> dataList) {
        this.dataList = dataList;
    }
}
