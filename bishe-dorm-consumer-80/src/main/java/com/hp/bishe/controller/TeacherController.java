package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.*;
import com.hp.bishe.service.Teacher_PicService;
import com.hp.bishe.vo.DormVo;
import com.hp.bishe.vo.PasswordVo;
import com.hp.bishe.vo.StudentInfo;
import com.hp.bishe.vo.WeiXiuVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final Logger log= LoggerFactory.getLogger(TeacherController.class);

    private static final String REST_URL_PREFIX_Teacher="http://MICROSERVICECLOUD-TEACHER";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Teacher_PicService service;

    /**
     * 管理员修改
     */
    //修改密码
    @PostMapping("/password")
    public JsonResult upPassword(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword1") String newPassword1,
            @RequestParam("newPassword2") String newPassword2,
            HttpSession session
    ){
        if (oldPassword.trim()==""||oldPassword.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword1.trim()==""||newPassword1.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (newPassword2.trim()==""||newPassword2.trim()==null){
            return new JsonResult(0,"密码不能为空");
        }
        if (!newPassword1.equals(newPassword2)){
            return new JsonResult(0,"新密码两次输入不一致,请重新输入！");
        }
//        Admin admin=(Admin) session.getAttribute("user");
        PasswordVo passwordVo=new PasswordVo();
        passwordVo.setUsername("admin");
        passwordVo.setOldPassword(oldPassword);
        passwordVo.setNewPassword1(newPassword1);
        passwordVo.setNewPassword2(newPassword2);
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/password",passwordVo,JsonResult.class);
    }

    //修改图片
    @RequestMapping("/pic")
    public JsonResult upPic(
            @RequestPart("photo") MultipartFile photo
    ){
        return service.upPic("admin",photo);
    }

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


    /**
     * 维修报修
     */

    //查询所有记录
    @RequestMapping("/list")
    public JsonResult ListWeiXiu(
            WeiXiuVo weiXiuVo
    ){
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/list",weiXiuVo,JsonResult.class);
    }

    //回显
    @RequestMapping("/getsn")
    public JsonResult getBySn(
            @RequestParam("sn") String sn,
            @RequestParam("date") long data

    ){
        System.out.println(sn+"---"+data);
        Date date=new Date();
        date.setTime(data);
        System.out.println(date);
        WeiXiu weiXiu=new WeiXiu();
        weiXiu.setSn(sn);
        weiXiu.setCreate_time(date);
       return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/getsn",weiXiu,JsonResult.class);
    }
    //报修
    @RequestMapping("/update")
    public JsonResult updateWeixiu(
            WeiXiu weiXiu
    ){
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/update",weiXiu,JsonResult.class);
    }
    /**
     * 学生迁出登记
     */
    //学生迁出
    @RequestMapping("/tu")
    public JsonResult upStudent(
            @RequestParam("qianremark") String qianremark,
            HttpSession session
    ){
        Student student=new Student();
        student.setQianRemark(qianremark);
        student.setSn((String)session.getAttribute("xuehao"));
        log.info("学生迁出");
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/tu",student,JsonResult.class);
    }

    /**
     * 查询所有迁出记录
     */
    @RequestMapping("/AllQianChu")
    public JsonResult getAll(
            StudentInfo studentInfo
    ){
        log.info("查询所有迁出记录");
        studentInfo.setStatus("迁出");
        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/AllQianChu",studentInfo,JsonResult.class);
    }

    /**
     * 缺勤记录
     */
    @RequestMapping("/queqin")
    public JsonResult queqin(
            @RequestParam("xuehao") String xuehao,
            @RequestParam("date") Date date,
            @RequestParam("remake") String remake
    ){
        if (StringUtils.isEmpty(xuehao)){
            return new JsonResult(0,"缺勤学生，学号不能为空！");
        }
        if (StringUtils.isEmpty(date)){
            return new JsonResult(0,"缺勤日期不能为空！");
        }
        if (StringUtils.isEmpty(date)){
            return new JsonResult(0,"缺勤原因不能为空！");
        }

        log.info("缺勤信息为->"+"学号："+xuehao+"日期："+date+"备注："+remake);

        QueQin queQin=new QueQin();
        queQin.setSn(xuehao);
        queQin.setData(date);
        queQin.setRemake(remake);

        return restTemplate.postForObject(REST_URL_PREFIX_Teacher+"/teacher/queqin",queQin,JsonResult.class);
    }
}
