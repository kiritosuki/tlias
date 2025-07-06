package com.dddn.pojo;

public class PageParam {
    private Integer page = 1;
    private Integer pageSize = 10;

    public PageParam() {
    }

    public PageParam(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
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
