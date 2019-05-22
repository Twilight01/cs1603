package com.cs1603.jwglxt.bean.xuanke;

public class Collegemajor {
    private String collegeName;
    private String majorName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Collegemajor{" +
                "collegeName='" + collegeName + '\'' +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
