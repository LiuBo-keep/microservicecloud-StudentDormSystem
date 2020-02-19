package com.hp.bishe.dao;

import com.hp.bishe.bean.Student;
import com.hp.bishe.vo.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QianChuDao {

    public int upstudent(Student student);

    public int findConnt(StudentInfo studentInfo);

    public List<Student> findByData(StudentInfo studentInfo);
}
