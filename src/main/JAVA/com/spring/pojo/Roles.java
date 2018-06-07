package com.spring.pojo;

public class Roles {
    private String id;

    private String name;

    private Integer int0;

    private String string0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getInt0() {
        return int0;
    }

    public void setInt0(Integer int0) {
        this.int0 = int0;
    }

    public String getString0() {
        return string0;
    }

    public void setString0(String string0) {
        this.string0 = string0 == null ? null : string0.trim();
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", int0=" + int0 +
                ", string0='" + string0 + '\'' +
                '}';
    }
}