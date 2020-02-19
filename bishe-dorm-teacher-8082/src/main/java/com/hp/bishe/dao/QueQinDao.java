package com.hp.bishe.dao;

import com.hp.bishe.bean.QueQin;
import com.hp.bishe.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueQinDao {

    //根据学号查询学生信息
    public Student findBySn(String sn);

    //添加学生缺勤记录
    public int addQueQin(QueQin queqin);
}
