package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.Admin;
import com.hp.bishe.dao.AlterDao;
import com.hp.bishe.service.AlterService;
import com.hp.bishe.vo.PasswordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterServiceImpl implements AlterService {

    @Autowired
    private AlterDao alterDao;

    @Override
    public int upPassword(PasswordVo passwordVo) {
        String username=passwordVo.getUsername();
        Admin admin=alterDao.findByusername(username);
        if (!passwordVo.getOldPassword().equals(admin.getPassword())){
            return 0;
        }else {
            return alterDao.upPassword(passwordVo);
        }
    }
}
