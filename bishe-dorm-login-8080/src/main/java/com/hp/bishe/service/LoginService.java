package com.hp.bishe.service;

import com.hp.bishe.bean.Admin;
import com.hp.bishe.bean.Student;

public interface LoginService {

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
