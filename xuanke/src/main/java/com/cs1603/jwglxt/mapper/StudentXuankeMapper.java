package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.xuanke.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.SelectProvider;

public interface StudentXuankeMapper{

    /**
     * @author guochong
     * @param sid
     * @return 根据学生学号查询到的学生表里的全部信息
     */
    @Select("SELECT * FROM student WHERE sid=#{sid}")
    public Student getStudentInformation(String sid);

    /**
     * @author guochong
     * @param collegeName
     * @return String[] 通过学院名称查询到的所有专业名称
     */
    @Select("SELECT majorName FROM collegemajor WHERE collegeName=#{collegeName}")
    public String[] getMajorNameByCollegeName(String collegeName);

    /**
     * @author guochong
     * @param cname
     * @return  cnum（课程号）,cname（课程名）,ctype（课程类型）,tname（教师姓名）,
     *          cmajor（面向专业）,credit（课程学分）,classname（教室名）,call(int)（课程容量）,
     *          cnow(int)（已选量）,cstart（开始周）,cend（结束周）,id(int),time1（上课时间1）,
     *          time2（上课时间2）
     *          根据课程名模糊的查询课程
     */
    @Select("SELECT cnum,cname,ctype,tname,cmajor,credit,classname,`call`,cnow,cstart,cend,course.id,course.time1,course.time2" +
            " FROM course,classroom,teacher " +
            "WHERE cname like concat(concat('%',#{cname}),'%') " +
            "AND course.tid = teacher.tid AND classroom.classid = course.classid")
    public Coursehistory[] chakeByCname(String cname);


    /**
     * @author guochong
     * @param collegeName
     * @param majorName
     * @param grade
     * @param ctype
     * @param credit
     * @param flag
     * @return Coursehistory[] 根据所传参数返回满足条件的课程
     */
    @SelectProvider(type = com.cs1603.jwglxt.bean.xuanke.Dongtaisql.class,method = "chakesql")
    public Coursehistory[] chake(String collegeName, String majorName,String grade, String ctype, String credit, String flag,String[] zy);

    /**
     *@author guochong
     * @return String[] 所有学院名称
     */
    @Select("SELECT DISTINCT collegeName FROM `collegemajor`")
    public String[] getCollegeName();

    /**
     * scj
     */
    /**
     *
     * @author scj
     * @param
     * @return sid,sname,ssta,ssex,sclass,major,scollege,snat,sres,smail,spol,stel,sin,sout,sbir
     */
    @Select("select * from course where id = #{id}")
    public Course getCourses(Integer id);

    @Select("select * from coursehistory where id = #{id}")//查询历史课程信息
    public Course gethisCourses(Integer id);


    //@Select("select * from course where id = #{id}")
    //public Student xuanKe(int id,String sid,String year,String semester);

    @Select("select * from studentcourse where id = #{id} and sid = #{sid}")
public Studentcourse penchoose(Integer id,String sid);

    @Select("select * from studentcourse where id = #{id} and sid = #{sid}")
    public Studentcourse xuanKe(Integer id,String sid,String year,Integer semester);

    @Insert("insert into studentcourse values(#{id},#{semester},#{year},#{sid},'0','0','0','0','0','0','0','0')")
    public int xuanKego(Integer id,String sid,String year,Integer semester);

    @Update("update course set cnow = #{cnow} where id = #{id}")
    public  int updatecourse(Integer id,String cnow);

    @Delete("delete from studentcourse where id = #{id} and sid = #{sid}")
    public Integer tuiKe(Integer id,String sid);

    @Delete("delete from studentcourse where id = #{id} and sid = #{sid}")
    public Integer tuiKego(Integer id,String sid);

    @Update("update course set cnow = #{cnow} where id = #{id}")
    public  int updatecourse2(Integer id,String cnow);

    @Select("select * from studentcourse where sid = #{sid} and year = #{year} and semester = #{semester}")//??????????????????
    public  Studentcourse[] getallcourse(String sid,String year,Integer semester);//查询学生在指定时间段内选择的所有课程

    @Select("select * from course where id = #{id}")
    public Course findcourse(Integer id);

    @Select("select * from teacher where tid = #{tid}")
    public Teacher findteacher(String tid);

    @Select("select * from studentcourse where sid = #{sid} and year = #{year} and semester = #{semester}")
    Studentcourse[] checked(String sid,String year,Integer semester);

    @Select("select * from classroom where classid = #{classid}")
    public Classroom getclasses(Integer classid);
}
