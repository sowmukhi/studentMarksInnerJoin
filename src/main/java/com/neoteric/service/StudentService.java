package com.neoteric.service;

import com.neoteric.dao.StudentDAO;
import com.neoteric.dto.StudentWithMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

    public List<StudentWithMarks> fetchStudentsWithMarks() {
        return studentDAO.getStudentsWithMarks();
    }
}
