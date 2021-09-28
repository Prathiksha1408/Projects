package com.vco.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vco.project.model.Assignment;
import com.vco.project.model.Student;
import com.vco.project.model.Teacher;
import com.vco.project.repository.AssignmentRepository;
import com.vco.project.repository.StudentRepository;
import com.vco.project.repository.TeacherRepository;

@SpringBootTest
class Project1ApplicationTests {

	//@Test
//	void contextLoads() {
//	}
	@Autowired
	StudentRepository studentrep;
	
	@Test
	public void testCreate1() {
		Student s = new Student();
		s.setId(1);
		s.setName("Vidya");
		s.setAge(20);
		studentrep.save(s);
		assertNotNull(studentrep.findById(1).get());
	}
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Test
	public void testCreate2() {
		Teacher t = new Teacher();
		t.setTid(1);
		t.setTname("Manjunath");
		t.setMobile("9087658943");
		teacherRepository.save(t);
		assertNotNull(teacherRepository.findById(1).get());
	}
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@Test
	public void testCreate3() {
		Assignment a = new Assignment();
		a.setAid(1L);
		a.setName("Computer networks");
		a.setGrade(4);
		assignmentRepository.save(a);
		assertNotNull(assignmentRepository.findById(1).get());
	}
	
	
	
	

}
