package com.dddn.pojo;

import java.time.LocalDate;

public class ClazzQueryParam {
    private String name;
    private LocalDate begin;
    private LocalDate end;
    private Integer page = 1;
    private Integer pageSize = 10;

    public ClazzQueryParam() {
    }

    public ClazzQueryParam(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        this.name = name;
        this.begin = begin;
        this.end = end;
        this.page = page;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ClazzQueryParam{" +
                "name='" + name + '\'' +
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
