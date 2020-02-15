package com.hp.bishe.service;

import com.hp.bishe.bean.Student;
import com.hp.bishe.vo.PasswordVo;

public interface GenRenXinXiService {
    /**
     * 修改个人信息
     * @return
     */
    public int xiu(Student student);

    //修改密码
    public int upPassword(PasswordVo passwordVo);
}
