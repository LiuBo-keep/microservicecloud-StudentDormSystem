package com.hp.bishe.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生信息实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Long id;
    //学号
    private String sn;
    //姓名
    private String username;
    //密码
    private String password;
    //班级id
    private String clazzId;
    //宿舍号
    private String sushe;
    //床号
    private String bed;
    //学别
    private String sex;
    //头像
    private String photo;
    //住宿状态
    private String status;
    //个性签名
    private String remark;
    //迁出备注
    private String qianRemark;
    //迁出日期
    private Date qianchuDate;
}
