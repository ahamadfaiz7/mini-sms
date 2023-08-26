package com.sms.studentManagementSystem.service;

import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student save(Student student) {
        Student createdStudent;
        createdStudent = studentRepository.save(student);
        return createdStudent;
    }

}
