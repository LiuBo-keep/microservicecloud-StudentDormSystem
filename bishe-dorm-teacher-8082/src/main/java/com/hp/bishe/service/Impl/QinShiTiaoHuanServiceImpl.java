package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.Student;
import com.hp.bishe.dao.QinShiTiaoHuanDao;
import com.hp.bishe.service.QinShiTiaoHuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QinShiTiaoHuanServiceImpl implements QinShiTiaoHuanService {

    @Autowired
    private QinShiTiaoHuanDao qinShiTiaoHuanDao;

    @Override
    public Student findBysn(String sn) {
        return qinShiTiaoHuanDao.findBysn(sn);
    }

    @Override
    public int upsushe(Student student) {
        return qinShiTiaoHuanDao.upsushe(student);
    }
}
