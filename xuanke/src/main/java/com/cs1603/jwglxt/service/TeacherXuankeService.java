package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.xuanke.Result;
import com.cs1603.jwglxt.bean.xuanke.Student;
import com.cs1603.jwglxt.mapper.*;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class TeacherXuankeService {
    @Resource
    private TeacherXuankeMapper teacherXuankeMapper;

    /**
     * @author guochong
     * @param tid
     * @return teacher表内所有信息（参数名同数据库属性名）
     */
    public Result<Student> getStudentInformation(String tid){
        if(teacherXuankeMapper.getTeatherInformation(tid) == null)
        {
            return ResultUtil.error(1,"失败，数据不存在");
        }
        else
        {
            return ResultUtil.success(teacherXuankeMapper.getTeatherInformation(tid));
        }
    }
}
