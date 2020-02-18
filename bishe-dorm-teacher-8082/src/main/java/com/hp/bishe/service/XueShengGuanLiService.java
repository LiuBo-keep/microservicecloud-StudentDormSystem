package com.hp.bishe.service;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.Student;
import com.hp.bishe.vo.StudentInfo;

public interface XueShengGuanLiService {

    /**
     * 获取所以学生信息
     * @return
     */
    public PageObject<Student> getAll(StudentInfo studentInfo);
}
