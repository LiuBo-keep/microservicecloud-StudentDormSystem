package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Student;
import com.hp.bishe.service.GenRenXinXiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/student")
public class GeRenXinXiGuanLiController {

    private final Logger log= LoggerFactory.getLogger(GeRenXinXiGuanLiController.class);

    @Autowired
    GenRenXinXiService genRenXinXiService;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;


    @PostMapping("/xiugai")
    public JsonResult xiu(@RequestBody Student student){
        log.info("入参信息->"+"学号:"+student.getSn()+"姓名:"+student.getUsername()+
                "性别:"+student.getSex()+"年级:"+student.getClazzId()+"宿舍:"+
                student.getSushe()+"床号:"+student.getBed()+"备注:"+student.getRemark());
        if (StringUtils.isEmpty(student.getSn())){
            return new JsonResult(0,"学号不能为空！");
        }
        if (StringUtils.isEmpty(student.getUsername())){
            return new JsonResult(0,"姓名不能为空！");
        }
        if (StringUtils.isEmpty(student.getClazzId())){
            return new JsonResult(0,"年级不能为空！");
        }
        if (StringUtils.isEmpty(student.getSushe())){
            return new JsonResult(0,"宿舍号不能为空！");
        }
        if (StringUtils.isEmpty(student.getBed())){
            return new JsonResult(0,"床号不能为空！");
        }

        genRenXinXiService.xiu(student);

        redisTemplate.opsForValue().set("Student",student);

        return new JsonResult(1,"修改成功！");
    }
}
