package com.hp.bishe.dao;

import com.hp.bishe.bean.Student;
import com.hp.bishe.vo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XueShengGuanLiDao {

    /**
     * 获取所以学生信息总记录数
     * @return Inteder
     */
    public Integer findConnt(StudentInfo studentInfo);

    /**
     * 获取所以学生信息
     * @param studentInfo 入参
     * @return List<Student>
     */
    public List<Student> findByData(StudentInfo studentInfo);
}
