package com.cs1603.jwglxt.bean.xuanke;

public class Teacher_topic {
    private String idTeacher;
    private String idTopic;

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    @Override
    public String toString() {
        return "Teacher_topic{" +
                "idTeacher='" + idTeacher + '\'' +
                ", idTopic='" + idTopic + '\'' +
                '}';
    }
}
