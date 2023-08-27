package com.sms.studentManagementSystem.controller;

import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/students")
public class WebController {

    @Autowired
    StudentService studentService;
    List<String> errors = new ArrayList<>();

    @GetMapping("/showStudents")
    public String findAllStudents(Model model) {
        List<Student> students = studentService.listAll();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Student theStudent = new Student();
        model.addAttribute("theStudent", theStudent);
        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(Model model, @ModelAttribute("theStudent") @RequestBody Student student) {
        String responseMessage;
        try {
            studentService.save(student);
        } catch (Exception e) {
            String detailError;
            e.printStackTrace();
            if (e.getMessage().contains("Unique index or primary key violation")) {
                responseMessage = "Duplicate Student Number " + "\n";
                detailError = responseMessage + " Please enter a different unique student number";
            } else {
                responseMessage = "Error saving student. Detail Error=>" + "\n";
                detailError = responseMessage + e.getMessage();
            }
            errors.add(detailError);
            model.addAttribute("theStudent", student);
            return "student-form";
        }
        return "redirect:/students/showStudents";
    }

    @GetMapping("/remove/{id}")
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
        return "redirect:/students/showStudents";
    }

    @GetMapping("/showDetails/{id}")
    public String showDetails(Model model, @PathVariable("id") int studentId) {
        List<Student> students = new ArrayList<>();
        Student student = studentService.findById(studentId);
        students.add(student);
        model.addAttribute("students", students);
        return "student-detail";
    }

    @GetMapping("/showContacts/{id}")
    public String showContacts(Model model, @PathVariable("id") int studentId) {
        Student student = studentService.findById(studentId);
        model.addAttribute("contacts", student);
        return "student-contacts";
    }
}