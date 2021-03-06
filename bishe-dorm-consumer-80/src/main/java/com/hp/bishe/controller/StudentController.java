package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Student;
import com.hp.bishe.bean.WeiXiu;
import com.hp.bishe.bean.YiJian;
import com.hp.bishe.service.Student_PicService;
import com.hp.bishe.utils.SessionUtil;
import com.hp.bishe.vo.Info;
import com.hp.bishe.vo.PasswordVo;
import com.hp.bishe.vo.PicVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StudentController {

    private final Logger log= LoggerFactory.getLogger(StudentController.class);

    private static final String REST_URL_PREFIX_Student="http://MICROSERVICECLOUD-STUDENT";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private Student_PicService service;
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

    @RequestMapping("/student/password")
    public JsonResult upPassword(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword1") String newPassword1,
            @RequestParam("newPassword2") String newPassword2
    ){
        if (oldPassword.trim()==""||oldPassword.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword1.trim()==""||newPassword1.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword2.trim()==""||newPassword2.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (!newPassword1.equals(newPassword2)){
            return new JsonResult(0,"新密码两次输入不一致,请重新输入！");
        }
//        Student student=(Student) redisTemplate.opsForValue().get("Student");
//        System.out.println("--------------------------------------"+student);
        PasswordVo passwordVo=new PasswordVo();
        passwordVo.setSn("1850510408");
        passwordVo.setOldPassword(oldPassword);
        passwordVo.setNewPassword1(newPassword1);
        passwordVo.setNewPassword2(newPassword2);
        return restTemplate.postForObject(REST_URL_PREFIX_Student+"/student/password",passwordVo,JsonResult.class);
    }

    @RequestMapping("/student/pic")
    public JsonResult upPic(
           @RequestPart("photo") MultipartFile photo
    ){
        return service.upPic("1850510408",photo);
    }

    @RequestMapping("/student/que")
    public JsonResult get(Info info){
//        Student student=(Student) redisTemplate.opsForValue().get("Student");
        info.setSn("1850510408");
        log.info("学生查询缺勤记录"+info);
        return restTemplate.postForObject(REST_URL_PREFIX_Student+"/student/queqinjilu",info,JsonResult.class);
    }

    @RequestMapping("/student/shangbaoweixiu")
    public JsonResult add(WeiXiu weiXiu){
        weiXiu.setSn("1850510408");
        log.info("学生上报维修信息"+weiXiu);
        return restTemplate.postForObject(REST_URL_PREFIX_Student+"/student/shangbao",weiXiu,JsonResult.class);
    }

    @RequestMapping("/student/chaxun")
    public JsonResult get(){
        Student student=new Student();
        student.setSn("1850510408");
        log.info("学生查询维修记录");
        return restTemplate.postForObject(REST_URL_PREFIX_Student+"/student/chaxun",student,JsonResult.class);
    }

    @RequestMapping("/student/yijian")
    public JsonResult add(YiJian yiJian){
        log.info("学生建议评价："+yiJian);
     return restTemplate.postForObject(REST_URL_PREFIX_Student+"/student/jianyi",yiJian,JsonResult.class);
    }
}
