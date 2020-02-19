package com.hp.bishe.controller;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.service.AlterService;
import com.hp.bishe.vo.PasswordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/teacher")
public class AlterController {

    @Autowired
    private AlterService alterService;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

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

    /**
     * 管理员修改头像
     */
    @PostMapping("/pic")
    public JsonResult upPic(
            @RequestParam("username") String username,
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

                    //将图片名称存到数据库
                    int count=alterService.upPic(newName,username);
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
