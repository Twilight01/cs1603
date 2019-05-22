package com.cs1603.jwglxt.bean.xuanke;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.apache.ibatis.jdbc.SQL;

public class Dongtaisql {
    public String chakesql(String collegeName, String majorName,String grade, String ctype, String credit, String flag, String[] zy)
    {
        return new SQL(){
            {
                //SELECT("cnum,cname,ctype,cmajor,credit,`call`,cnow,cstart,cend,id,time1,time2");
                SELECT("cnum,cname,ctype,tname,cmajor,credit,classname,`call`,cnow,cstart,cend,id,time1,time2");
                FROM("course,teacher,classroom");
                //FROM("course");
                WHERE("course.tid = teacher.tid AND course.classid = classroom.classid");
                if (ctype != null && !ctype.isEmpty()){
                    WHERE("ctype=#{ctype}");
                }
                if (credit != null && !credit.isEmpty()){
                    WHERE("credit=#{credit}");
                }
                if (flag != null && !flag.isEmpty()){
                    if(flag.equals("0"))
                        WHERE("cnow = `call` ");
                    else
                        WHERE("cnow <> `call` ");
                }
                if(majorName != null && !majorName.isEmpty())
                {
                    if (grade != null && !grade.isEmpty())
                    {
                        String s = grade + majorName;
                        WHERE("(cmajor like '%" + s + "%' OR cmajor = '全部专业')");
                    }
                    else
                        WHERE("(cmajor like '%${majorName}%' OR cmajor = '全部专业')");
                }
                else if(zy != null && zy.length != 0)
                {
                    String sql = "(";
                    for(int i = 0; i < zy.length; i ++ )
                    {
                        String zz = "'%" + zy[i] + "%'";
                        sql +="cmajor like " +  zz + " OR ";
                        if(zy.length == 1) sql +="cmajor like " +  zz;
                    }
                    sql += "cmajor like '%全部专业%')";
                    WHERE(sql);
                }
            }
        }.toString();
    }
    public String sql()
    {
        return new SQL()
        {
            {
                SELECT("*");
                FROM("course");
            }

        }.toString();
    }
}
