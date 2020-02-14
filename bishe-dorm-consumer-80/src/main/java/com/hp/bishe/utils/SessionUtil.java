package com.hp.bishe.utils;

import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public void setSession(RedisTemplate<Object,Object> redisTemplate, HttpSession session){
        session.setAttribute("user",redisTemplate.opsForValue().get("user"));
        session.setAttribute("phone",redisTemplate.opsForValue().get("phone"));
        session.setAttribute("Student",redisTemplate.opsForValue().get("Student"));
        session.setAttribute("Type",redisTemplate.opsForValue().get("Type"));
    }
}
