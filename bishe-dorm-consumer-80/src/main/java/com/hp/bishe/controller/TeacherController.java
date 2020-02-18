package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.vo.StudentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final Logger log= LoggerFactory.getLogger(TeacherController.class);

    private static final String REST_URL_PREFIX_Teacher="http://MICROSERVICECLOUD-TEACHER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/xueShengGuanLi")
    public JsonResult getAll(
            StudentInfo studentInfo,
            @RequestParam(value = "qita",required = false) String qita,
            @RequestParam(value = "qitanei" ,required = false) String qitanei
    ){
        if ("姓名".equals(qita)){
            studentInfo.setUsername(qitanei);
        }
        if ("学号".equals(qita)){
            studentInfo.setSn(qitanei);
        }
        if ("班级".equals(qita)){
            studentInfo.setClazz(qitanei);
        }
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/xueShengGuanLi",studentInfo,JsonResult.class);
    }
}
