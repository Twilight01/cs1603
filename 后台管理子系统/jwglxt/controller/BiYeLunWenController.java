package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.service.BiYeLunWenService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//前后端交互跨域解决
@CrossOrigin
public class BiYeLunWenController {
    @Resource
    private BiYeLunWenService biYeLunWenService;
    @RequestMapping("api/student/houtai/ChaXunJinRuLunWen")
    public Result ChaXunJinRuLunWen(String str,String sid){
        return biYeLunWenService.ChaXunJinRuLunWen(str,sid);
    }
}
