package com.hp.bishe.service;

import com.hp.bishe.Utils.JsonResult;
import com.hp.bishe.config.FeignMultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "MICROSERVICECLOUD-TEACHER",configuration = FeignMultipartSupportConfig.class)
public interface Teacher_PicService {
    @RequestMapping(value = "/teacher/pic",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public JsonResult upPic(
            @RequestParam("username") String username,
            @RequestPart("photo") MultipartFile photo
    );
}
