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

    /**
     * Save/Update a specific student
     *
     * @param student
     * @return Student
     */
    public Student save(Student student) {
        Student createdStudent = null;
        List<Contact> contactList = new ArrayList();
        if (student != null && student.getStudentId() != null) {
            Student oldStudent = findById(student.getStudentId());
            if (oldStudent != null) {
                oldStudent.setStudentName(student.getStudentName());
                oldStudent.setStudentNumber(student.getStudentNumber());
                oldStudent.setAddress(student.getAddress());
                oldStudent.setDateOfBirth(student.getDateOfBirth());
                oldStudent.setStartingDate(student.getStartingDate());
                oldStudent.setLeavingDate(student.getLeavingDate());
                oldStudent.setGender(student.getGender());
                oldStudent.setContacts(student.getContacts());
                oldStudent.setCategory(student.getCategory());
                contactList = oldStudent.getContacts().stream()
                        .filter(contact -> (contact.getAddress() != null && !contact.getAddress().equals(""))
                                || (contact.getPhone() != null && !contact.getPhone().equals(""))
                                || (contact.getRelationship() != null && !contact.getRelationship().equals(""))
                                || (contact.getEmail() != null && !contact.getEmail().equals(""))
                                || (contact.getContactName() != null && !contact.getContactName().equals("")))
                        .collect(Collectors.toList());
                oldStudent.setContacts(contactList);
                createdStudent = studentRepository.save(oldStudent);
            }
        } else {
            contactList = student.getContacts().stream()
                    .filter(contact -> (contact.getAddress() != null && !contact.getAddress().equals(""))
                            || (contact.getPhone() != null && !contact.getPhone().equals(""))
                            || (contact.getRelationship() != null && !contact.getRelationship().equals(""))
                            || (contact.getEmail() != null && !contact.getEmail().equals(""))
                            || (contact.getContactName() != null && !contact.getContactName().equals("")))
                    .collect(Collectors.toList());

            student.setContacts(contactList);
            createdStudent = studentRepository.save(student);
        }
        return createdStudent;
    }

    /**
     * Finds specific student
     *
     * @param studentId
     * @return Student
     */
    public Student findById(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    /**
     * Delete a specific student
     *
     * @param student
     */
    @Transactional
    public void remove(Student student) {
        studentRepository.delete(student);
    }

}
