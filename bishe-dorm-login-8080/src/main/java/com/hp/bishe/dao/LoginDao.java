package com.hp.bishe.dao;

import com.hp.bishe.bean.Admin;
import com.hp.bishe.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    /**
     * 管理员登录
     * @param username
     * @return
     */
    public Admin AdminLogin(String username);

    /**
     * 学生登录
     * @param username
     * @return
     */
    public Student StudentLogin(String username);
}
