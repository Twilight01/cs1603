package com.cs1603.jwglxt.service;

import com.cs1603.jwglxt.mapper.*;
import com.cs1603.jwglxt.bean.xuanke.*;
import com.cs1603.jwglxt.utils.*;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.lang.System;

@Service
public class StudentXuankeService {
    @Resource
    private StudentXuankeMapper studentXuankeMapper;


    /**
     *
     * @param sid
     * @return 根据学生学号查询到的学生表里的全部信息
     */
    public Result<Student> getStudentInformation(String sid){
        if(studentXuankeMapper.getStudentInformation(sid) == null)
        {
            return ResultUtil.error(1,"失败，数据不存在");
        }
        else
        {
            return ResultUtil.success(studentXuankeMapper.getStudentInformation(sid));
        }
    }

    /**
     * @author guochong
     * @param collegeName
     * @return String[] 通过学院名称查询到的所有专业名称
     */
    public Result<String[]> getMajorNameByCollegeName(String collegeName)
    {
        if(studentXuankeMapper.getMajorNameByCollegeName(collegeName).length == 0)
            return ResultUtil.error(1,"失败，数据不存在");
        else
            return ResultUtil.success(studentXuankeMapper.getMajorNameByCollegeName(collegeName));
    }

    /**
     * @author guochong
     * @param collegeName
     * @param majorName
     * @param grade
     * @param ctype
     * @param credit
     * @param flag
     * @return Coursehistory[] 根据所传参数返回满足条件的课程
     */
    public Result<Coursehistory[]> chake(String collegeName, String majorName,String grade, String ctype, String credit, String flag,Result<String[]> zy)
    {
        if(zy.getCode() == 0) //zy 有数据
        {
            System.out.println("aaa");
            if(studentXuankeMapper.chake(collegeName, majorName, grade, ctype, credit, flag, zy.getData()).length == 0)
               return ResultUtil.error(1,"失败，数据不存在6");
            else
                return ResultUtil.success(studentXuankeMapper.chake(collegeName, majorName, grade, ctype, credit, flag, zy.getData()));
        }
        else //zy 无数据
        {
            System.out.println("aa");
            if(majorName != null && !majorName.isEmpty()) //majorName 有数据
            {

                Dongtaisql a = new Dongtaisql();
                System.out.println(a.chakesql(collegeName, majorName, grade, ctype, credit, flag, zy.getData()));
                if(studentXuankeMapper.chake(collegeName, majorName, grade, ctype, credit, flag, zy.getData()).length == 0)
                    return ResultUtil.error(1,"失败，数据不存在7");
                else
                    return ResultUtil.success(studentXuankeMapper.chake(collegeName, majorName, grade, ctype, credit, flag, zy.getData()));

            }
            else
                if(studentXuankeMapper.chake(collegeName, majorName, grade, ctype, credit, flag, zy.getData()).length == 0)
                    return ResultUtil.error(1,"失败，数据不存在5");
                else
                    return ResultUtil.success(studentXuankeMapper.chake(collegeName, majorName, grade, ctype, credit, flag, zy.getData()));

        }
    }

    /**
     *
     * @param cname
     * @return Coursehistory[] 课程名为cname的课程
     */
    public Result<Coursehistory[]> chakeByCname(String cname)
    {
        if (studentXuankeMapper.chakeByCname(cname).length == 0)
            return ResultUtil.error(1,"失败，数据不存在");
        else
            return ResultUtil.success(studentXuankeMapper.chakeByCname(cname));
    }

    /**
     *@author guochong
     * @return String[] 所有学院名称
     */
    public Result<String []> getCollegeName()
    {
        if(studentXuankeMapper.getCollegeName().length == 0)
            return ResultUtil.error(1,"数据不存在8");
        else
            return ResultUtil.success(studentXuankeMapper.getCollegeName());
    }


    /**
     * scj
     */
    public Result<Studentcourse> xuanKe(Integer id,String sid,String year,Integer semester) {//选课功能
        System.out.println(id+"   "+sid+"   "+year+"   "+semester);
        if (getCourses(id).cnow2Number() >= getCourses(id).call2Number()) {//错误判断3
            return ResultUtil.error(3, "失败，课程余量不足");
        }
        if (studentXuankeMapper.penchoose(id,sid) != null) {//错误判断1
            return ResultUtil.error(1, "失败，你已选上此课程");
        }
        if(chongtu(id,sid,year,semester)==0){
            return ResultUtil.error(2, "失败，时间冲突");
        }
        if(xuanKego(id,sid,year,semester)==1&&updatecourse(id, sid)==1)
            //xuanKego(id,sid,year,semester);//在学生选课表里插入学生选课信息
            //updatecourse(id, sid);//更新全校课程表
            return ResultUtil.success(studentXuankeMapper.xuanKe(id, sid, year, semester));
        return ResultUtil.error(4, "失败，未知错误");
    }

    public Integer chongtu(Integer id,String sid,String year,Integer semester){//判断选课是否冲突的函数，1可以选课，0不能选课
        Coursetable T = getatable(sid,year,semester);
        Course cos = getCourses(id);
        String t1 = cos.getTime1();
        String t2 = cos.getTime2();

        int week;
        int tnum=0;
        if(!t1.equals("")) {
            String w = "";
            w += t1.charAt(0);
            week = Coursetable.CtNumber(w);//获得周数
            System.out.println("chongtu"+t1+"====="+t2+"+++++++++"+week);
            String time = "";
            for (int i = 2; i < t1.length(); i++) {
                if (t1.charAt(i) == ',') {
                    System.out.println(T.gettablenum(week,Coursetable.tNumber(time))+"---"+week+"'''"+Coursetable.tNumber(time));
                    if (T.gettablenum(week,Coursetable.tNumber(time))!=null){
                        System.out.println("课程冲突1");
                        return 0;
                    }
                    else System.out.println("wuchongtu1");
                    time = "";
                    continue;
                }
                time += t1.charAt(i);
            }
        }
        if(!t2.equals("")) {
            String w = "";
            w += t2.charAt(0);
            week = Coursetable.CtNumber(w);//获得周数
            String time = "";
            for (int i = 2; i < t2.length(); i++) {
                if (t2.charAt(i) == ',') {
                    if (T.gettablenum(week,Coursetable.tNumber(time))!=null){
                        System.out.println("课程冲突2");
                        return 0;
                    }
                    time = "";
                    continue;
                }
                time += t2.charAt(i);
            }
        }
        return 1;
    }

    public int xuanKego(Integer id,String sid,String year,Integer semester){//执行选课操作
        return studentXuankeMapper.xuanKego(id,sid,year,semester);
    }

    public Course getCourses(Integer id){//获取课程信息
        return studentXuankeMapper.getCourses(id);
    }

    public Course gethisCourses(Integer id){//获取历史课程信息
        return studentXuankeMapper.getCourses(id);
    }

    public Studentcourse penchoose(Integer id,String sid){//判断是否已经选过这门课了
        return studentXuankeMapper.penchoose(id,sid);
    }

    public int updatecourse(Integer id,String cnow){//更新全校课程表里的课程选择数量信息+1
        int updatenow = getCourses(id).cnow2Number();
        updatenow=updatenow+1;
        return studentXuankeMapper.updatecourse(id,Course.int2string(updatenow));
        //return 1;
    }

    public Result<Integer> tuiKe(Integer id,String sid){
        Integer i = 1;
        if(studentXuankeMapper.penchoose(id,sid)==null)
            return ResultUtil.error(1,"失败，你已成功退选课程");
        if(updatecourse2(id,sid)==1)
            //updatecourse2(id,sid);
            return ResultUtil.success(studentXuankeMapper.tuiKego(id,sid));//成功

        return ResultUtil.error(2,"失败，未知错误");
    }

    public int tuiKego(Integer id,String sid){
        return studentXuankeMapper.tuiKego(id,sid);
    }

    public int updatecourse2(Integer id,String cnow){///更新全校课程表里的课程选择数量信息-1
        int updatenow = getCourses(id).cnow2Number();
        updatenow=updatenow-1;
        return studentXuankeMapper.updatecourse2(id,Course.int2string(updatenow));
        //return 1;
    }

    public Result<Coursetable> gettable(String sid,String year,Integer semester){
        //public Coursetable gettable(String sid,String year,Integer semester) {//生成课程表

        Coursetable Table = new Coursetable();//生成本次查询得到的课表
        //System.out.println("++++++++++++++++++++++++++++++++++=");
        Studentcourse[] scs = getallcourse(sid,year,semester);
        int scnum = scs.length;//获得数组中有多少元素
        System.out.println(scnum+"[[[[[[[[[[");
        for(int p=0;p<scnum;p++){//对数组中的每一个元素分量p,即对于每一条课程记录
            Course cos = gethisCourses(scs[p].getId());//根据当前处理的课程的课程ID获取课程相关信息
            Teacher tea = findteacher(cos.getTid());//根据老师的编号查找老师相关信息存在tea变量中
            String s1 = cos.getTime1();//取得第一次上课的时间
            String s2 = cos.getTime2();//取得第二次上课的时间
            String classname =  getclasses(cos.getClassid()).getClassname();
            System.out.println("-----------------------------"+s1+"------"+s2);
            if(!s1.equals("")){//如果上课时间1不是空
                String week ="";
                week += s1.charAt(0);
                int wek = Coursetable.CtNumber(week);//得到星期
                String n="";
                for(int i=2;i<s1.length();i++){
                    if(s1.charAt(i)==',') {
                        int k=Coursetable.tNumber(n);System.out.println("if1===================="+k);
                        //coursetable[wek][k]=tNumber(ids[idi]);

                        Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                        n="";
                        continue;
                    }
                    n+=s1.charAt(i);
                }
                int k=Coursetable.tNumber(n);
                Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                //coursetable[wek][k]=tNumber(ids[idi]);
            }
            if(!s2.equals("")){//如果上课时间2不是空
                String week ="";
                week += s2.charAt(0);
                int wek = Coursetable.CtNumber(week);//得到星期
                String n="";
                for(int i=1;i<s2.length();i++){
                    if(s2.charAt(i)==',') {
                        int k=Coursetable.tNumber(n);
                        Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                        //Table.setTable(wek,k,scs[p].getId());
                        //coursetable[wek][k]=tNumber(ids[idi]);
                        n="";
                        continue;
                    }
                    n+=s2.charAt(i);
                }
                int k=Coursetable.tNumber(n);
                //Table.setTable(wek,k,scs[p].getId());
                Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                //coursetable[wek][k]=tNumber(ids[idi]);
            }
        }
        //return Table;//返回生成的课表
        return ResultUtil.success(Table);
    }

    public Coursetable getatable(String sid,String year,Integer semester) {//生成课程表
        Coursetable Table = new Coursetable();//生成本次查询得到的课表
        //System.out.println("++++++++++++++++++++++++++++++++++=");
        Studentcourse[] scs = getallcourse(sid,year,semester);
        int scnum = scs.length;//获得数组中有多少元素
        System.out.println(scnum+"[[[[[[[[[[");
        for(int p=0;p<scnum;p++){//对数组中的每一个元素分量p,即对于每一条课程记录
            Course cos = gethisCourses(scs[p].getId());//根据当前处理的课程的课程ID获取课程相关信息
            Teacher tea = findteacher(cos.getTid());//根据老师的编号查找老师相关信息存在tea变量中
            String s1 = cos.getTime1();//取得第一次上课的时间
            String s2 = cos.getTime2();//取得第二次上课的时间
            String classname =  getclasses(cos.getClassid()).getClassname();
            System.out.println("-----------------------------"+s1+"------"+s2);
            if(!s1.equals("")){//如果上课时间1不是空
                String week ="";
                week += s1.charAt(0);
                int wek = Coursetable.CtNumber(week);//得到星期
                String n="";
                for(int i=2;i<s1.length();i++){
                    if(s1.charAt(i)==',') {
                        int k=Coursetable.tNumber(n);System.out.println("if1===================="+k);
                        //coursetable[wek][k]=tNumber(ids[idi]);

                        Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                        n="";
                        continue;
                    }
                    n+=s1.charAt(i);
                }
                int k=Coursetable.tNumber(n);
                Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                //coursetable[wek][k]=tNumber(ids[idi]);
            }
            if(!s2.equals("")){//如果上课时间2不是空
                String week ="";
                week += s2.charAt(0);
                int wek = Coursetable.CtNumber(week);//得到星期
                String n="";
                for(int i=1;i<s2.length();i++){
                    if(s2.charAt(i)==',') {
                        int k=Coursetable.tNumber(n);
                        Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                        //Table.setTable(wek,k,scs[p].getId());
                        //coursetable[wek][k]=tNumber(ids[idi]);
                        n="";
                        continue;
                    }
                    n+=s2.charAt(i);
                }
                int k=Coursetable.tNumber(n);
                //Table.setTable(wek,k,scs[p].getId());
                Table.setTable(wek,k,cos.getId(),cos.getCname(),tea.getTname(),classname);
                //coursetable[wek][k]=tNumber(ids[idi]);
            }
        }
        //return Table;//返回生成的课表
        return Table;
    }

    public Classroom getclasses(Integer classid){
        return studentXuankeMapper.getclasses(classid);
    }

    public Studentcourse[] getallcourse(String sid,String year,Integer semester){//查询学生在指定学年学期的所有课程
        return studentXuankeMapper.getallcourse(sid,year,semester);
    }

    public Course findcourse(Integer id){//根据课程id 查找课程相关信息
        return studentXuankeMapper.findcourse(id);
    }

    public Teacher findteacher(String tid){
        return studentXuankeMapper.findteacher(tid);
    }


    public Result<Course[]> checked(String sid,String year,Integer semester){
        Studentcourse[] stc = studentXuankeMapper.checked(sid,year,semester);
        Course[] cs = new Course[91];
        for(int i=0;i<stc.length;i++){
            cs[i]=findcourse(stc[i].getId());
        }
        return ResultUtil.success(cs);
    }
}
