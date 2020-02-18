package com.hp.bishe.dao;

import com.hp.bishe.bean.Dorm;
import com.hp.bishe.vo.DormVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormDao {

    public int findConnt(DormVo dormVo);

    public List<Dorm> findByData(DormVo dormVo);

    public int add(Dorm dorm);

    public Dorm findById(String id);
}
