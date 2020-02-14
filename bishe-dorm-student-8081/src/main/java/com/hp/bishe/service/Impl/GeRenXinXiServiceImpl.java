package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.Student;
import com.hp.bishe.dao.GenRenXinXiDao;
import com.hp.bishe.service.GenRenXinXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeRenXinXiServiceImpl implements GenRenXinXiService {

    @Autowired
    private GenRenXinXiDao genRenXinXiDao;


    @Override
    public int xiu(Student student) {
        return genRenXinXiDao.xiu(student);
    }
}
