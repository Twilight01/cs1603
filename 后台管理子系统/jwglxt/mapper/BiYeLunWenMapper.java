package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiStudent;
import org.apache.ibatis.annotations.Select;

public interface BiYeLunWenMapper {
    @Select("SELECT * FROM student where sid=#{sid} ")
    public HoutaiStudent find(String sid);
}
