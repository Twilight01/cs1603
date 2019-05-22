package com.cs1603.jwglxt.bean.xuanke;

public class System {
    private Integer sysid;
    private String sysname;
    private Integer status;

    public Integer getSysid() {
        return sysid;
    }

    public void setSysid(Integer sysid) {
        this.sysid = sysid;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "System{" +
                "sysid=" + sysid +
                ", sysname='" + sysname + '\'' +
                ", status=" + status +
                '}';
    }
}
