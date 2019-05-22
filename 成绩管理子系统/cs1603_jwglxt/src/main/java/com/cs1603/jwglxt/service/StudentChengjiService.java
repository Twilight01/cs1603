package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.chengji.student.chengji_Studentcourse;
import com.cs1603.jwglxt.mapper.StudentChengjiMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentChengjiService {
    @Resource
    private StudentChengjiMapper studentChengjiMapper;

    public chengji_Studentcourse[] findById(String sid, String year, Integer semester){
        return studentChengjiMapper.findById(sid, year, semester);
    }
}
