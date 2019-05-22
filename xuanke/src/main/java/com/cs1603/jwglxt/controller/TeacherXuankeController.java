package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.xuanke.*;
import com.cs1603.jwglxt.service.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

// 自动将返回的东西转换为json格式 供前后端交互
@RestController
//前后端交互跨域解决
@CrossOrigin

public class TeacherXuankeController {
    @Resource
    private TeacherXuankeService teacherXuankeService;

    /**
     * @author guochong
     * @param tid
     * @return teacher表内所有信息（参数名同数据库属性名）
     */
    @RequestMapping("api/teacher/xuanke/getTeacherInformation")
    public Result<Student> getStudentInformation(String tid)
    {
        return teacherXuankeService.getStudentInformation(tid);
    }
}
