package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.houtai.HoutaiOnline_inf;
import com.cs1603.jwglxt.bean.houtai.HoutaiVisit_inf;
import com.cs1603.jwglxt.mapper.VisitMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VisitService {
    @Resource
    private VisitMapper visitMapper;
    public HoutaiOnline_inf[] findAllOnlineInf(){
        return visitMapper.findAllOnlineInf();
    }
    public HoutaiVisit_inf[] findAllVisitInf(){
        return visitMapper.findAllVisitInf();
    }
    public Integer totalVisitNum(){
        return visitMapper.totalVisitNum();
    }
    public Integer currentVisitNum(){
        return visitMapper.currentVisitNum();
    }
}
