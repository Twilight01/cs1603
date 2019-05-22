package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.xuanke.*;
import com.cs1603.jwglxt.service.*;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.System;

// 自动将返回的东西转换为json格式 供前后端交互
@RestController
//前后端交互跨域解决
@CrossOrigin

public class StudentXuankeController {
    @Resource
    private StudentXuankeService studentXuankeService;

    /**
     * @author guochong
     * @param sid
     * @return 根据学生学号查询到的学生表里的全部信息
     */
    @RequestMapping("/api/student/xuanke/getStudentInformation")
    public Result<Student> getStudentInformation(String sid)
    {
        return studentXuankeService.getStudentInformation(sid);
    }

    @RequestMapping("/api/student/xuanke/chake")
    public Result<Coursehistory[]> chake(String collegeName, String majorName,String grade, String ctype, String credit, String flag)
    {
        Result<String[]> zy = studentXuankeService.getMajorNameByCollegeName(collegeName);
        return studentXuankeService.chake(collegeName, majorName, grade, ctype, credit, flag,zy);
    }

    /**
     * @author guochong
     * @param collegeName
     * @return String 通过学院名称查询到的所有专业名称
     */
    @RequestMapping("/api/student/xuanke/getMajorNameByCollegeName")
    public Result<String[]> getMajorNameByCollegeName(String collegeName)
    {
        return studentXuankeService.getMajorNameByCollegeName(collegeName);
    }

    /**
     *
     * @param cname
     * @return Coursehistory[] 课程名为cname的课程
     */
    @RequestMapping("/api/student/xuanke/chakeByCname")
    public Result<Coursehistory[]> chakeByCname(String cname)
    {
        return studentXuankeService.chakeByCname(cname);
    }

    /**
     *@author guochong
     * @return String[] 所有学院名称
     */
    @RequestMapping("/api/student/xuanke/getCollegeName")
    public Result<String[]> getCollegeName(){ return studentXuankeService.getCollegeName(); }

    /**
     * 一下内容scj
     */
    @RequestMapping("/api/student/xuanke/xuanKe")
    public Result<Studentcourse> xuanKe(Integer id,String sid,String year,Integer semester){

        return studentXuankeService.xuanKe(id,sid,year,semester);
        //return studentXuankeService.xuanKe(1346,"2016014337","one",1);
    }

    public Course getCourses(Integer id){//获取一门课程的信息
        return studentXuankeService.getCourses(id);
    }

    public Studentcourse penchoose(Integer id,String sid){
        return studentXuankeService.penchoose(id,sid);
    }

    public int updatecourse(Integer id,String cnow){//选课过程中更新全校课表+1
        return studentXuankeService.updatecourse(id,cnow);
        //return 1;
    }

    public int xuanKego(Integer id,String sid,String year,Integer semester){//执行选课操作，插入
        return studentXuankeService.xuanKego(id,sid,year,semester);
    }


    @RequestMapping("/api/student/xuanke/tuiKe")
    public Result<Integer> tuiKe(Integer id,String sid){
        return studentXuankeService.tuiKe(id,sid);
        //return studentXuankeService.tuiKe(1349,"20160143379");
    }

    public int tuiKego(Integer id,String sid){
        return studentXuankeService.tuiKego(id,sid);
    }

    public int updatecourse2(Integer id,String cnow){
        return studentXuankeService.updatecourse2(id,cnow);
    }

    //public Coursetable gettable(String sid,String year,Integer semester){//生成课程表
    //  return studentXuankeService.gettable(sid,year,semester);
    //}

    public Studentcourse[] getallcourse(String sid,String year,Integer semester){//查询学生在指定学年学期的所有课程
        return studentXuankeService.getallcourse(sid,year,semester);
    }

    public Course findcourse(Integer id) {//根据课程id 查找课程相关信息
        return studentXuankeService.findcourse(id);
    }

    public Teacher findteacher(String tid){
        return studentXuankeService.findteacher(tid);
    }

    public Coursetable getatable(String sid,String year,Integer semester){
        return studentXuankeService.getatable(sid,year,semester);
    }

    @RequestMapping("/api/student/xuanke/courseTable")
    public Result<Coursetable> gettable(String sid,String year,Integer semester){
        return studentXuankeService.gettable(sid,year,semester);
        //return studentXuankeService.gettable("2016014337","one",1);
    }

    /**
     *
     * @param sid
     * @param year
     * @param semester
     * @return Studentcourse[] 学生选课表类型数组，获取一组数据
     */
    @RequestMapping("/api/student/xuanke/zhangyuting")
    public Result<Course[]> checked(String sid,String year,Integer semester){
        return studentXuankeService.checked(sid,year,semester);
        //return studentXuankeService.checked("2016014337","one",1);
    }


    public Classroom getclasses(Integer classid){
        return studentXuankeService.getclasses(classid);
    }






}
