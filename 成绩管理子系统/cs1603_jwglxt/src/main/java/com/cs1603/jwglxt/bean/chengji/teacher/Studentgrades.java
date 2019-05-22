package com.cs1603.jwglxt.bean.chengji.teacher;

public class Studentgrades {
    private String sclass;
    private String sname;
    private String sid;
    private String major;
    private String ctype;
    private String score1;
    private String score2;
    private String score3;
    private String percent1;
    private String percent2;
    private String percent3;
    private String score;
    private String scorelevel;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Studentgrades{" +
                "sclass='" + sclass + '\'' +
                ", sname='" + sname + '\'' +
                ", sid='" + sid + '\'' +
                ", major='" + major + '\'' +
                ", ctype='" + ctype + '\'' +
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

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass_) {
        sclass = sclass_;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname_) {
        sname = sname_;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype_) {
        ctype = ctype_;
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

}
