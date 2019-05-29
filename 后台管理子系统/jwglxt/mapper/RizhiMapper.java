package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiRizhi;
import com.cs1603.jwglxt.bean.houtai.HoutaiRizhiDizhi;
import org.apache.ibatis.annotations.Select;

public interface RizhiMapper {

    @Select("show binary logs")
    public HoutaiRizhiDizhi[] findAllRizhiDizhi();

    @Select("show binlog events in #{username}")
    public HoutaiRizhi[] findRizhi(String username);
}
