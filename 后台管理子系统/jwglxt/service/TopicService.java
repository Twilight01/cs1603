package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.houtai.HoutaiTopic;
import com.cs1603.jwglxt.mapper.TopicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TopicService {
    @Resource
    private TopicMapper topicMapper;
    public Integer insert(HoutaiTopic user){
        if (topicMapper.findByUsername(user.getIdTopic())!=null)
        {
            return 1;
        }
        else
        {

            return topicMapper.insert(user);
        }
    }

}
