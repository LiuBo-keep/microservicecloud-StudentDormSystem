package com.hp.bishe.service;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.WeiXiu;
import com.hp.bishe.vo.WeiXiuVo;

public interface DormWeiXiuService {

    //获取所以维修记录
    public PageObject<WeiXiu> getAll(WeiXiuVo weiXiuVo);

    //报修
    public void updateWeixiu(String id);
}
