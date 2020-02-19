package com.hp.bishe.dao;

import com.hp.bishe.bean.Admin;
import com.hp.bishe.vo.PasswordVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlterDao {

    //根据用户名查询
    public Admin findByusername(String username);
    //修改密码
    public int upPassword(PasswordVo passwordVo);
    //修改头像
    public int upPic(Admin admin);
}
