package com.sms.studentManagementSystem.service;

import com.sms.studentManagementSystem.entity.Contact;
import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student save(Student student) {
        List<Contact> contactList = new ArrayList();
        contactList = student.getContacts().stream()
                .filter(
                        contact ->
                                (contact.getAddress() != null && !contact.getAddress().equals(""))
                                        || (contact.getPhone() != null && !contact.getPhone().equals(""))
                                        || (contact.getRelationship() != null && !contact.getRelationship().equals(""))
                                        || (contact.getEmail() != null && !contact.getEmail().equals(""))
                                        || (contact.getContactName() != null && !contact.getContactName().equals("")))
                .collect(Collectors.toList());

        student.setContacts(contactList);
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
