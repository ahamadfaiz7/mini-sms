package com.sms.studentManagementSystem.controller;

import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * This is an Api controller and will be called by any rest client or any other microservice
 */
@RestController
@RequestMapping("/api")
public class StudentApiController implements Serializable {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        List<Student> students = studentService.listAll();
        return students;
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveStudent(@RequestBody Student student) {
        String responseMessage;
        try {
            studentService.save(student);
        } catch (Exception e) {
            String detailError;
            e.printStackTrace();
            if (e.getMessage().contains("Unique index or primary key violation")) {
                responseMessage = "Duplicate Student Number " + "\n";
                detailError = "Please enter a different unique student number";
            } else {
                responseMessage = "Error saving student. Detail Error=>" + "\n";
                detailError = responseMessage + e.getMessage();
            }
            return responseMessage + detailError;
        }
        return "Student saved successfully";
    }

    @DeleteMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int studentId) {
        String responseMessage;
        try {
            Student student = studentService.findById(studentId);
            studentService.remove(student);
        } catch (Exception e) {
            String detailError;
            e.printStackTrace();
            responseMessage = "Error deleting student. Detail Error=>" + "\n";
            detailError = responseMessage + e.getMessage();
            return responseMessage + detailError;
        }
        return "Student deleted successfully";
    }
}