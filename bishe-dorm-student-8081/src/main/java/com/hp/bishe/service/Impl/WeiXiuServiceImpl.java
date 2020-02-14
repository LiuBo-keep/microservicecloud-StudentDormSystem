package com.hp.bishe.service.Impl;

import com.hp.bishe.bean.WeiXiu;
import com.hp.bishe.dao.WeiXiuDao;
import com.hp.bishe.service.WeiXiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WeiXiuServiceImpl implements WeiXiuService {

    @Autowired
    private WeiXiuDao weiXiuDao;

    @Override
    public int shang(WeiXiu weiXiu) {
        //设置默认状态
        weiXiu.setStatus("未维修");
        weiXiu.setTime(new Date());
        weiXiu.setCost("0");
        return weiXiuDao.shang(weiXiu);
    }

    @Override
    public List<WeiXiu> get(String sn) {
        return weiXiuDao.get(sn);
    }
}
