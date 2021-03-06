package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Student;
import com.hp.bishe.bean.WeiXiu;
import com.hp.bishe.service.WeiXiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class WeiXiuController {

    @Autowired
    private WeiXiuService weiXiuService;

    @PostMapping("/shangbao")
    public JsonResult add(@RequestBody WeiXiu weiXiu){

        int count=weiXiuService.shang(weiXiu);

        if (count==0){
            return new JsonResult(0,"上报失败");
        }else {
            return new JsonResult(1,"上报成功");
        }
    }

    @PostMapping("/chaxun")
    private JsonResult get(
            @RequestBody Student student
    ){
//        List<WeiXiu> list=weiXiuService.get(student.getSn());
        List<WeiXiu> list=weiXiuService.get("1850510408");
        for (WeiXiu w:list
             ) {
            System.out.println(w);
        }
        return new JsonResult(1,list);
    }
}
