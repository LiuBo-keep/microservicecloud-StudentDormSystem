package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.Admin;
import com.hp.bishe.bean.Student;
import com.hp.bishe.dao.LoginDao;
import com.hp.bishe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public Admin AdminLogin(String username) {
        return loginDao.AdminLogin(username);
    }

    @Override
    public Student StudentLogin(String username) {
        return loginDao.StudentLogin(username);
    }
}
