package com.example.demo.bean;

import java.util.Date;

/**
 * Created by SongHao on 2018/4/16.
 */
public class Area {
    /**
     * 主键ID
     */
    private Integer areaId;
    /**
     * 名称
     */
    private String areaName;
    /**
     * 权重，越大越前排展示
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date lastEditTime;

    /**
     *  是否逻辑删除
     */
    private String active;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                ", active='" + active + '\'' +
                '}';
    }
}
