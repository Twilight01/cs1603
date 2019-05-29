package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.bean.houtai.HoutaiTopic;
import com.cs1603.jwglxt.service.TopicService;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//前后端交互跨域解决
@CrossOrigin
public class TopicController {
    private TopicService topicService;
    @RequestMapping(value="/i1",method= RequestMethod.POST)
    public Result<HoutaiTopic> insert(HoutaiTopic username){
        return ResultUtil.success(topicService.insert(username));
    }
}
