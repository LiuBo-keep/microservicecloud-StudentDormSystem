package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Student;
import com.hp.bishe.utils.SessionUtil;
import com.hp.bishe.vo.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

    private final Logger log= LoggerFactory.getLogger(StudentController.class);

    private static final String REST_URL_PREFIX_Student="http://MICROSERVICECLOUD-STUDENT";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private SessionUtil sessionUtil;


    @RequestMapping("/student/xiugai")
    public JsonResult update(Student student){
        //        Student student=(Student) redisTemplate.opsForValue().get("Student");
        System.out.println(student);
        student.setSn("1850510408");
        log.info("学生修改信息");
        return restTemplate.postForObject(REST_URL_PREFIX_Student+"/student/xiugai",student,JsonResult.class);
    }

    @RequestMapping("/student/que")
    public JsonResult get(Info info){
//        Student student=(Student) redisTemplate.opsForValue().get("Student");
        info.setSn("1850510408");
        log.info("学生查询缺勤记录");
        return restTemplate.postForObject(REST_URL_PREFIX_Student+"/student/queqinjilu",info,JsonResult.class);
    }
}
