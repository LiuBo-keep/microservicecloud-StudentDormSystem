package com.hp.bishe.controller;


import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.QueQin;
import com.hp.bishe.service.QueQinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher")
public class QueQinController {

    @Autowired
    private QueQinService queQinService;

    @PostMapping("/queqin")
    public JsonResult queqin(
           @RequestBody QueQin queQin
    ){
        int count=queQinService.addQueQin(queQin);

        return new JsonResult(1,"保存成功");
    }
}
