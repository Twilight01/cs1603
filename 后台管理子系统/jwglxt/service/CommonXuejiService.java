package com.cs1603.jwglxt.service;
import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.bean.houtai.HoutaiStudent;
import com.cs1603.jwglxt.bean.houtai.HoutaiTeacher;
import com.cs1603.jwglxt.mapper.CommonXuejiMapper;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class CommonXuejiService {
    @Resource
    private CommonXuejiMapper commonXuejiMapper;

    /**
     * 增加学生信息
     */
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
        try{
            commonXuejiMapper.AddStudent(sid,
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
                    sbir);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(1,"插入失败");
        }
    }

    /** 查询所有
     * @return
     */
    public Result<HoutaiStudent[]> findAll() {
        System.out.println("开始查询所有数据...");
        return ResultUtil.success(commonXuejiMapper.findAll());
    }


    /**
     * 删除
     */
    public Result DeleteStudent(String sid){
        try{
            commonXuejiMapper.DeleteStudent(sid);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(2,"删除失败");
        }
    }
    public Result DeleteTeacher(String tid){
        try{
            commonXuejiMapper.DeleteTeacher(tid);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(2,"删除失败");
        }
    }

    /**
     * 修改
     */
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

                System.out.print(sid+sname);
            try{
                commonXuejiMapper.UpdateStudent(sid,
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
                        );
                return ResultUtil.success();
            }catch (Exception e){
                e.printStackTrace();
                return ResultUtil.error(3,"更新失败");
            }
    }
/**
 * 修改老师
 */
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
        System.out.println(tid+tname+tcollege+post+tnat+tres+tmail+tpol+ttel+tin);
        try{
            commonXuejiMapper.UpdateTeacher(tid,
                    tname,
                    tcollege,
                    post,
                    tnat,
                    tres,
                    tmail,
                    tpol,
                    ttel,
                    tin) ;
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(3,"更新失败");
        }
    }


    /**
     * 修改学生个人资料
     */
    public Result UpdateStudentGeren(String sid,String smail,String stel){
        try{
            commonXuejiMapper.UpdateStudentGeren(sid,smail,stel);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(4,"修改个人信息失败");
        }
    }

    /**
     * 修改老师个人资料
     */
    public Result UpdateTeacherGeren(String tid,String tmail,String ttel){
        try{
            commonXuejiMapper.UpdateTeacherGeren(tid,tmail,ttel);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(4,"修改个人信息失败");
        }
    }

    /**
     * 初始化老师页面
     */
    public HoutaiTeacher[] UpdateTeacherGerenChushi(String tid){
        try{
            return commonXuejiMapper.UpdateTeacherGerenChushi(tid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param sid
     * @return
     */
    public HoutaiStudent[] UpdateStudentGerenChushi(String sid){
        try{
            return commonXuejiMapper.UpdateStudentGerenChushi(sid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 增加老师资料
     */
    public Result AddTeacher(String tid,
                             String tname,
                             String tcollege,
                             String post,
                             String tnat,
                             String tres,
                             String tmail,
                             String tpol,
                             String ttel,
                             String tin){
        try{
            commonXuejiMapper.AddTeacher(tid,
                    tname,
                    tcollege,
                    post,
                    tnat,
                    tres,
                    tmail,
                    tpol,
                    ttel,
                    tin);
            return ResultUtil.success();
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.error(7,"插入老师信息失败");
        }
    }
    /**
     * 查询老师
     */
    public HoutaiTeacher[] findAllTeacher(){
        try{
              return commonXuejiMapper.findAllTeacher();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public HoutaiTeacher[] findTeacher(String tid){
        try{
            System.out.println(tid);
            return commonXuejiMapper.findTeacher("%"+tid+"%");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public HoutaiStudent[] findStudent(String tid){
        try{
            System.out.println(tid);
            return commonXuejiMapper.findStudent("%"+tid+"%");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public HoutaiStudent findStudent1(String tid){
        try{
            System.out.println(tid);
            return commonXuejiMapper.findStudent1(tid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public HoutaiTeacher findTeacher1(String tid){
        try{
            System.out.println(tid);
            return commonXuejiMapper.findTeacher1(tid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Result DeleteTeachers(String[] tid) {


        try{
            for (String s:tid
        ) {
            commonXuejiMapper.DeleteTeacher(s);
        }

            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(2,"删除失败");
        }
    }
    public Result DeleteStudents(String[] tid) {


        try{
            for (String s:tid
            ) {
                commonXuejiMapper.DeleteStudent(s);
            }

            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(2,"删除失败");
        }
    }



}
