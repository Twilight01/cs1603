package com.cs1603.jwglxt.controller.chengji.teacher;

import com.cs1603.jwglxt.service.chengji.teacher.StudentgradesService;
import com.cs1603.jwglxt.bean.Result;
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
public class StudentgradesController {
    @Resource
    private StudentgradesService studentgradesService;

    /**
     *
     * @param id 课程表号
     * @return Result 包含结果、结果状态码及相关信息
     */
    @RequestMapping("/api/teacher/chengji/selectGrades")
    public Result selectStudentsGrades(Integer id) {
        return studentgradesService.selectStudentsGrades(id);
    }

    /**
     * 该函数用来修改学生的三部分成绩比例
     * @author 孟章希
     * @param id 课程表号
     * @param percent1 平时成绩百分比
     * @param percent2 期中/实验成绩百分比
     * @param percent3 期末成绩百分比
     * @return Result 包含结果、结果状态码及相关信息
     */
    @RequestMapping("/api/teacher/chengji/updatePercents")
    public Result changePercents(Integer id, String percent1, String percent2, String percent3) {
        return studentgradesService.changePercents(id, percent1, percent2, percent3);
    }

    /**
     * 该函数用来修改学生的三部分成绩
     * @author 孟章希
     * @param id 课程表号
     * @param sid 学生学号
     * @param score1 平时成绩
     * @param score2 期中/实验成绩
     * @param score3 期末成绩
     * @return Result 包含结果、结果状态码及相关信息
     */
    @RequestMapping("/api/teacher/chengji/updateGrades")
    public Result changeGrades(Integer id, String ctype, String sid, String score1, String score2, String score3) {
        return studentgradesService.changeGrades(id, ctype, sid, score1,score2, score3);
    }
}
