package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.houtai.HoutaiOnline_inf;
import com.cs1603.jwglxt.bean.houtai.HoutaiVisit_inf;
import com.cs1603.jwglxt.service.VisitService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//前后端交互跨域解决
@CrossOrigin
public class VisitController {
    @Resource
    private VisitService visitService;
    @RequestMapping("api/common/houtai/ZaixianFangWenLiangXiangxi")
    public HoutaiOnline_inf[] findAllOnlineInf(){
        return visitService.findAllOnlineInf();
    }
    @RequestMapping("api/common/houtai/FangWenLiangXiangxi")
    public HoutaiVisit_inf[] findAllVisitInf(){
        return visitService.findAllVisitInf();
    }
    @RequestMapping("api/common/houtai/CurrentFangWenLiang")
    public Integer currentVisitNum(){
        return visitService.currentVisitNum();
    }
    @RequestMapping("api/common/houtai/TotalFangWenLiang")
    public Integer totalVisitNum(){
        return visitService.totalVisitNum();
    }

}
