package com.cs1603.jwglxt.bean.chengji.teacher;

public class Gradespercent {
    private String percent1;
    private String percent2;
    private String percent3;

    public String getPercent1() {
        return percent1;
    }

    public String getPercent2() {
        return percent2;
    }

    public String getPercent3() {
        return percent3;
    }

    public void setPercent1(String percent1) {
        this.percent1 = percent1;
    }

    public void setPercent2(String percent2) {
        this.percent2 = percent2;
    }

    public void setPercent3(String percent3) {
        this.percent3 = percent3;
    }

    @Override
    public String toString() {
        return "Gradespercent{" +
                "percent1='" + percent1 + '\'' +
                ", percent2='" + percent2 + '\'' +
                ", percent3='" + percent3 + '\'' +
                '}';
    }

    public boolean notSet() {
        if (percent1 == "0" && percent2 == "0" && percent3 == "0")
            return true;
        else
            return false;
    }
}
