package com.cs1603.jwglxt.service.chengji.teacher;

import com.cs1603.jwglxt.bean.chengji.teacher.Gradespercent;
import com.cs1603.jwglxt.mapper.chengji.teacher.StudentgradesMapper;
import com.cs1603.jwglxt.bean.chengji.teacher.Studentgrades;
import com.cs1603.jwglxt.bean.Result;
import com.cs1603.jwglxt.utils.ResultUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@ComponentScan({"com.cs1603.jwglxt.mapper"})
@Service
public class StudentgradesService {
    @Resource
    private StudentgradesMapper studentgradesMapper;

    /**
     * 私有方法，用来根据百分制成绩获取字母制成绩
     * @author 孟章希
     * @param score 百分制成绩
     * @return String 字母制成绩
     */
    private String level(Integer score) {
        String scorelevel;
        if (score >= 95 && score <= 100)
            scorelevel = "A+";
        else if (score >= 90)
            scorelevel = "A";
        else if (score >= 85)
            scorelevel = "A-";
        else if (score >= 82)
            scorelevel = "B+";
        else if (score >= 78)
            scorelevel = "B";
        else if (score >= 75)
            scorelevel = "B-";
        else if (score >= 72)
            scorelevel = "C+";
        else if (score >= 68)
            scorelevel = "C";
        else if (score >= 64)
            scorelevel = "C-";
        else if (score >= 61)
            scorelevel = "D+";
        else if (score == 60)
            scorelevel = "D";
        else
            scorelevel = "F";
        return scorelevel;
    }

    /**
     * 内部类，包含总成绩的百分制和字母制
     */
    class Score {
        private String score;
        private String scorelevel;

        public String getScore() {
            return score;
        }

        public String getScorelevel() {
            return scorelevel;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public void setScorelevel(String scorelevel) {
            this.scorelevel = scorelevel;
        }

        public Score(String score, String scorelevel) {
            this.score = score;
            this.scorelevel = scorelevel;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "score='" + score + '\'' +
                    ", scorelevel='" + scorelevel + '\'' +
                    '}';
        }
    }

    /**
     * 该函数查询某个课程班级所有学生的成绩信息
     * @author 孟章希
     * @param id 课程表号
     * @return Result 包含结果、结果状态码及相关信息
     */
    public Result selectStudentsGrades(Integer id) {
        Studentgrades[] studentgrades= studentgradesMapper.findById(id);
        if (studentgrades.length == 0) {
            return ResultUtil.error(102, "当前课程没有学生选课记录");
        }
        else {
            return ResultUtil.success(studentgrades);
        }
    }

    /**
     * 该函数执行各部分成绩比例的修改，并且计算并修改其总成绩（百分制和字母制）
     * @author 孟章希
     * @param id 课程表号
     * @param percent1 平时成绩百分比
     * @param percent2 期中/实验成绩百分比
     * @param percent3 期末成绩百分比
     * @return Result 包含结果、结果状态码及相关信息
     */
    public Result changePercents(Integer id, String percent1, String percent2, String percent3) {
        Studentgrades[] studentgrades = studentgradesMapper.findById(id);
        if (studentgrades.length == 0) {
            return ResultUtil.error(102, "当前课程没有学生选课记录，无法设置百分比");
        }
        else {
            int status = studentgradesMapper.updatePercents(id, percent1, percent2, percent3);
            for (int i = 0; i < studentgrades.length; i++) {
                Score score = countSomeoneScore(studentgrades[0].getCtype(), studentgrades[i].getScore1(), percent1,
                        studentgrades[i].getScore2(), percent2,
                        studentgrades[i].getScore3(), percent3);
                studentgradesMapper.updateSumGrades(id, studentgrades[i].getSid(), score.getScore(), score.getScorelevel());
            }
            return ResultUtil.success();
        }
    }

    /**
     * 该函数用来计算总成绩（百分制和字母制）
     * @author 孟章希
     * @param score1 平时成绩
     * @param percent1 平时成绩百分比
     * @param score2 期中/实验成绩
     * @param percent2 期中/实验成绩百分比
     * @param score3 期末成绩
     * @param percent3 期末成绩百分比
     * @return Score 返回总成绩的百分制和字母制
     */
    public Score countSomeoneScore(String ctype, String score1, String percent1, String score2, String percent2, String score3, String percent3) {
        Integer score = (Integer.parseInt(score1) * Integer.parseInt(percent1)
                + Integer.parseInt(score2) * Integer.parseInt(percent2)
                + Integer.parseInt(score3) * Integer.parseInt(percent3)) / 100;
        String scorelevel;

        if (ctype.indexOf("通识教育课程") != -1) {
            if (score == 100)
                scorelevel = "合格";
            else
                scorelevel = "不合格";
        }
        else {
            scorelevel = level(score);
        }

        return new Score(score.toString(), scorelevel);
    }
    /**
     * 该函数修改学生的某一课程的三部分成绩，并且计算并修改其总成绩（百分制和字母制）
     * @author 孟章希
     * @param id 课程表号
     * @param sid 学生学号
     * @param score1 平时成绩
     * @param score2 期中/实验成绩
     * @param score3 期末成绩
     * @return Result 包含结果、结果状态码及相关信息，成功会返回总成绩的百分制和字母制
     */
    public Result changeGrades(Integer id, String ctype, String sid, String score1, String score2, String score3) {
        int status = studentgradesMapper.updateGrades(id, sid, score1, score2, score3);
        if (status == 0) {
            return ResultUtil.error(103, "当前课程没有该学生的选课记录");
        }
        else {
            Gradespercent gradespercent = studentgradesMapper.getPercents(id);
            if (gradespercent.notSet()) {
                return ResultUtil.error(104, "当前课程还未设置各部分成绩百分比，无法登记学生成绩");
            }
            Score score = countSomeoneScore(ctype, score1, gradespercent.getPercent1(),
                    score2, gradespercent.getPercent2(),
                    score3, gradespercent.getPercent3());
            studentgradesMapper.updateSumGrades(id, sid, score.getScore(), score.getScorelevel());
            return ResultUtil.success(score);
        }
    }
}
