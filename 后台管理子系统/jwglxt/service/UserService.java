package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.bean.houtai.HoutaiPassword;

import com.cs1603.jwglxt.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     *
     * @return User[]
     */
    public HoutaiPassword[] findAll() {
        return userMapper.findAll();
    }

    public HoutaiPassword findByUsername(String username){
        return userMapper.findByUsername(username);
    }
    public HoutaiPassword[] findUsername(String username){
        HoutaiPassword[] psd=userMapper.findUsername("%"+username+"%");
        if(psd==null){
            System.out.println("sorry");
        }
        else{
            System.out.println("psd.length:"+psd.length);
        }
        return psd;
    }
    public Integer insert(HoutaiPassword user){
        if (userMapper.findByUsername(user.getId())!=null)
        {
            return 1;

        }
        else
        {
            Integer i=userMapper.insert(user);
            System.out.println(i);
            return 0;
        }
    }
    public Integer delete(String username){
        if (userMapper.findByUsername(username)==null)
        {
            return 1;
        }
        else
        {
           Integer i= userMapper.delete(username);
            System.out.println("success");
            return 0;
        }
    }
    public Integer update(HoutaiPassword user){
        if (userMapper.findByUsername(user.getId())==null)
        {
            System.out.println(user.getId());
            return 1;

        }
        else
        {
            HoutaiPassword user1=userMapper.findByUsername(user.getId());
            if(user.getNature()==null){
                user.setNature(user1.getNature());
            }
            return userMapper.update(user);
        }
    }
}
