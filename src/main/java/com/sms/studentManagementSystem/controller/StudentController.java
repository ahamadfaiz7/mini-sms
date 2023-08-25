package com.sms.studentManagementSystem.controller;

import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentController implements Serializable {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> findAll() {
        List<Student> students = studentService.listAll();
        return students;
    }
}
