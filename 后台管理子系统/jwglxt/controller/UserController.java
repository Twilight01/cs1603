package com.cs1603.jwglxt.controller;

import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.bean.houtai.HoutaiPassword;
import com.cs1603.jwglxt.service.UserService;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


// 自动将返回的东西转换为json格式 供前后端交互
@RestController
//前后端交互跨域解决
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    /**
     *
     * @return User[]
     */
    @RequestMapping("q")
    public HoutaiPassword[] findAll(){
        return userService.findAll();
    }


    @RequestMapping(value="/f",method= RequestMethod.POST)
    public Result<HoutaiPassword> findByUsername(@RequestParam(value="id")String username){

        return ResultUtil.success(userService.findByUsername(username));
    }

    @RequestMapping(value="api/common/houtai/FindZhanghao",method= RequestMethod.POST)
    public HoutaiPassword[] findUsername(@RequestParam(value="id")String username){
        System.out.println("username:"+username);
        return userService.findUsername(username);
    }
    @RequestMapping(value="api/common/houtai/DeleteZhanghao",method= RequestMethod.POST)
    public Result<Integer> delete(@RequestParam(value="id")String username){
        System.out.println("usernamedelete:"+username);
        return ResultUtil.success(userService.delete(username));
    }
    @RequestMapping(value="api/common/houtai/ResetPsd")
    public Result<HoutaiPassword> update(HoutaiPassword username){
        System.out.println(username.getId());
        System.out.println(username.getPassword());
        System.out.println(username.getNature());
        return ResultUtil.success(userService.update(username));
    }
    @RequestMapping(value="api/common/houtai/AddZhanghao",method= RequestMethod.POST)
    public Integer insert(HoutaiPassword username){
        System.out.println("usernamedelete:"+username);
        return userService.insert(username);
    }
    @RequestMapping(value="api/common/houtai/login")
    public Integer login(HoutaiPassword username, ServletRequest req ){
        System.out.println(username.getId());
        HoutaiPassword re=userService.findByUsername(username.getId());
        if(re==null)return 1;
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(username.getPassword());
        System.out.println(re.getPassword());
        if(username.getPassword().equals(re.getPassword())&&username.getNature().equals(re.getNature())){
            System.out.println("cehnggong");
            if(username.getNature().equals("学生")){
                ((HttpServletRequest) req).getSession().setAttribute("id", username.getId());
                ((HttpServletRequest) req).getSession().setAttribute("nature", username.getNature());
                ((HttpServletRequest) req).getSession().setMaxInactiveInterval(3600);
                return 0;
            }
            else if(username.getNature().equals("老师")){
                ((HttpServletRequest) req).getSession().setAttribute("id", username.getId());
                ((HttpServletRequest) req).getSession().setAttribute("nature", username.getNature());
                ((HttpServletRequest) req).getSession().setMaxInactiveInterval(3600);
                return 0;
            }
            else{
                ((HttpServletRequest) req).getSession().setAttribute("id", username.getId());
                ((HttpServletRequest) req).getSession().setAttribute("nature", username.getNature());
                ((HttpServletRequest) req).getSession().setMaxInactiveInterval(3600);
                return 0;
            }
        }
        return 1;
    }
    @RequestMapping(value="/c")
    public ModelAndView loginout( HttpServletRequest request ){
        request.getSession().invalidate();
        return new ModelAndView("redirect:http://www.baidu.com","command","2");
    }

}
