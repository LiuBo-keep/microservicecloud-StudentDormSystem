package com.hp.bishe.vo;

import java.io.Serializable;
import java.util.Date;

public class WeiXiuVo implements Serializable {
    /***搜索开始时间*/
    private Date start;
    /**搜索结束时间*/
    private Date stop;
    /**每页条数*/
    private Integer size;
    /**当前页码*/
    private Integer pageCurrent;
    /**开始行*/
    private Integer startRow= 0;

    public WeiXiuVo() {
    }

    public WeiXiuVo(Date start, Date stop, Integer size, Integer pageCurrent, Integer startRow) {
        this.start = start;
        this.stop = stop;
        this.size = size;
        this.pageCurrent = pageCurrent;
        this.startRow = startRow;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
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

    @Override
    public String toString() {
        return "WeiXiuVo{" +
                "start=" + start +
                ", stop=" + stop +
                ", size=" + size +
                ", pageCurrent=" + pageCurrent +
                ", startRow=" + startRow +
                '}';
    }
}
