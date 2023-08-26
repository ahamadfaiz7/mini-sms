package com.sms.studentManagementSystem.service;

import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
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

    public Student findById(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Transactional
    public void remove(Student student) {
        studentRepository.delete(student);
    }

}
