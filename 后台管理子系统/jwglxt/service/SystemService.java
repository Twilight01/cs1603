package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.houtai.HoutaiSystem;
import com.cs1603.jwglxt.mapper.SystemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SystemService {
    @Resource
    private SystemMapper systemMapper;
    public HoutaiSystem findIsOpen(Integer id){
       HoutaiSystem s= systemMapper.findSystem(id);
      return s;


    }
    public boolean IsOpen(Integer id){
        HoutaiSystem s= systemMapper.findSystem(id);
        if(s==null)return false;
        if(s.getStatus()==1){
            return true;
        }
        return false;

    }
    public void UpdateSystem(Integer id,Integer num){
         systemMapper.UpdateSystem(id,num);
    }

}
