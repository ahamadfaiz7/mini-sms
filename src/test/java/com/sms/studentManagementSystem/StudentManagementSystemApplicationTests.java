package com.sms.studentManagementSystem;

import com.sms.studentManagementSystem.entity.Student;
import com.sms.studentManagementSystem.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		assertEquals(created.getStudentName(), getStudent().getStudentName());
	}

	@Test
	@DisplayName("Fetch Student Test ")
	void FetchUserTest() {
		List<Student> studentList = studentService.listAll();
		assertTrue(studentList.size() > 1 );
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

		return student;
	}

}
