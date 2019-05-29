package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.houtai.HoutaiSystem;
import com.cs1603.jwglxt.service.SystemService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//前后端交互跨域解决
@CrossOrigin
public class SystemController {
    @Resource
    private SystemService systemService;
    @RequestMapping("api/common/houtai/IsOpen")
    public HoutaiSystem find(Integer id){

            return systemService.findIsOpen(id);


    }
    @RequestMapping("api/common/houtai/UpdateSystem")
    public void UpdateSystem(Integer id,Integer num){
       systemService.UpdateSystem(id,num);
    }
}
