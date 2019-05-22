package com.cs1603.jwglxt.mapper.chengji.teacher;

import com.cs1603.jwglxt.bean.chengji.teacher.Gradespercent;
import com.cs1603.jwglxt.bean.chengji.teacher.Studentgrades;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentgradesMapper {
    /**
     * 该函数根据课程表号id，返回了选取该课程的所有学生的相关成绩信息
     * @author 孟章希
     * @param id 课程表号
     * @return Studentgrades[] 包含学生成绩的对象数组
     */
    @Select("SELECT sclass,sname,student.sid,major,ctype,score1,percent1,score2,percent2,score3,percent3,score,scorelevel " +
            "FROM student,studentcourse,coursehistory " +
            "WHERE student.sid = studentcourse.sid AND studentcourse.id = coursehistory.id AND coursehistory.id=#{id};")
    public Studentgrades[] findById(Integer id);

    /**
     * 该函数修改了某个课程的成绩百分比
     * @author 孟章希
     * @param id 课程表号
     * @param percent1 平时成绩百分比
     * @param percent2 期中/实验成绩百分比
     * @param percent3 期末成绩百分比
     * @return int 是WHERE所能匹配到的记录条数
     */
    @Update("UPDATE studentcourse SET percent1=#{percent1},percent2=#{percent2},percent3=#{percent3} WHERE id=#{id};")
    public int updatePercents(Integer id, String percent1, String percent2, String percent3);

    /**
     * 该函数修改了某个课程的某个学生的三项成绩
     * @author 孟章希
     * @param id 课程表号
     * @param sid 学生学号
     * @param score1 平时成绩
     * @param score2 期中/实验成绩
     * @param score3 期末成绩
     * @return int 是WHERE所能匹配到的记录条数
     */
    @Update("UPDATE studentcourse SET score1=#{score1},score2=#{score2},score3=#{score3} WHERE id=#{id} AND sid=#{sid}")
    public int updateGrades(Integer id, String sid, String score1, String score2, String score3);

    /**
     * 该函数修改了学生的百分制总成绩及字母制成绩
     * @author 孟章希
     * @param id 课程表号
     * @param sid 学生学号
     * @param score 总成绩（百分制）
     * @param scorelevel 总成绩（字母制）
     * @return int 是WHERE所能匹配到的记录条数
     */
    @Update("UPDATE studentcourse SET score=#{score},scorelevel=#{scorelevel} WHERE id=#{id} AND sid=#{sid}")
    public int updateSumGrades(Integer id, String sid, String score, String scorelevel);

    /**
     * 该函数用来获取某个课程的各部分成绩比例
     * @author 小五
     * @param id 课程表号
     * @return 三项成绩的比例
     */
    @Select("SELECT DISTINCT percent1,percent2,percent3 FROM studentcourse WHERE id=#{id}")
    public Gradespercent getPercents(Integer id);
}

