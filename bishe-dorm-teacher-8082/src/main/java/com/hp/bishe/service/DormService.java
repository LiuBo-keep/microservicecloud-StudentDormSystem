package com.hp.bishe.service;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.Dorm;
import com.hp.bishe.vo.DormVo;

public interface DormService {

    public PageObject<Dorm> findByData(DormVo dormVo);

    public int add(Dorm dorm);

    public Dorm findById(String id);
}
