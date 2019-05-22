package com.cs1603.jwglxt.bean.xuanke;

public class Course {
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
    private String time1;
    private String time2;
    private String cnow;
    private Integer classid;

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

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getCnow() {
        return cnow;
    }

    public void setCnow(String cnow) {
        this.cnow = cnow;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    ////////////////////////////////////////////////////////////scj
    public int call2Number()//stirng 转 int
    {
        String s = this.call;
        int res=0;
        for(int i=0;i<s.length();i++){
            res = res*10;
            res+=s.charAt(i)-'0';
        }
        return res;
    }
    public int cnow2Number()//stirng 转 int
    {
        String s = this.cnow;
        int res=0;
        for(int i=0;i<s.length();i++){
            res = res*10;
            res+=s.charAt(i)-'0';
        }
        return res;
    }

    static public String int2string(int a)//静态int转字符串函数
    {
        String s = "";
        if(a==0)
            return "0";
        while(a!=0){
            s+=(char)('0'+a%10);
            a=a/10;
        }
        String st = "";
        for(int i=0;i<s.length();i++)
            st+=s.charAt(s.length()-i-1);
        return st;
    }
    ////////////////////////////////////////////////////////////scj

    @Override
    public String toString() {
        return "Course{" +
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
                ", time1='" + time1 + '\'' +
                ", time2='" + time2 + '\'' +
                ", cnow='" + cnow + '\'' +
                ", classid=" + classid +
                '}';
    }
}
