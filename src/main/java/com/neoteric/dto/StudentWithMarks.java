package com.neoteric.dto;

public class StudentWithMarks {
    private int stuId;
    private String stuName;
    private String studentClass;
    private String subject;
    private int marks;

    public StudentWithMarks(int stuId, String stuName, String studentClass, String subject, int marks) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.studentClass = studentClass;
        this.subject = subject;
        this.marks = marks;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
