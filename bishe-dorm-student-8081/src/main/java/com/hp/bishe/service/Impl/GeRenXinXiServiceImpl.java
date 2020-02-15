package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.Student;
import com.hp.bishe.dao.GenRenXinXiDao;
import com.hp.bishe.service.GenRenXinXiService;
import com.hp.bishe.vo.PasswordVo;
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

    @Override
    public int upPassword(PasswordVo passwordVo) {
        String sn=passwordVo.getSn();
        Student student=genRenXinXiDao.findBySn(sn);
        if (!passwordVo.getOldPassword().equals(student.getPassword())){
            return 0;
        }else {
           return genRenXinXiDao.upPassword(passwordVo);
        }
    }

    @Override
    public int upPic(String picName, String sn) {
        Student student=new Student();
        student.setSn(sn);
        student.setPhoto(picName);
        return genRenXinXiDao.upPic(student);
    }
}
