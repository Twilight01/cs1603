package com.cs1603.jwglxt.controller.chengji.teacher;

import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.service.chengji.teacher.TeachercoursesService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
//@ComponentScan({"com.cs1603.jwglxt.service"})
//@MapperScan("com.cs1603.jwglxt.mapper")
public class TeachercoursesController {
    @Resource
    private TeachercoursesService teachercoursesService;

    /**
     * 该函数查询老师某个学年学期的所教课程
     * @author 孟章希
     * @param tid 老师工号
     * @param year 学年
     * @param semester 学期
     * @return Result 包含结果、结果状态码及相关信息
     */
    @RequestMapping("/api/teacher/chengji/selectCourses")
    public Result findBy(String tid, String year, Integer semester) {
        return teachercoursesService.findBy(tid, year, semester);
    }
}
