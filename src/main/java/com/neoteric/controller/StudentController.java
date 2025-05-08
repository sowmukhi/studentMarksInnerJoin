package com.neoteric.controller;

import com.neoteric.dto.StudentWithMarks;
import com.neoteric.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/with-marks")
    public List<StudentWithMarks> getStudentsWithMarks() {
        return studentService.fetchStudentsWithMarks();
    }
}
