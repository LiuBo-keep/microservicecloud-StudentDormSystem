package com.hp.bishe.service.Impl;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.Dorm;
import com.hp.bishe.dao.DormDao;
import com.hp.bishe.service.DormService;
import com.hp.bishe.vo.DormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormServiceImpl implements DormService {

    @Autowired
    private DormDao dormDao;

    @Override
    public PageObject<Dorm> findByData(DormVo dormVo) {
        PageObject<Dorm> pageObject=new PageObject<Dorm>();

        dormVo.setSize(10);

        if (dormVo.getPageCurrent()!=null){
            pageObject.setPageCurrent(dormVo.getPageCurrent());
            /**页面有数据，重新计算开始行,每页显示5条数据*/
            dormVo.setStartRow((dormVo.getPageCurrent() - 1) * dormVo.getSize());
        }

        /**总记录数*/
        pageObject.setTotal(dormDao.findConnt(dormVo));
        System.out.println(pageObject.getTotal());

        /**总页数*/
        if (pageObject.getTotal() % dormVo.getSize()!=0){
            pageObject.setPageCount((pageObject.getTotal() / dormVo.getSize())+1);
        }else {
            pageObject.setPageCount((pageObject.getTotal() / dormVo.getSize()));
        }

        /**结果集*/
        pageObject.setItems(dormDao.findByData(dormVo));
        System.out.println(pageObject.getItems());


        return pageObject;
    }

    @Override
    public int add(Dorm dorm) {
        return dormDao.add(dorm);
    }

    @Override
    public Dorm findById(String id) {
        return dormDao.findById(id);
    }
}
