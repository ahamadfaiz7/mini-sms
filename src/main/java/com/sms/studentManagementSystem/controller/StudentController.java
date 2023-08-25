package com.sms.studentManagementSystem.controller;

import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value="/api/v1/")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value ="/getStudents")
    public List<Student> findAll() {
        List<Student> students = studentService.listAll();
        return students;
    }
}
