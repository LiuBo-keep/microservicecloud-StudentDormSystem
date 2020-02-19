package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Student;
import com.hp.bishe.service.QianChuService;
import com.hp.bishe.service.QinShiTiaoHuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/teacher")
public class QianChuController {

    @Autowired
    private QianChuService qianChuService;

    //学生迁出
    @PostMapping("/tu")
    public JsonResult upStudent(
           @RequestBody Student student,
            HttpSession session
    ){
        student.setStatus("迁出");
        student.setQianchuDate(new Date());
        qianChuService.updata(student);
        return new JsonResult(1,"迁出成功");
    }
}
