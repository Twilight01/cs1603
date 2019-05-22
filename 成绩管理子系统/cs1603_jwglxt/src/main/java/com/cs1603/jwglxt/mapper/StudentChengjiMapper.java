package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.chengji.student.chengji_Studentcourse;
import org.apache.ibatis.annotations.Select;

public interface StudentChengjiMapper {

    /**
     * 学生根据学号、学年、学期查询自己的成绩
     * @param sid
     * @param year
     * @param semester
     * @return studentcourse数组
     */
    @Select("<script>"
            + "SELECT cnum,cname,tname,ctype,credit,score,scorelevel,score1,percent1,score2,percent2,score3,percent3 "
            + "FROM studentcourse,teacher,coursehistory "
            + "WHERE studentcourse.id=coursehistory.id AND coursehistory.tid=teacher.tid AND sid = #{sid} "
            + "<if test='year != \"all\"'>"
            + "AND studentcourse.year = #{year} "
            + "</if>"
            + "<if test='semester != 0'>"
            + "AND studentcourse.semester = #{semester} "
            + "</if>"
            + "</script>")
    public chengji_Studentcourse[] findById(String sid, String year, Integer semester);
}
