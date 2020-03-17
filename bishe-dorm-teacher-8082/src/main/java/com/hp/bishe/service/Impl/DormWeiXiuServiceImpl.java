package com.hp.bishe.service.Impl;

import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.WeiXiu;
import com.hp.bishe.dao.DormWeiXiuDao;
import com.hp.bishe.service.DormWeiXiuService;
import com.hp.bishe.vo.WeiXiuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormWeiXiuServiceImpl implements DormWeiXiuService
{
    @Autowired
    private DormWeiXiuDao dormWeiXiuDao;

    @Override
    public PageObject<WeiXiu> getAll(WeiXiuVo weiXiuVo) {
        PageObject<WeiXiu> pageObject=new PageObject<WeiXiu>();

        /**设置每页显示条数*/
        weiXiuVo.setSize(10);

        if (weiXiuVo.getPageCurrent()!=null){
            pageObject.setPageCurrent(weiXiuVo.getPageCurrent());
            /**页面有数据，重新计算开始行,每页显示5条数据*/
            weiXiuVo.setStartRow((weiXiuVo.getPageCurrent() - 1) * weiXiuVo.getSize());
        }

        /**总记录数*/
        pageObject.setTotal(dormWeiXiuDao.findConnt(weiXiuVo));
        System.out.println(pageObject.getTotal());

        /**总页数*/
        if (pageObject.getTotal() % weiXiuVo.getSize()!=0){
            pageObject.setPageCount((pageObject.getTotal() / weiXiuVo.getSize())+1);
        }else {
            pageObject.setPageCount((pageObject.getTotal() / weiXiuVo.getSize()));
        }

        /**结果集*/
        pageObject.setItems(dormWeiXiuDao.findByData(weiXiuVo));
        System.out.println(pageObject.getItems());

        return pageObject;
    }

    @Override
    public void updateWeixiu(String id) {
        String xuehao=id.substring(0,9);
        String cort=id.substring(10);
        WeiXiu weiXiu=new WeiXiu();
        weiXiu.setSn(xuehao);
        weiXiu.setCost(cort);
        dormWeiXiuDao.updateWeixiu(weiXiu);
    }
}
