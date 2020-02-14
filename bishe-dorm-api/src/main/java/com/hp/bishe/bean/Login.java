package com.hp.bishe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登录实体
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login implements Serializable {
    //用户名
    private String username;
    //密码
    private String password;
    //身份
    private Integer type;
}
