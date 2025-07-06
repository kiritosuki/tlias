package com.dddn.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private Integer id;
    private String name;
    private String no;  //学号
    private Integer gender;    //1男 2女
    private String phone;
    private String idCard;
    private Integer isCollege;    //是否来自于院校 1是 0否
    private String address;
    private Integer degree;     //学历 1初中 2高中 3大专 4本科 5硕士 6博士
    private LocalDate graduationDate;       //毕业日期
    private Integer clazzId;    //班级id
    private Integer violationCount;     //违纪次数
    private Integer violationScore;     //违纪扣分
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    //数据库没有的属性
    private String clazzName;

    public Student() {
    }

    public Student(Integer id, String name,
                   String no, Integer gender,
                   String phone, String idCard,
                   Integer isCollege, String address,
                   Integer degree, LocalDate graduationDate,
                   Integer clazzId, Integer violationCount,
                   Integer violationScore, LocalDateTime createTime,
                   LocalDateTime updateTime, String clazzName) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.gender = gender;
        this.phone = phone;
        this.idCard = idCard;
        this.isCollege = isCollege;
        this.address = address;
        this.degree = degree;
        this.graduationDate = graduationDate;
        this.clazzId = clazzId;
        this.violationCount = violationCount;
        this.violationScore = violationScore;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.clazzName = clazzName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", isCollege=" + isCollege +
                ", address='" + address + '\'' +
                ", degree=" + degree +
                ", graduationDate=" + graduationDate +
                ", clazzId=" + clazzId +
                ", violationCount=" + violationCount +
                ", violationScore=" + violationScore +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", clazzName='" + clazzName + '\'' +
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getIsCollege() {
        return isCollege;
    }

    public void setIsCollege(Integer isCollege) {
        this.isCollege = isCollege;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(Integer violationCount) {
        this.violationCount = violationCount;
    }

    public Integer getViolationScore() {
        return violationScore;
    }

    public void setViolationScore(Integer violationScore) {
        this.violationScore = violationScore;
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

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }
}
