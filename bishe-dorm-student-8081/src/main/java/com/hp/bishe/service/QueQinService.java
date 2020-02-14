package com.hp.bishe.service;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.QueQin;
import com.hp.bishe.vo.Info;

public interface QueQinService {

    /**
     * 查询我的考勤
     * @param info
     * @return
     */
    public PageObject<QueQin> findByData(Info info);
}
