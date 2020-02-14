package com.hp.bishe.service.Impl;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.QueQin;
import com.hp.bishe.bean.Student;
import com.hp.bishe.dao.QueQinDao;
import com.hp.bishe.service.QueQinService;
import com.hp.bishe.vo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueQinSerivceImpl implements QueQinService {

    @Autowired
    private QueQinDao queQinDao;

    @Override
    public PageObject<QueQin> findByData(Info info) {
        PageObject<QueQin> pageObject=new PageObject<QueQin>();

        /**设置每页显示条数*/
        info.setSize(10);

        if (info.getPageCurrent()!=null){
            pageObject.setPageCurrent(info.getPageCurrent());
            /**页面有数据，重新计算开始行,每页显示5条数据*/
            info.setStartRow((info.getPageCurrent() - 1) * info.getSize());
        }

        /**总记录数*/
        pageObject.setTotal(queQinDao.findConnt(info));
        System.out.println(pageObject.getTotal());

        /**总页数*/
        if (pageObject.getTotal() % info.getSize()!=0){
            pageObject.setPageCount((pageObject.getTotal() / info.getSize())+1);
        }else {
            pageObject.setPageCount((pageObject.getTotal() / info.getSize()));
        }

        /**结果集*/
        pageObject.setItems(queQinDao.findByData(info));
        System.out.println(pageObject.getItems());

        return pageObject;
    }
}
