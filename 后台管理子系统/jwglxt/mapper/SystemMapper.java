package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiSystem;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SystemMapper {
    @Select("SELECT * FROM db.system WHERE sysid=#{username}")
    public HoutaiSystem findSystem(Integer username);
    @Update("update db.system set status =#{num} where sysid=#{id}")
    public void UpdateSystem(Integer id,Integer num);
}
