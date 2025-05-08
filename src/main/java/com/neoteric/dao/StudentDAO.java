package com.neoteric.dao;

import com.neoteric.dto.StudentWithMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentWithMarks> getStudentsWithMarks() {
        String sql = "SELECT s.stu_id, s.stu_name, s.class, m.subject, m.marks " +
                "FROM student s INNER JOIN marks m ON s.stu_id = m.stu_id";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new StudentWithMarks(
                        rs.getInt("stu_id"),
                        rs.getString("stu_name"),
                        rs.getString("class"),
                        rs.getString("subject"),
                        rs.getInt("marks")
                )
        );
    }
}
