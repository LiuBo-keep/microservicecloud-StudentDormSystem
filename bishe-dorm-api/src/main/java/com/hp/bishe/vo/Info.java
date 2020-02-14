package com.hp.bishe.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 获取页面信息类
 */

@Data
public class Info implements Serializable {
    /***搜索开始时间*/
    private Date start;
    /**搜索结束时间*/
    private Date stop;
    /**学号*/
    private String sn;
    /**每页条数*/
    private Integer size;
    /**当前页码*/
    private Integer pageCurrent;
    /**开始行*/
    private Integer startRow= 0;

    public Info() {
    }

    public Info(Date start, Date stop, String sn, Integer size, Integer pageCurrent, Integer startRow) {
        this.start = start;
        this.stop = stop;
        this.sn = sn;
        this.size = size;
        this.pageCurrent = pageCurrent;
        this.startRow = startRow;
    }
}
