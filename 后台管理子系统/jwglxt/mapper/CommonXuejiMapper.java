package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiStudent;
import com.cs1603.jwglxt.bean.houtai.HoutaiTeacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommonXuejiMapper {
    /**
     * 增加学生信息
     */
    @Insert("insert into student(sid,sname,ssta,ssex,sclass,major,scollege,snat,sres,smail,spol,stel,sin,sout,sbir) values(#{sid},#{sname},#{ssta},#{ssex},#{sclass},#{major},#{scollege},#{snat},#{sres},#{smail},#{spol},#{stel},#{sin},#{sout},#{sbir})")
    public void
    AddStudent(String sid,String sname,String ssta,String ssex,String sclass,String major,String scollege,String snat,String sres,String smail,String spol,String stel,String sin,String sout,String sbir);
    /**
     * 查询所有学生
     */
    @Select("SELECT * FROM student")
    public HoutaiStudent[] findAll();


    /**
     * 删除学生
     */
    @Delete("delete from student where sid=#{sid}")
    public void DeleteStudent(String sid);

    @Delete("delete from teacher where tid=#{sid}")
    public void DeleteTeacher(String sid);
    /**
     * 修改学生资料
     */
    @Update("update student set sname=#{sname},ssta=#{ssta},ssex=#{ssex},sclass=#{sclass},major=#{major},scollege=#{scollege},snat=#{snat},sres=#{sres},smail=#{smail},spol=#{spol},stel=#{stel},sin=#{sin},sout=#{sout} where sid=#{sid}")
    public void UpdateStudent(String sid,
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
                              ) ;

    @Update("update student set smail=#{smail},stel=#{stel} where sid=#{sid}")
    public void UpdateStudentGeren(String sid,
                              String smail,
                              String stel);

    @Update("update teacher set tmail=#{tmail},ttel=#{ttel} where tid=#{tid}")
    public void UpdateTeacherGeren(String tid,
                                   String tmail,
                                   String ttel);

    @Select("select * from teacher where tid=#{tid}")
    public  HoutaiTeacher[] UpdateTeacherGerenChushi(String tid);


    @Select("select * from student where sid=#{sid}")
    public  HoutaiStudent[] UpdateStudentGerenChushi(String sid);


    /**
     * 修改老师的资料
     */
    @Update("update teacher set tname=#{tname},tcollege=#{tcollege},post=#{post},tnat=#{tnat},tres=#{tres},tmail=#{tmail},tpol=#{tpol},ttel=#{ttel},tin=#{tin} where tid=#{tid}")
    public void UpdateTeacher(String tid,
                              String tname,
                              String tcollege,
                              String post,
                              String tnat,
                              String tres,
                              String tmail,
                              String tpol,
                              String ttel,
                              String tin);
    /**
     * 增加老师的资料
     */
    @Insert("insert into teacher(tid,tname,tcollege,post,tnat,tres,tmail,tpol,ttel,tin) values(#{tid},#{tname},#{tcollege},#{post},#{tnat},#{tres},#{tmail},#{tpol},#{ttel},#{tin})")
    public void AddTeacher(String tid,
                              String tname,
                              String tcollege,
                              String post,
                              String tnat,
                              String tres,
                              String tmail,
                              String tpol,
                              String ttel,
                              String tin);
    /**
     * 查询老师资料
     */
    @Select("select * from teacher")
    public HoutaiTeacher[] findAllTeacher();
    @Select("select * from teacher where tid like #{tid}")
    public HoutaiTeacher[] findTeacher(String tid);
    @Select("select * from teacher where tid = #{tid}")
    public HoutaiTeacher findTeacher1(String tid);
    @Select("select * from student where sid like #{tid}")
    public HoutaiStudent[] findStudent(String tid);
    @Select("select * from student where sid = #{tid}")
    public HoutaiStudent findStudent1(String tid);

}
