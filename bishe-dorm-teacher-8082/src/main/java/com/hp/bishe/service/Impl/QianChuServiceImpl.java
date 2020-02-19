package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.Student;
import com.hp.bishe.dao.QianChuDao;
import com.hp.bishe.service.QianChuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QianChuServiceImpl implements QianChuService {
    @Autowired
    private QianChuDao qianChuDao;

    @Override
    public int updata(Student student) {
        return qianChuDao.upstudent(student);
    }
}
