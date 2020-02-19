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
    private QinShiTiaoHuanService qinShiTiaoHuanService;
    @Autowired
    private QianChuService qianChuService;


    //根据查询查询学生
    @GetMapping("/student/{xuehao}")
    public JsonResult getBySn(
            @PathVariable("xuehao") String sn,
            HttpSession session
    ){
        Student student=qinShiTiaoHuanService.findBysn(sn);
        session.setAttribute("qian",student.getSn());
        return new JsonResult(1,student);
    }

    //学生迁出
    @PostMapping("/tu")
    public JsonResult upStudent(
            @RequestParam("qianremark") String qianremark,
            HttpSession session
    ){
        Student student=new Student();
//        student.setSn((String) session.getAttribute("qian"));
        student.setSn("1850510407");
        student.setStatus("迁出");
        student.setQianchuDate(new Date());
        student.setQianRemark(qianremark);
        qianChuService.updata(student);
        return new JsonResult(1,"迁出成功");
    }
}
