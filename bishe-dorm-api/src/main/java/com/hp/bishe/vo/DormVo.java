package com.hp.bishe.vo;

import java.io.Serializable;

public class DormVo implements Serializable {
    /**寝室号*/
    private String dormId;
    /**舍长姓名*/
    private String dormMonitor;
    /**每页条数*/
    private Integer size;
    /**当前页码*/
    private Integer pageCurrent;
    /**开始行*/
    private Integer startRow= 0;

    public DormVo() {
    }

    public DormVo(String dormId, String dormMonitor, Integer size, Integer pageCurrent, Integer startRow) {
        this.dormId = dormId;
        this.dormMonitor = dormMonitor;
        this.size = size;
        this.pageCurrent = pageCurrent;
        this.startRow = startRow;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public String getDormMonitor() {
        return dormMonitor;
    }

    public void setDormMonitor(String dormMonitor) {
        this.dormMonitor = dormMonitor;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
