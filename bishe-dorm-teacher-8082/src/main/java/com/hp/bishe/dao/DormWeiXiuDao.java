package com.hp.bishe.dao;

import com.hp.bishe.bean.Student;
import com.hp.bishe.bean.WeiXiu;
import com.hp.bishe.vo.WeiXiuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormWeiXiuDao {

    //获取总记录数
    public Integer findConnt(WeiXiuVo weiXiuVo);
    //获取所以维修记录
    public List<WeiXiu> findByData(WeiXiuVo weiXiuVo);
    //报修
    public Integer updateWeixiu(WeiXiu weiXiu);
    //回显
    public WeiXiu getBySn(WeiXiu weiXiu);
}
