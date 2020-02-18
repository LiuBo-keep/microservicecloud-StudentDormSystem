package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.service.AlterService;
import com.hp.bishe.vo.PasswordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class AlterController {

    @Autowired
    private AlterService alterService;

    @PostMapping("/password")
    public JsonResult upPassword(
            @RequestBody PasswordVo passwordVo
    ){
        int num=alterService.upPassword(passwordVo);
        if (0==num){
            return new JsonResult(0,"旧密码有误，请重新输入！");
        }else {
            return new JsonResult(1,"修改成功,即将跳转登录页，请重新登录！");
        }
    }
}
