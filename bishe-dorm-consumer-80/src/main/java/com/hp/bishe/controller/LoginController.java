package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Login;
import com.hp.bishe.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    private static final String REST_URL_PREFIX_Login="http://MICROSERVICECLOUD-LOGIN";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private SessionUtil sessionUtil;

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
}
