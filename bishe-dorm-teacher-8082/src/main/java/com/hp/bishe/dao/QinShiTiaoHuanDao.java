package com.hp.bishe.dao;

import com.hp.bishe.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QinShiTiaoHuanDao {

    public Student findBysn(String sn);

    public int upsushe(Student student);
}
