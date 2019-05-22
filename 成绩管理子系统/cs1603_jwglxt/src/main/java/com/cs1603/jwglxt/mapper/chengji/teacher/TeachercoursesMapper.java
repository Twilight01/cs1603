package com.cs1603.jwglxt.mapper.chengji.teacher;

import com.cs1603.jwglxt.bean.chengji.teacher.Teachercourses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface TeachercoursesMapper {
    /**
     * 该函数根据老师工号和学年学期，查询返回了该老师在该学年学期所教的全部课程
     * @author 孟章希
     * @param tid 老师工号
     * @param year 学年
     * @param semester 学期
     * @return Teachercourses[] 课程简要信息数组
     */
    @Select("SELECT cname,cmajor,ctype,id FROM coursehistory WHERE tid=#{tid} AND year=#{year} AND semester=#{semester};")
    public Teachercourses[] findBy(String tid, String year, Integer semester);
}
