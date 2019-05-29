package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.houtai.HoutaiCoursesorting;
import com.cs1603.jwglxt.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseService {
    @Resource
    private CourseMapper courseMapper;
    public Integer insert(HoutaiCoursesorting user){


        if (courseMapper.findByUsername(user.getId())!=null)
        {
            System.out.println("qooooooooooooooo");
            return 2;
        }
        else if(courseMapper.findTeacher(user.getTid())==null){
            System.out.println("qooooooooooooooo12");
            return 3;
        }
        else
        {
            System.out.println("qoooooooooooooo1");
            Integer i=courseMapper.insert(user);
        if(i!=1)return 1;
            return 0;
        }

    }
}
