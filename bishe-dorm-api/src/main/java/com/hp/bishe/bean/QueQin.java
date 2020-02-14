package com.hp.bishe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 缺勤实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueQin implements Serializable {
    private String id;
    //缺勤时间
    private Date data;
    //缺勤学生学号
    private String sn;
    //缺勤学生姓名
    private String username;
    //缺勤学生宿舍
    private String sushe;
    //缺勤原因
    private String remake;
}
