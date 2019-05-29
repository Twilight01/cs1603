package com.cs1603.jwglxt.controller;
import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.bean.houtai.HoutaiStudent;
import com.cs1603.jwglxt.bean.houtai.HoutaiTeacher;
import com.cs1603.jwglxt.service.CommonXuejiService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@CrossOrigin
public class CommonXuejiController {
    @Resource
    /**
     * 增加学籍资料
     */
    private CommonXuejiService commonXuejiService;
    @RequestMapping("/api/student/houtai/Addstudent")
    public Result AddStudent(String sid,
            String sname,
            String ssta,
            String ssex,
            String sclass,
            String major,
            String scollege,
            String snat,
            String sres,
            String smail,
            String spol,
            String stel,
            String sin,
            String sout,
            String sbir) {
        return commonXuejiService.AddStudent(sid,
                sname,
                ssta,
                ssex,
                sclass,
                major,
                scollege,
                snat,
                sres,
                smail,
                spol,
                stel,
                sin,
                sout,
                sbir) ;
    }
    /**
     * 查询全部学生学籍资料
     * @return
     */
    @RequestMapping("/api/student/houtai/ShowStudent")
    public Result<HoutaiStudent[]> findAll() {
        return commonXuejiService.findAll();
    }
    /**
     * 删除某一学生资料
     */
//    @RequestMapping("/api/student/houtai/ShowStudent")
//    public Result DeleteStudent(String sid) {
//        return commonXuejiService.DeleteStudent(sid);
//    }

    /**
     *更新学生资料
     */
    @RequestMapping("/api/student/houtai/UpdateStudent")
    public Result UpdateStudent(String sid,
                                String sname,
                                String ssta,
                                String ssex,
                                String sclass,
                                String major,
                                String scollege,
                                String snat,
                                String sres,
                                String smail,
                                String spol,
                                String stel,
                                String sin,
                                String sout
                                ) {
        if(smail==null){
            smail="";
        }
        if(stel==null){
            stel="";
        }
        return commonXuejiService.UpdateStudent(sid,
                sname,
                ssta,
                ssex,
                sclass,
                major,
                scollege,
                snat,
                sres,
                smail,
                spol,
                stel,
                sin,
                sout
                ) ;
    }
    /**
     * 更新老师资料
     */
    @RequestMapping("/api/teacher/houtai/UpdateTeacher")
    public Result UpdateTeacher(String tid,
                                String tname,
                                String tcollege,
                                String post,
                                String tnat,
                                String tres,
                                String tmail,
                                String tpol,
                                String ttel,
                                String tin) {
        return commonXuejiService.UpdateTeacher(tid,
                tname,
                tcollege,
                post,
                tnat,
                tres,
                tmail,
                tpol,
                ttel,
                tin);
    }

    /**
     * 更新学生个人资料
     */
    @RequestMapping("/api/student/houtai/UpdateStudentGeren")
    public Result UpdateStudentGeren(String sid,String smail,String stel){

        return commonXuejiService.UpdateStudentGeren(sid,smail,stel);
    }
    /**
     * 更新老师个人资料
     */
    @RequestMapping("/api/teacher/houtai/UpdateTeacherGeren")
    public Result UpdateTeacherGeren(String tid,String tmail,String ttel){
        System.out.println(tid+tmail+ttel);
        return commonXuejiService.UpdateTeacherGeren(tid,tmail,ttel);
    }

    /**
     * 传参数进行初始化页面
     */
    @RequestMapping("/api/teacher/houtai/UpdateTeacherGerenChushi")
    public HoutaiTeacher[] UpdateTeacherGerenChushi(String tid){
        System.out.println(tid);
        return commonXuejiService.UpdateTeacherGerenChushi(tid);
    }

    /**
     * 传参数进行学生初始化页面
     */
    @RequestMapping("/api/student/houtai/UpdateStudentGerenChushi")
    public HoutaiStudent[] UpdateStudentGerenChushi(String sid){
        System.out.println(sid);
        return commonXuejiService.UpdateStudentGerenChushi(sid);
    }
    /**
     * 增加老师资料
     */

    @RequestMapping("/api/teacher/houtai/AddTeacher")
    public Result AddTeacher(String tid,
                                String tname,
                                String tcollege,
                                String post,
                                String tnat,
                                String tres,
                                String tmail,
                                String tpol,
                                String ttel,
                                String tin) {
        return commonXuejiService.AddTeacher(tid,
                tname,
                tcollege,
                post,
                tnat,
                tres,
                tmail,
                tpol,
                ttel,
                tin);
    }
    /**
     * 查询老师资料
     */
    @RequestMapping("/api/teacher/houtai/ShowTeacher")
    public HoutaiTeacher[] findAllTeacher() {
        return commonXuejiService.findAllTeacher();
    }

    @RequestMapping("/api/teacher/houtai/FindTeacher")
    public HoutaiTeacher[] findTeacher(String tid) {
        return commonXuejiService.findTeacher(tid);
    }
    @RequestMapping("/api/teacher/houtai/FindTeacher1")
    public HoutaiTeacher findTeacher1(String tid) {
        return commonXuejiService.findTeacher1(tid);
    }
    @RequestMapping("/api/teacher/houtai/FindStudent")
    public HoutaiStudent[] findStudent(String tid) {
        return commonXuejiService.findStudent(tid);
    }
    @RequestMapping("/api/teacher/houtai/FindStudent1")
    public HoutaiStudent findStudent1(String tid) {
        return commonXuejiService.findStudent1(tid);
    }
    @RequestMapping("/api/teacher/houtai/DeleteTeacher")
    public Result DeleteTeacher(String tid) {
        return commonXuejiService.DeleteTeacher(tid);
    }
    @RequestMapping("/api/teacher/houtai/DeleteStudent")
    public Result DeleteStudent(String tid) {
        return commonXuejiService.DeleteStudent(tid);
    }
    @RequestMapping("/api/teacher/houtai/DeleteTeachers")
    public Result DeleteTeachers(String[] tid) {
        for (String s:tid
             ) {
            System.out.println(s);
        }
        return commonXuejiService.DeleteTeachers(tid);
    }
    @RequestMapping("/api/teacher/houtai/DeleteStudents")
    public Result DeleteStudents(String[] tid) {
        for (String s:tid
        ) {
            System.out.println(s);
        }
        return commonXuejiService.DeleteStudents(tid);
    }
}
