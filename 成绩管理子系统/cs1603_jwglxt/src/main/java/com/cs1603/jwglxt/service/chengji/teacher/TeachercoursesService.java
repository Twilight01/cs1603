package com.cs1603.jwglxt.service.chengji.teacher;

import com.cs1603.jwglxt.mapper.chengji.teacher.TeachercoursesMapper;
import com.cs1603.jwglxt.utils.ResultUtil;
import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.bean.chengji.teacher.Teachercourses;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@ComponentScan({"com.cs1603.jwglxt.mapper"})
@Service
public class TeachercoursesService {
    @Resource
    private TeachercoursesMapper teachercoursesMapper;

    /**
     * 该函数查询老师某个学年学期的所教课程，并进行了逻辑判断
     * @author 孟章希
     * @param tid 老师工号
     * @param year 学年
     * @param semester 学期
     * @return Result 包含结果、结果状态码及相关信息
     */
    public Result findBy(String tid, String year, Integer semester) {
        Teachercourses[] teachercourses = teachercoursesMapper.findBy(tid, year, semester);
        if (teachercourses.length == 0) {
            return ResultUtil.error(101,"当前学年学期未查找到工号为"+tid+"的老师的所教课程");
        }
        else {
            return ResultUtil.success(teachercourses);
        }

    }
}
