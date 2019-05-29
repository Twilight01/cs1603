package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiCoursesorting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CourseMapper {
    @Insert("INSERT INTO coursesorting VALUES(#{id},#{cnum},#{cname},#{cmajor},#{ctype},#{tid},#{call},#{cstart},#{cend},#{credit},#{ctime},#{cfre})")
    public Integer insert(HoutaiCoursesorting user);

    @Select("SELECT * FROM coursesorting WHERE id=#{username}")
    public HoutaiCoursesorting findByUsername(Integer username);

    @Select("SELECT * FROM teacher WHERE tid=#{username}")
    public HoutaiCoursesorting findTeacher(String username);
}
