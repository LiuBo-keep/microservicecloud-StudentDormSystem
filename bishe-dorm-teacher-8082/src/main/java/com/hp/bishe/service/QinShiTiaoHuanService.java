package com.hp.bishe.service;

import com.hp.bishe.bean.Student;

public interface QinShiTiaoHuanService {

    public Student findBysn(String sn);

    public int upsushe(Student student);
}
