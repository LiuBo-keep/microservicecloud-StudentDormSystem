package com.hp.bishe.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVo {
    //学号
    private String sn;
    //旧密码
    private String oldPassword;
    //新密码
    private String newPassword1;
    //确认新密码
    private String newPassword2;
}
