package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.xuanke.*;
import org.apache.ibatis.annotations.Select;

public interface TeacherXuankeMapper {
    /**
     * @author guochong
     * @param sid
     * @return teacher表内所有信息（参数名同数据库属性名）
     */
    @Select("SELECT * FROM teacher WHERE tid=#{tid}")
    public Teacher getTeatherInformation(String sid);
}
