package com.hp.bishe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {

    private final Logger log= LoggerFactory.getLogger(DateConverter.class);
    @Override
    public Date convert(String s) {
        Date date=null;
        log.info("转换前："+s);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-M-d");
        try {
            date=simpleDateFormat.parse(s);
        } catch (ParseException e) {
            log.error("日期转换失败"+e);
        }
        log.info("转换后："+date);
        return date;
    }
}
