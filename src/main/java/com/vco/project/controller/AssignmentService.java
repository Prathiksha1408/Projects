package com.vco.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vco.project.model.Assignment;
import com.vco.project.model.Student;
import com.vco.project.model.Teacher;
import com.vco.project.practical.ResponsePayload;
import com.vco.project.repository.AssignmentRepository;
import com.vco.project.repository.StudentRepository;
import com.vco.project.repository.TeacherRepository;

@Service
public class AssignmentService {
	@Autowired
	private AssignmentRepository assignmentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private StudentRepository studentRepository;

	public Object saveAssignment(int teacherId,Assignment assignment,int stdId) {
		Assignment a1=null;
		try {
			Optional<Teacher>t=teacherRepository.findById(teacherId);
			Teacher t1=t.get();
			System.out.println("*** TEACHER **** name "+t1.getTname()+" tid "+t1.getTid());
			assignment.setTeacher(t1);
			t1.getAssignments().add(assignment);
			Optional<Student>s=studentRepository.findById(stdId);
			Student s1=s.get();
			assignment.setStudent(s1);
			System.out.println("*** STUDENT **** name "+s1.getName()+" age is "+s1.getAge());
			s1.getAssignments().add(assignment);
			a1=assignmentRepository.save(assignment);
			
		}catch(Exception ex) {
			System.out.println("Excetpion is " + ex);
			return new ResponsePayload(HttpStatus.BAD_REQUEST.value(), "Failed", ex.getMessage());
		}
		return new ResponsePayload(HttpStatus.ACCEPTED.value(), "SUCCESS", a1);
	}
}

