package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Student;
import com.hp.bishe.service.QinShiTiaoHuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class QinShiTiaoHuanController {

    @Autowired
    private QinShiTiaoHuanService qinShiTiaoHuanService;

    //根据查询查询学生
    @GetMapping("/get/{xuehao}")
    public JsonResult getBySn(
            @PathVariable("xuehao") String sn
    ){
        Student student=qinShiTiaoHuanService.findBysn(sn);
        return new JsonResult(1,student);
    }

    //调换寝室
    @PostMapping("/tiao")
    public JsonResult upSuShe(
            @RequestBody Student student
    ){
        qinShiTiaoHuanService.upsushe(student);
        return new JsonResult(1,"调换成功！");
    }
}
