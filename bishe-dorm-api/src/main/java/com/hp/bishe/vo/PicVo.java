package com.hp.bishe.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PicVo implements Serializable {
    //学号
    private String sn;
    //头像信息
    MultipartFile photo;
}
