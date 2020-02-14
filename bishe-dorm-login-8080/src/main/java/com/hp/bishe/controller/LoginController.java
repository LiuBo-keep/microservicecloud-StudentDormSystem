package com.hp.bishe.controller;


import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Admin;
import com.hp.bishe.bean.Login;
import com.hp.bishe.bean.Student;
import com.hp.bishe.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/Login")
public class LoginController {

    private final Logger log= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @PostMapping("/verify")
    public JsonResult Login(
            @RequestBody Login login
    ) {
        System.out.println(login);
        if (StringUtils.isEmpty(login.getUsername())) {
            return new JsonResult(0, "用户名不能为空");
        }
        if (StringUtils.isEmpty(login.getPassword())) {
            return new JsonResult(0, "密码不能为空");
        }

        //从数据库查询用户
        Student student=loginService.StudentLogin(login.getUsername());
        log.info("学生数据:"+student);
        Admin admin=loginService.AdminLogin(login.getUsername());
        log.info("管理员:"+admin);
        /**
         * 身份验证，登录
         * 0：学生
         * 1：管理员
         */
        if (login.getType()==0){
            //学生
            if (student==null){
                return new JsonResult(0,"该用户不存在");
            }
            if (!login.getPassword().equals(student.getPassword())){
                return new JsonResult(0,"密码错误");
            }
            //将学生信息存入session中,拦截验证
            redisTemplate.opsForValue().set("user",student);
            //将学生信息存入session中,页面显示
            redisTemplate.opsForValue().set("Student",student);
            //将学生头像路径存到session中，页面显示
            if (student.getPhoto()!=null){
                redisTemplate.opsForValue().set("phone","photo/"+student.getPhoto());
            }else {
                redisTemplate.opsForValue().set("phone","photo/timg.jfif");
            }
        }
        if (login.getType()==1){
            if (admin==null){
                return new JsonResult(0,"该用户不存在");
            }
            if (!login.getPassword().equals(admin.getPassword())){
                return new JsonResult(0,"密码错误");
            }
            //将管理员信息存入session中,拦截验证
            redisTemplate.opsForValue().set("user",admin);
            //将管理员信息存入session中,页面显示
            redisTemplate.opsForValue().set("admin",admin);
            //将管理员头像路径存到session中，页面显示
            if (admin.getPhoto()!=null){
                redisTemplate.opsForValue().set("phone","photo/"+admin.getPhoto());
            }else {
                redisTemplate.opsForValue().set("phone","photo/timg.jfif");
            }
        }
        //将身份信息存入session中
        redisTemplate.opsForValue().set("Type",login.getType());
        log.info("身份是："+login.getType());

       return new JsonResult(1,"登录成功");
    }
}
