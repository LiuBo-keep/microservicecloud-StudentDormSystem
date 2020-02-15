package com.hp.bishe.dao;

import com.hp.bishe.bean.Student;
import com.hp.bishe.vo.PasswordVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenRenXinXiDao {
    public int xiu(Student student);

    public Student findBySn(String sn);

    public int upPassword(PasswordVo passwordVo);

    public int upPic(Student student);
}
