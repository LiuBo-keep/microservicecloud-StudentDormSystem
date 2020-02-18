package com.hp.bishe.vo;


import java.io.Serializable;

public class StudentInfo implements Serializable {
    /**住宿状态*/
    private String status;
    /**姓名*/
    private String username;
    /**学号*/
    private String sn;
    /**班级*/
    private String clazz;
    /**每页条数*/
    private Integer size;
    /**当前页码*/
    private Integer pageCurrent;
    /**开始行*/
    private Integer startRow= 0;

    public StudentInfo() {
    }

    public StudentInfo(String status, String username, String sn, String clazz, Integer size, Integer pageCurrent, Integer startRow) {
        this.status = status;
        this.username = username;
        this.sn = sn;
        this.clazz = clazz;
        this.size = size;
        this.pageCurrent = pageCurrent;
        this.startRow = startRow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
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
