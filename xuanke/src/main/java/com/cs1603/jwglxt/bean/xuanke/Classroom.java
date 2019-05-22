package com.cs1603.jwglxt.bean.xuanke;

public class Classroom {
    private Integer classid;
    private String classname;
    private String classvol;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassvol() {
        return classvol;
    }

    public void setClassvol(String classvol) {
        this.classvol = classvol;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classid=" + classid +
                ", classname='" + classname + '\'' +
                ", classvol='" + classvol + '\'' +
                '}';
    }
}
