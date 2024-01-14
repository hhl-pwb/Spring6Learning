package com.atguigu.spring6.iocxml.ditest;

public class Emp {
    // 员工属于某个部门
    private Dept dept;
    private String ename;
    private String age;
    public Dept getDept() {return dept;}
    public void setDept(Dept dept) {this.dept = dept;}
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void work() {
        System.out.println(ename + "emp work..." + age);
        dept.info();
    }
}
