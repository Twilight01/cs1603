package com.cs1603.jwglxt.bean.xuanke;

public class Admin {
    private String aid;
    private String aname;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                '}';
    }
}
