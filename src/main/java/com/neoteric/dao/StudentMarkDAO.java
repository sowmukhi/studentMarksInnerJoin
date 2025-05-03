package com.neoteric.dao;

import com.neoteric.model.Marks;
import com.neoteric.model.Student;
import com.neoteric.model.StudentMark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentMarkDAO {
    private final String url = "jdbc:mysql://localhost:3306/studentjoin";
    private final String user = "root";
    private final String password = "Sow@5555";

    public List<StudentMark> getAllStudentMarks() throws Exception {
        List<StudentMark> list = new ArrayList<>();

        String sql = "SELECT s.stu_id, s.stu_name, s.class, m.subject, m.marks " +
                "FROM Student s INNER JOIN Marks m ON s.stu_id = m.stu_id";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("stu_id"),
                        rs.getString("stu_name"),
                        rs.getString("class")
                );

                Marks marks = new Marks(
                        rs.getInt("stu_id"),
                        rs.getString("subject"),
                        rs.getInt("marks")
                );

                StudentMark studentMark = new StudentMark(student, marks);
                list.add(studentMark);
            }
        }

        return list;
    }
}
