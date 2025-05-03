package com.neoteric.model;

public class Student {
    private int stuId;
    private String stuName;
    private String studentClass;

    public Student(int stuId, String stuName, String studentClass) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.studentClass = studentClass;
    }

    public int getStuId() { return stuId; }
    public String getStuName() { return stuName; }
    public String getStudentClass() { return studentClass; }

    public void setStuId(int stuId) { this.stuId = stuId; }
    public void setStuName(String stuName) { this.stuName = stuName; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }
}
