package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.houtai.HoutaiRizhi;
import com.cs1603.jwglxt.bean.houtai.HoutaiRizhiDizhi;
import com.cs1603.jwglxt.mapper.RizhiMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RizhiService {
    @Resource
    private RizhiMapper rizhiMapper;


    public HoutaiRizhiDizhi[] findallRizhiDizhi(){
        HoutaiRizhiDizhi[] ri=rizhiMapper.findAllRizhiDizhi();
        System.out.println(ri[0].toString());
        return ri;
    }

    public HoutaiRizhi[] findallRizhi(String s){
        return rizhiMapper.findRizhi(s);
    }
}
