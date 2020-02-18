package com.hp.bishe.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVo implements Serializable {
    //学号
    private String sn;
    //用户名
    private String username;
    //旧密码
    private String oldPassword;
    //新密码
    private String newPassword1;
    //确认新密码
    private String newPassword2;
}
