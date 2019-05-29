package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.houtai.HoutaiRizhi;
import com.cs1603.jwglxt.bean.houtai.HoutaiRizhiDizhi;
import com.cs1603.jwglxt.service.RizhiService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//前后端交互跨域解决
@CrossOrigin
public class RizhiController {
    @Resource
    private RizhiService rizhiService;

    @RequestMapping("api/common/houtai/ShowRizhiDizhi")
    public HoutaiRizhiDizhi[] findAll(){
        System.out.println("sad");
        return rizhiService.findallRizhiDizhi();
    }
    @RequestMapping("api/common/houtai/ShowRizhi")
    public HoutaiRizhi[] find(@RequestParam(value="log_name")String name){
        return rizhiService.findallRizhi(name);
    }
}
