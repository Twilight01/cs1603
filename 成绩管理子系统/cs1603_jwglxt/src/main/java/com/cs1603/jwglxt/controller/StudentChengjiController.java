package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.bean.chengji.student.chengji_Studentcourse;
import com.cs1603.jwglxt.service.StudentChengjiService;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class StudentChengjiController {
    @Resource
    private StudentChengjiService studentChengjiService;

    /**
     * 学生根据学号、学年、学期查询自己的成绩
     * @param sid
     * @param year
     * @param semester
     * @return studentcourse数组
     */
    @RequestMapping("api/student/chengji/selectGrades")
    public Result<chengji_Studentcourse[]> findById(String sid, String year, Integer semester){
        return ResultUtil.success(studentChengjiService.findById(sid, year, semester));
    }
}
