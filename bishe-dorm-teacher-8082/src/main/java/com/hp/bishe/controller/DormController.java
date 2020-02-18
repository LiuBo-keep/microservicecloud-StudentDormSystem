package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.Utils.PageObject;
import com.hp.bishe.bean.Dorm;
import com.hp.bishe.service.DormService;
import com.hp.bishe.vo.DormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class DormController {

    @Autowired
    private DormService dormService;

    //查询所以宿舍
    @PostMapping("/dorm")
    public JsonResult getAll(
            @RequestBody DormVo dormVo
    ){
        PageObject pageObject=dormService.findByData(dormVo);

        return new JsonResult(1,pageObject);
    }

    //添加宿舍
    @PostMapping("/addDorm")
    public JsonResult add(
            @RequestBody Dorm dorm){
        Dorm dorm1=dormService.findById(dorm.getDormId());
        if (dorm1!=null){
            return new JsonResult(0,"该宿舍以存在，请重新添加！");
        }
        dormService.add(dorm);
        return new JsonResult(1,"添加成功！");
    }
}
