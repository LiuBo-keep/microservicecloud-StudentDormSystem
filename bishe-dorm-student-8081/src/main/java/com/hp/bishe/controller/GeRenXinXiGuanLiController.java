package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.bean.Student;
import com.hp.bishe.service.GenRenXinXiService;
import com.hp.bishe.vo.PasswordVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping(value = "/student")
public class GeRenXinXiGuanLiController {

    private final Logger log= LoggerFactory.getLogger(GeRenXinXiGuanLiController.class);

    @Autowired
    GenRenXinXiService genRenXinXiService;
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;


    /**
     *学生修改个人信息
     */
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

    /**
     * 学生修改密码
     */
    @PostMapping("/password")
    public JsonResult upPassword(
            @RequestBody PasswordVo passwordVo
    ){
        int num=genRenXinXiService.upPassword(passwordVo);
        if (0==num){
            return new JsonResult(0,"旧密码有误，请重新输入！");
        }else {
            return new JsonResult(1,"修改成功,即将跳转登录页，请重新登录！");
        }
    }

    /**
     * 学生修改头像
     */
    @PostMapping("/pic")
    public JsonResult upPic(
            @RequestParam("sn") String sn,
            @RequestPart("photo") MultipartFile photo
            ) throws IOException {
        if (photo!=null){
            if (photo.getSize()<10485760){
                //获取文件扩展名
                String suffix=photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".")+1,photo.getOriginalFilename().length());
                if ("jpg,png,gif,jpeg".contains(suffix.toLowerCase())){
                    //用uuid给图片重新命名
                    String uuid=UUID.randomUUID().toString().toLowerCase().replace("-","");
                    String newName=uuid.concat("."+suffix);
                    log.info("新的文件名="+newName);

//                    //将文件保存在本地磁盘
//                    File file=new File("M:\\photo\\"+newName);
//                    if (!file.exists()){
//                        file.mkdirs();//判断文件加是否存，不存在就创建
//                    }

                    //将图片名称存到数据库
                    int count=genRenXinXiService.upPic(newName,sn);
                    if (count<=0){
                        return new JsonResult(0,"上传失败");
                    }

                    //将图片存到本地文件夹
                    byte[] bytes=photo.getBytes();
                    BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("M:\\photo\\"+newName));
                    bufferedOutputStream.write(bytes);

                    String photoPath ="photo/"+newName;

                    redisTemplate.opsForValue().set("phone",photoPath);

                    return new JsonResult(1,"上传成功",photoPath);
                }else {
                    return new JsonResult(0,"您上传的文件格式不对，请上传jpg,png,gif,jpeg格式的图片");
                }
            }else {
                return new JsonResult(0,"文件大小超过14M，请上传小于10M的图片");
            }
        }else {
            return new JsonResult(0,"请选择文件");
        }
    }
}
