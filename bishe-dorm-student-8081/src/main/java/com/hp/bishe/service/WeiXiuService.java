package com.hp.bishe.service;

import com.hp.bishe.bean.WeiXiu;

import java.util.List;

public interface WeiXiuService {

    /**
     * 上传维修信息
     * @param weiXiu 封装信息对象
     * @return int
     */
    public int shang(WeiXiu weiXiu);


    /**
     * 查询个人维修记录
     * @param sn 学号
     * @return
     */
    public List<WeiXiu> get(String sn);
}
