package com.hp.bishe.dao;

import com.hp.bishe.bean.QueQin;
import com.hp.bishe.vo.Info;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueQinDao {

    public int findConnt(Info info);

    public List<QueQin> findByData(Info info);
}
