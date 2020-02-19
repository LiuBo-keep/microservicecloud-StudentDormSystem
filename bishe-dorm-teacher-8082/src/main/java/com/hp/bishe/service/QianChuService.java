package com.hp.bishe.service;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.Student;
import com.hp.bishe.vo.StudentInfo;

public interface QianChuService {

    public int updata(Student student);

    public PageObject<Student> findByStatus(StudentInfo studentInfo);
}
