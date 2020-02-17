package com.hp.bishe.controller;


import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.YiJian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class YiJianController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    @PostMapping("/jianyi")
    public JsonResult add(
            @RequestBody YiJian yiJian
    ){
        System.out.println(yiJian);
        String key="联系方式:"+yiJian.getSelect2()+"联系内容:"+yiJian.getLianxi();
        redisTemplate.opsForValue().set(key,yiJian);
        return new JsonResult(1,"反馈成功");
    }
}
