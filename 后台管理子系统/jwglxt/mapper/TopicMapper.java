package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiTopic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TopicMapper {
    @Insert("INSERT INTO topic(idTopic,nameTopic,aimedMajor,introduction,max_Limit,remain,location,date,type) VALUES(#{idTopic},#{nameTopic},#{aimedMajor},#{introduction},#{max_Limit},#{remain},#{location},#{date},#{type})")
    public Integer insert(HoutaiTopic user);

    @Select("SELECT * FROM topic WHERE id=#{username}")
    public HoutaiTopic findByUsername(String username);
}
