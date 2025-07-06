package com.dddn.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EmpQueryParam {
    private String name;
    private Integer gender;     //1男 2女
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
    private Integer page = 1;
    private Integer pageSize = 10;

    public EmpQueryParam() {
    }

    public EmpQueryParam(String name, Integer gender,
                         LocalDate begin, LocalDate end,
                         Integer page, Integer pageSize) {
        this.name = name;
        this.gender = gender;
        this.begin = begin;
        this.end = end;
        this.page = page;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "EmpQueryParam{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", begin=" + begin +
                ", end=" + end +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
