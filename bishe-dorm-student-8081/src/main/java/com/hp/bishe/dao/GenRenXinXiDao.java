package com.hp.bishe.dao;

import com.hp.bishe.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenRenXinXiDao {
    public int xiu(Student student);
}
