package com.hp.bishe.service;

import com.hp.bishe.vo.PasswordVo;

public interface AlterService {

    //修改密码
    public int upPassword(PasswordVo passwordVo);

    //修改头像
    public int upPic(String picName,String username);
}
