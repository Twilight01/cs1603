package com.cs1603.jwglxt.bean.chengji.student;

public class chengji_Studentcourse {
    private Integer id;
    private Integer semester;
    private String year;
    private String sid;
    private String score1;
    private String score2;
    private String score3;
    private String percent1;
    private String percent2;
    private String percent3;
    private String score;
    private String scorelevel;
    private String cnum;
    private String cname;
    private String ctype;
    private String credit;
    private String tname;

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getScore3() {
        return score3;
    }

    public void setScore3(String score3) {
        this.score3 = score3;
    }

    public String getPercent1() {
        return percent1;
    }

    public void setPercent1(String percent1) {
        this.percent1 = percent1;
    }

    public String getPercent2() {
        return percent2;
    }

    public void setPercent2(String percent2) {
        this.percent2 = percent2;
    }

    public String getPercent3() {
        return percent3;
    }

    public void setPercent3(String percent3) {
        this.percent3 = percent3;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScorelevel() {
        return scorelevel;
    }

    public void setScorelevel(String scorelevel) {
        this.scorelevel = scorelevel;
    }

    @Override
    public String toString() {
        return "chengji_Studentcourse{" +
                "id=" + id +
                ", semester=" + semester +
                ", year='" + year + '\'' +
                ", sid='" + sid + '\'' +
                ", score1='" + score1 + '\'' +
                ", score2='" + score2 + '\'' +
                ", score3='" + score3 + '\'' +
                ", percent1='" + percent1 + '\'' +
                ", percent2='" + percent2 + '\'' +
                ", percent3='" + percent3 + '\'' +
                ", score='" + score + '\'' +
                ", scorelevel='" + scorelevel + '\'' +
                '}';
    }
}
