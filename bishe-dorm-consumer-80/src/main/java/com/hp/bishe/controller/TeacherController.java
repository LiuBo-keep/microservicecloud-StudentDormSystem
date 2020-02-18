package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Dorm;
import com.hp.bishe.bean.Student;
import com.hp.bishe.vo.DormVo;
import com.hp.bishe.vo.StudentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final Logger log= LoggerFactory.getLogger(TeacherController.class);

    private static final String REST_URL_PREFIX_Teacher="http://MICROSERVICECLOUD-TEACHER";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 学生管理
     * @param studentInfo
     * @param qita
     * @param qitanei
     * @return
     */
    @RequestMapping("/xueShengGuanLi")
    public JsonResult getAll(
            StudentInfo studentInfo,
            @RequestParam(value = "qita",required = false) String qita,
            @RequestParam(value = "qitanei" ,required = false) String qitanei
    ){
        if ("姓名".equals(qita)){
            studentInfo.setUsername(qitanei);
        }
        if ("学号".equals(qita)){
            studentInfo.setSn(qitanei);
        }
        if ("班级".equals(qita)){
            studentInfo.setClazz(qitanei);
        }
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/xueShengGuanLi",studentInfo,JsonResult.class);
    }

    /**
     * 宿舍管理
     */
    //查询所有宿舍
    @RequestMapping("/dorm")
    public JsonResult getAll(
            DormVo dormVo,
            @RequestParam(value = "dorm",required = false) String dorm,
            @RequestParam(value = "dorms",required = false) String dorms
    ){
        if ("寝室".equals(dorm)){
            dormVo.setDormId(dorms);
        }
        if ("舍长".equals(dorm)){
            dormVo.setDormMonitor(dorms);
        }

        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/dorm",dormVo,JsonResult.class);
    }

    //添加宿舍
    @RequestMapping("/addDorm")
    public JsonResult add(Dorm dorm){
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/addDorm",dorm,JsonResult.class);
    }

    /**
     * 学生寝室调换
     */
    //根据学号查询学生
    @RequestMapping("/get/{xuehao}")
    public JsonResult getBySn(
            @PathVariable("xuehao") String xuehao,
            HttpSession session
    ){
        log.info("调换寝室学生学号："+xuehao);
        session.setAttribute("xuehao",xuehao);
        return restTemplate.getForObject(REST_URL_PREFIX_Teacher+"/teacher/get/"+xuehao,JsonResult.class);
    }

    //调换寝室
    @RequestMapping("/tiao")
    public JsonResult upSuShe(
            @RequestParam("newsushe") String newsushe,
            @RequestParam("newbed") String newbed,
            HttpSession session
    ){
        Student student=new Student();
        student.setSn((String)session.getAttribute("xuehao"));
        student.setSushe(newsushe);
        student.setBed(newbed);
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/tiao",student,JsonResult.class);
    }
}
