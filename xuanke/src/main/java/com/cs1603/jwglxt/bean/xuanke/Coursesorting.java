package com.cs1603.jwglxt.bean.xuanke;

public class Coursesorting {
    private Integer id;
    private String cnum;
    private String cname;
    private String cmajor;
    private String ctype;
    private String tid;
    private String call;
    private String cstart;
    private String cend;
    private String credit;
    private String ctime;
    private String cfre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCmajor() {
        return cmajor;
    }

    public void setCmajor(String cmajor) {
        this.cmajor = cmajor;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getCstart() {
        return cstart;
    }

    public void setCstart(String cstart) {
        this.cstart = cstart;
    }

    public String getCend() {
        return cend;
    }

    public void setCend(String cend) {
        this.cend = cend;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCfre() {
        return cfre;
    }

    public void setCfre(String cfre) {
        this.cfre = cfre;
    }

    @Override
    public String toString() {
        return "Coursesorting{" +
                "id=" + id +
                ", cnum='" + cnum + '\'' +
                ", cname='" + cname + '\'' +
                ", cmajor='" + cmajor + '\'' +
                ", ctype='" + ctype + '\'' +
                ", tid='" + tid + '\'' +
                ", call='" + call + '\'' +
                ", cstart='" + cstart + '\'' +
                ", cend='" + cend + '\'' +
                ", credit='" + credit + '\'' +
                ", ctime='" + ctime + '\'' +
                ", cfre='" + cfre + '\'' +
                '}';
    }
}
