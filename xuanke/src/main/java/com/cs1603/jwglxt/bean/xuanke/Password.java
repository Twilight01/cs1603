package com.cs1603.jwglxt.bean.xuanke;

public class Password {
    private String id;
    private String password;
    private String nature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Override
    public String toString() {
        return "Password{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", nature='" + nature + '\'' +
                '}';
    }
}
