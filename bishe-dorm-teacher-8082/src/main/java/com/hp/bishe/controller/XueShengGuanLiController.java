package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.Student;
import com.hp.bishe.service.XueShengGuanLiService;
import com.hp.bishe.vo.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class XueShengGuanLiController {

    @Autowired
    private XueShengGuanLiService shengGuanLiService;

    @PostMapping("/xueShengGuanLi")
    public JsonResult getAll(
            @RequestBody StudentInfo studentInfo
    ){
        PageObject<Student> pageObject=shengGuanLiService.getAll(studentInfo);
        return new JsonResult(1,pageObject);
    }
}
