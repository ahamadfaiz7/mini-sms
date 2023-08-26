package com.sms.studentManagementSystem;

import com.sms.studentManagementSystem.entity.Category;
import com.sms.studentManagementSystem.entity.Contact;
import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StudentManagementSystemApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("Create Student Test ")
    void createUserTest() {
        Student created = studentService.save(getStudent());
        assertTrue(created != null);
        assertEquals(created.getStudentNumber(), getStudent().getStudentNumber());
    }

    @Test
    @DisplayName("Fetch Student Test ")
    void FetchUserTest() {
        List<Student> studentList = studentService.listAll();
        assertTrue(studentList.size() > 0);
    }

    private Student getStudent() {
        Student student = new Student();
        student.setStudentName("Faiz Anwar");
        student.setStudentNumber(56);
        student.setDateOfBirth(new Date());
        student.setGender("Male");
        student.setStartingDate(new Date());
        student.setLeavingDate(new Date());
        student.setAddress("Resaldar Nagar, India");

        Category category = new Category();
        category.setCategoryName("JUNIOR");
        student.setCategory(category);

        Contact contact = new Contact();
        List<Contact> contacts = new ArrayList<>();
        contact.setContactName("Mike");
        contact.setRelationship("BROTHER");
        contact.setEmail("ahamad.faiz007@gmail.com");
        contact.setAddress("145 Chivalry road");
        contact.setPhone("+641899955");
        contacts.add(contact);
        student.setContacts(contacts);


        return student;
    }

}
