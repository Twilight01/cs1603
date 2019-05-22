package com.cs1603.jwglxt.bean.chengji.teacher;

public class Teachercourses {
    private String cname;
    private String cmajor;
    private String ctype;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id_) {
        id = id_;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname_) {
        cname = cname_;
    }

    public String getCmajor() {
        return cmajor;
    }

    public void setCmajor(String cmajor_) {
        cmajor = cmajor_;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype_) {
        ctype = ctype_;
    }

    @Override
    public String toString() {
        return "Teachercourses{" +
                "cname='" + cname + '\'' +
                ", cmajor='" + cmajor + '\'' +
                ", ctype='" + ctype + '\'' +
                ", id=" + id +
                '}';
    }
}
