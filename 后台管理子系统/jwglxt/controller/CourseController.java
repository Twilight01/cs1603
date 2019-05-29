package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.houtai.HoutaiCoursesorting;
import com.cs1603.jwglxt.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.System;

@RestController
//前后端交互跨域解决
@CrossOrigin
public class CourseController {
    @Resource
    private CourseService courseService;
    @RequestMapping(value="api/common/houtai/AddCourse",method = RequestMethod.POST)
    public Integer insert(HoutaiCoursesorting cs){
        System.out.println(cs.getId());


        return courseService.insert(cs);

    }

}
