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

@FeignClient(value = "MICROSERVICECLOUD-STUDENT",configuration = FeignMultipartSupportConfig.class)
public interface Student_PicService {

    @RequestMapping(value = "/student/pic",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public JsonResult upPic(
            @RequestParam("sn") String sn,
            @RequestPart("photo") MultipartFile photo
            );
}
