package com.hp.bishe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 维修信息实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeiXiu implements Serializable {
    private Long id;
    //学号
    private String sn;
    //保修地址
    private String addre;
    //维修对象
    private String obj;
    //联系电话
    private String phone;
    //维修状态
    private String status;
    //上报时间
    private Date time;
    //维修费用
    private String cost;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
