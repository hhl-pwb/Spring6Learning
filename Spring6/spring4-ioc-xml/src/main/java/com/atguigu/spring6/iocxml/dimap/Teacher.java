package com.atguigu.spring6.iocxml.dimap;
public class Teacher {
    private String teacherId;
    private String teachrName;
    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeachrName() {
        return teachrName;
    }
    public void setTeachrName(String teachrName) {
        this.teachrName = teachrName;
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teachrName='" + teachrName + '\'' +
                '}';
    }
}
