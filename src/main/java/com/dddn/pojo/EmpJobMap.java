package com.dddn.pojo;

public class EmpJobMap {
    private String jobName;
    private Integer jobNum;

    public EmpJobMap() {
    }

    public EmpJobMap(String jobName, Integer jobNum) {
        this.jobName = jobName;
        this.jobNum = jobNum;
    }

    @Override
    public String toString() {
        return "EmpJobMap{" +
                "jobName='" + jobName + '\'' +
                ", jobNum=" + jobNum +
                '}';
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getJobNum() {
        return jobNum;
    }

    public void setJobNum(Integer jobNum) {
        this.jobNum = jobNum;
    }
}
