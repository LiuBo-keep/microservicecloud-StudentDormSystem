package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Login;
import com.hp.bishe.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class LoginController {

    private static final String REST_URL_PREFIX_Login="http://MICROSERVICECLOUD-LOGIN";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private SessionUtil sessionUtil;
    @Autowired
    private Timer timer;

    @RequestMapping (value = "/login")
    public JsonResult get(
            Login login,
            HttpServletRequest request
                          ){
        System.out.println(login);
//        sessionUtil.setSession(redisTemplate,request.getSession());
        return restTemplate.postForObject(REST_URL_PREFIX_Login+"/Login/verify",login,JsonResult.class);
    }

    @GetMapping("/sion")
    public JsonResult setSession(HttpServletRequest request){
        sessionUtil.setSession(redisTemplate,request.getSession());
        return new JsonResult(1,"转换成功");
    }

    @GetMapping("timers")
    public void timera(HttpSession session){

        System.out.println("定时任务开始");

        timer.schedule(new TimerTask() {
            int sum=1;
            @Override
            public void run() {
                session.setAttribute("user",redisTemplate.opsForValue().get("user"));
                session.setAttribute("phone",redisTemplate.opsForValue().get("phone"));
                session.setAttribute("Student",redisTemplate.opsForValue().get("Student"));
                session.setAttribute("Type",redisTemplate.opsForValue().get("Type"));
                System.out.println("调用次数为"+(sum++)+"次");
            }
        },3000,1000);
    }
}
