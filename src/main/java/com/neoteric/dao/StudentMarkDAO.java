package com.neoteric.dao;

import com.neoteric.model.Marks;
import com.neoteric.model.Student;
import com.neoteric.model.StudentMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMarkDAO {
    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<StudentMark> getAllStudentMarks() throws Exception {
        List<StudentMark> list = new ArrayList<>();

        String sql = "SELECT s.stu_id, s.stu_name, s.class, m.subject, m.marks " +
                "FROM Student s INNER JOIN Marks m ON s.stu_id = m.stu_id";

        try (Connection conn = dataSource.getConnection();
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

                list.add(new StudentMark(student, marks));
            }
        }

        return list;
    }
}
