package com.hp.bishe.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 *管理员实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    //用户id 主键  自增
    private Long id;
    //用户名
    private String username;
    //密码
    private String password;
    //头像
    private String photo;
}
