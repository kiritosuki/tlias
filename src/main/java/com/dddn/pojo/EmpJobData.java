package com.dddn.pojo;

import java.util.List;

public class EmpJobData {
    private List<String> jobList;
    private List<Integer> dataList;

    public EmpJobData(List<String> jobList, List<Integer> dataList) {
        this.jobList = jobList;
        this.dataList = dataList;
    }

    public EmpJobData() {
    }

    @Override
    public String toString() {
        return "EmpJobData{" +
                "jobList=" + jobList +
                ", dataList=" + dataList +
                '}';
    }

    public List<String> getJobList() {
        return jobList;
    }

    public void setJobList(List<String> jobList) {
        this.jobList = jobList;
    }

    public List<Integer> getDataList() {
        return dataList;
    }

    public void setDataList(List<Integer> dataList) {
        this.dataList = dataList;
    }
}
