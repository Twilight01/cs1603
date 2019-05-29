package com.cs1603.jwglxt.bean.houtai;

import java.util.Date;

public class HoutaiTopic {
    private String idTopic;
    private String nameTopic;
    private String aimedMajor;
    private String introduction;
    private Integer max_Limit;
    private Integer remain;
    private String location;
    private Date date;
    private String type;

    public String getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public String getAimedMajor() {
        return aimedMajor;
    }

    public void setAimedMajor(String aimedMajor) {
        this.aimedMajor = aimedMajor;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getMax_Limit() {
        return max_Limit;
    }

    public void setMax_Limit(Integer max_Limit) {
        this.max_Limit = max_Limit;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
