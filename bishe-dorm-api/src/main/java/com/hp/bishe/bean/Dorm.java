package com.hp.bishe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 学生寝室信息实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dorm implements Serializable {
    private Long id;
    //寝室号
    private String dormId;
    //寝室类型
    private String dormType;
    //寝室长
    private String dormMonitor;
    //寝室长电话
    private String dormMonitorPhone;
}
