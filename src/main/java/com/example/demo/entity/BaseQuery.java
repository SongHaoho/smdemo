package com.example.demo.entity;

/**
 * 分页查询VO继承的查询条件类
 *  (是否需要继承Serializable)
 */
public class BaseQuery {

    //页码
    private int pageNum = 1;
    //行数
    private int pageSize = 5;
    //排序规则   desc 降序 other 升序
    private String sord;
    //排序字段名
    private String sidx;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }


}
