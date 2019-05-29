package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiOnline_inf;
import com.cs1603.jwglxt.bean.houtai.HoutaiVisit_inf;
import org.apache.ibatis.annotations.Select;

public interface VisitMapper {
    @Select("SELECT * FROM online_inf")
    public HoutaiOnline_inf[] findAllOnlineInf();
    @Select("SELECT * FROM visit_inf")
    public HoutaiVisit_inf[] findAllVisitInf();
    @Select("SELECT count(*) FROM visit_inf")
    public Integer totalVisitNum();
    @Select("SELECT count(*) FROM online_inf")
    public Integer currentVisitNum();


}
