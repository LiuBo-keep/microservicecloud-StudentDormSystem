package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.QueQin;
import com.hp.bishe.bean.Student;
import com.hp.bishe.dao.QueQinDao;
import com.hp.bishe.service.QueQinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueQinServiceImpl implements QueQinService {

    private final Logger log= LoggerFactory.getLogger(QueQinServiceImpl.class);

    @Autowired
    private QueQinDao queQinDao;

    @Override
    public int addQueQin(QueQin queqin) {
        Student student=queQinDao.findBySn(queqin.getSn());
        log.info("缺勤学生信息："+student.toString());
        queqin.setUsername(student.getUsername());
        queqin.setSushe(student.getSushe());
        return queQinDao.addQueQin(queqin);
    }
}
