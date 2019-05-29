package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.bean.houtai.HoutaiStudent;
import com.cs1603.jwglxt.mapper.BiYeLunWenMapper;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BiYeLunWenService {
    @Resource
    private BiYeLunWenMapper biYeLunWenMapper;
    private  SystemService systemService;
    public Result ChaXunJinRuLunWen(String str, String sid){
        HoutaiStudent stu=biYeLunWenMapper.find(sid);
        if(stu==null)return ResultUtil.error(110,"无此学生");
        String s=str.substring(str.length()-2);
        String s1=stu.getSclass().substring(2,4);
        int i=Integer.parseInt(s);
        int i1=Integer.parseInt(s1);
        if(i1-i==4&&systemService.IsOpen(3)){
            return ResultUtil.success();
        }
        return ResultUtil.error(120,"你不是学生");

    }
}
