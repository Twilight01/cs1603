package com.cs1603.jwglxt.bean;

import org.apache.ibatis.jdbc.SQL;

public class hhh {
    public String selectCourseSql(String sid,String year,Integer semester){
        return new SQL(){
            {
                SELECT("cnum,cname,tname,ctype,credit,score,scorelevel,score1,percent1,score2,percent2,score3,percent3");
                FROM("studentcourse,teacher,coursehistory");
                WHERE("studentcourse.id=coursehistory.id AND coursehistory.tid=teacher.tid AND sid = #{sid}");
                if (!year.equals("all")){
                    WHERE("studentcourse.year=#{year}");
                }
                if(semester!=0){
                    WHERE("studentcourse.semester=#{semester}");
                }
            }
        }.toString();
    }

}
