package com.dddn.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Clazz {
    private Integer id;
    private String name;
    private String room;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Integer masterId;   //班主任id 关联员工id
    private Integer subject;    //学科 1-java 2-前端 3-大数据 4-python 5-go 6-嵌入式
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    //数据库没有的新增属性
    private String masterName;
    private String status;

    public Clazz(Integer id, String name,
                 String room, LocalDate beginDate,
                 LocalDate endDate, Integer masterId,
                 Integer subject, LocalDateTime createTime,
                 LocalDateTime updateTime, String masterName,
                 String status) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.masterId = masterId;
        this.subject = subject;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.masterName = masterName;
        this.status = status;
    }

    public Clazz() {
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", masterId=" + masterId +
                ", subject=" + subject +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", masterName='" + masterName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
