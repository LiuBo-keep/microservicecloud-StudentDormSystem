package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.Student;
import com.hp.bishe.bean.WeiXiu;
import com.hp.bishe.service.DormWeiXiuService;
import com.hp.bishe.vo.WeiXiuVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class DormWeiXiuController {

    private static final Logger log = LoggerFactory.getLogger(DormWeiXiuController.class);

    @Autowired
    private DormWeiXiuService dormWeiXiuService;

    //查询所以要维修的记录
    @PostMapping("/list")
    public JsonResult ListWeiXiu(
            @RequestBody WeiXiuVo weiXiuVo
            ){
        log.info("获取所以维修记录："+weiXiuVo.toString());
        PageObject<WeiXiu> pageObject=dormWeiXiuService.getAll(weiXiuVo);
        return new JsonResult(1,pageObject);
    }

    //回显
    @PostMapping("/getsn")
    public JsonResult getBySn(
            @RequestBody WeiXiu weiXiu
            ){
        log.info(weiXiu.getSn()+"-----"+weiXiu.getCreate_time());
        WeiXiu weiXiu1=dormWeiXiuService.getBySn(weiXiu);
        return new JsonResult(1,weiXiu1);
    }

    //报修
    @PostMapping("/update")
    public JsonResult updateWeixiu(
            @RequestBody WeiXiu weiXiu
    ){
        dormWeiXiuService.updateWeixiu(weiXiu);
        log.info("报修："+weiXiu.toString());
        return new JsonResult(1,"报修成功！");
    }
}
