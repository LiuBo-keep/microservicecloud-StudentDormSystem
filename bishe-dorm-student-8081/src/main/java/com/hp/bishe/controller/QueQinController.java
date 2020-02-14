package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.QueQin;
import com.hp.bishe.service.QueQinService;
import com.hp.bishe.vo.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class QueQinController {

    private final Logger log= LoggerFactory.getLogger(QueQinController.class);

    @Autowired
    private QueQinService queQinService;

    /**
     *
     * @param info 接收页面信息
     * @return 返回结果
     */
    @PostMapping("/queqinjilu")
    public JsonResult jilu(@RequestBody Info info){
        log.info("搜索开始时间："+info.getStart()+"搜索结束时间："+info.getStop());
        PageObject<QueQin> pageObject=queQinService.findByData(info);
        return new JsonResult(1,pageObject);
    }
}
