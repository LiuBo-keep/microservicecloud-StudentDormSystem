package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.Utils.PageObject;
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
    @GetMapping("/list")
    public JsonResult ListWeiXiu(
             WeiXiuVo weiXiuVo
            ){
        PageObject<WeiXiu> pageObject=dormWeiXiuService.getAll(weiXiuVo);
        return new JsonResult(1,pageObject);
    }

    //报修
    @PostMapping("/update/{id}")
    public JsonResult updateWeixiu(
            @PathVariable("id") String id
    ){
        dormWeiXiuService.updateWeixiu(id);
        return new JsonResult(1,"报修成功！");
    }
}